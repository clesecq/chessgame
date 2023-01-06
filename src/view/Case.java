package view;

import controller.Party;
import controller.CaseState;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Case extends javax.swing.JLabel {
    final private Color defaultColor;
    final private int x, y;

    private CaseState state = CaseState.DEFAULT;



    private Party party;


    public Case(Party party, int x, int y) {
        this.party = party;
        this.x = x;
        this.y = y;

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (state == CaseState.POSSIBLE)
                    party.moveCase(x, y);
                else
                    party.selectCase(x, y);
            }
        });

        this.defaultColor = x % 2 == y % 2 ? Color.WHITE : Color.BLACK;
        empty();
        setForeground(java.awt.Color.gray);

        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.PLAIN, 50));
        setOpaque(true);
    }

    public void setPiece(String piecePath) {
        setText(piecePath == null ? "" : piecePath);
    }

    public void setState(CaseState state) {
        this.state = state;

        setBackground(switch (state) {
            case SELECTED -> Color.GRAY;
            case POSSIBLE -> isEmpty() ? Color.GREEN : Color.RED;
            default -> defaultColor;
        });
    }

    public boolean isEmpty() {
        return getText().equals("");
    }

    public void empty() {
        setText("");
        setState(CaseState.DEFAULT);
    }
}
