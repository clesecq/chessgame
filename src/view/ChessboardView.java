package view;

import controller.Party;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChessboardView extends JFrame {
    private final Party party;

    public ChessboardView(Party party) {
        this.party = party;

        setTitle("Chessboard");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                add(createLabel(i, j));

        setVisible(true);
    }

    private JLabel createLabel(int x, int y) {
        JLabel label = new JLabel();

        resetColor(label, x, y);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 50));
        label.setOpaque(true);

        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                party.clickOnCase(x, y);
            }
        });


        return label;
    }

    public void drawPosition(Position position) {
        JLabel label = getLabel(position);
        Character c = position.getPiece().getLetter();
        label.setText(c.toString());
    }

    public void resetColor(Position position) {
        if (position == null) {
            return;
        }

        JLabel label = getLabel(position);
        resetColor(label, position.getPosition()[0], position.getPosition()[1]);
    }

    public void resetColor(JLabel label, int x, int y) {
        if ((x + y) % 2 == 0) {
            label.setBackground(java.awt.Color.white);
            label.setForeground(java.awt.Color.black);
        } else {
            label.setBackground(java.awt.Color.black);
            label.setForeground(java.awt.Color.white);
        }
    }

    public void setColor(Position position, java.awt.Color color) {
        JLabel label = getLabel(position);
        label.setBackground(color);
    }

    private int positionToIndex(Position position) {
        return position.getPosition()[0] * 8 + position.getPosition()[1];
    }

    private JLabel indexToLabel(int index) {
        return (JLabel) getContentPane().getComponent(index);
    }

    public JLabel getLabel(Position position) {
        return indexToLabel(positionToIndex(position));
    }
}
