package view;

import controller.CellState;
import controller.Party;
import model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Chessboard view.
 */
public class ChessboardView extends JFrame {
    private final Cell[][] cases = new Cell[8][8];

    private final JPanel chessboardPanel = new JPanel(new GridLayout(8, 8));

    public final CapturedView whiteCaptured = new CapturedView("White captured");
    public final CapturedView blackCaptured = new CapturedView("Black captured");

    public ChessboardView(Party party) {
        setTitle("Chessboard");
        setSize(900, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Init chessboard
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++) {
                Cell c = new Cell(party, x, y);
                cases[x][y] = c;
            }

        for (int i = 7; i >= 0; i--)
            for (int j = 7; j >= 0; j--)
                chessboardPanel.add(cases[i][j]);

        chessboardPanel.setSize(800, 800);
        add(chessboardPanel);

        // Init captured pieces
        JPanel capturedPanel = new JPanel(new GridLayout(2, 1));
        capturedPanel.setSize(100, 800);

        add(capturedPanel, BorderLayout.EAST);

        capturedPanel.add(blackCaptured);
        capturedPanel.add(whiteCaptured);

        capturedPanel.setLayout(new BoxLayout(capturedPanel, BoxLayout.Y_AXIS));
    }

    /**
     * Get the cell at the given position.
     * @param p position of the cell.
     * @return Cell at the given position.
     */
    public Cell getCell(Position p) {
        return cases[p.getRow()][p.getColumn()];
    }

    /**
     * Reset background color of all cells.
     */
    public void resetAllBackground() {
        for (Cell[] lines : cases)
            for (Cell c : lines)
                c.setState(CellState.DEFAULT);
    }
}
