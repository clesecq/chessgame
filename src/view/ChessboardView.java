package view;

import controller.CaseState;
import controller.Party;
import model.*;

import javax.swing.*;
import java.awt.*;

public class ChessboardView extends JFrame {
    final Party party;
    final Case[][] cases = new Case[8][8];

    public ChessboardView(Party party) {
        this.party = party;

        setTitle("Chessboard");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));

        // Init chessboard
        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++) {
                Case c = new Case(party, x, y);
                cases[x][y] = c;
                chessboardPanel.add(c);
            }
    }

    public Case getCase(Position p) {
        return cases[p.getRow()][p.getColumn()];
    }


    public void resetAllBackground() {
        for (Case[] lines : cases)
            for (Case c : lines)
                c.setState(CaseState.DEFAULT);
    }
}
