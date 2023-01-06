package view;

import controller.CaseState;
import controller.Party;
import model.*;

import javax.swing.*;
import java.awt.*;

public class ChessboardView extends JFrame {
    final Party party;

    public ChessboardView(Party party) {
        this.party = party;

        setTitle("Chessboard");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));

        for (int x = 0; x < 8; x++)
            for (int y = 0; y < 8; y++)
                add(new Case(party, x, y));
    }

    public Case getCase(Position position) {
        return (Case) getContentPane().getComponent(position.getRow() * 8 + position.getColumn());
    }


    public void resetAllBackground() {
        for (int i = 0; i < 64; i++)
            ((Case) getContentPane().getComponent(i)).set(CaseState.DEFAULT);
    }
}
