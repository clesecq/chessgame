package view;

import controller.Party;
import controller.CellState;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

/**
 * Cell view of the chessboard.
 */
public class Cell extends javax.swing.JLabel {
    /**
     * Default background color of the cell.
     */
    final private Color defaultColor;

    /**
     * Cell state.
     */
    private CellState state = CellState.DEFAULT;

    boolean isEmpty = true;
    JLabel imgLabel = new JLabel();


    public Cell(Party party, int x, int y) {
        add(imgLabel);
        imgLabel.setVisible(true);

        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (state == CellState.POSSIBLE)
                    party.moveCase(x, y); // if a move is possible, the cell is clicked to move the piece
                else
                    party.selectCase(x, y); // if no move is possible, the cell is clicked to select a piece
            }
        });

        // Define default background color and set it
        this.defaultColor = x % 2 == y % 2 ? Color.WHITE : new Color(0x8B4513);
        empty();
        setForeground(java.awt.Color.gray);

        // Style of the cell
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setFont(new Font("Arial", Font.PLAIN, 50));
        setOpaque(true);
    }

    /**
     * Set the cell piece.
     * @param piecePath Path of the piece image.
     */
    public void setPiece(String piecePath) {
        try {
            setIcon(new ImageIcon(ImageIO.read(getClass().getClassLoader().getResource("picture/" + piecePath + ".png"))));
        } catch (IOException e) {
            System.exit(1);
        }
    }

    /**
     * Set the cell state.
     * @param state State of the cell.
     */
    public void setState(CellState state) {
        this.state = state;
        Color color;

        switch (state) {
            case SELECTED:
                color = Color.GRAY;
                break;
            case POSSIBLE:
                color = isEmpty() ? Color.GREEN : Color.RED;
                break;
            default:
                color = defaultColor;
        }

        setBackground(color);
    }

    /**
     * Check if the cell is empty.
     * @return True if the cell is empty, false otherwise.
     */
    public boolean isEmpty() {
        return getIcon() == null;
    }

    /**
     * Reset the cell state to default.
     */
    public void empty() {
        setIcon(null); // remove symbol
        setState(CellState.DEFAULT); // restore default background color
    }
}
