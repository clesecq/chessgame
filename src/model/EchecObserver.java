package model;

import model.piece.Piece;
import view.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EchecObserver  implements MoveObserver {
    private Chessboard chessboard;
    private boolean echec;
    private PlayerColor echecColor;
    public EchecObserver(Chessboard chessboard) {
        this.chessboard = chessboard;
    }


    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {


    }
    /**
     * Do nothing.
     */
    @Override
    public void afterMove(Position oldPosition, Position newPosition) {
        Position[][] pos = chessboard.getBoard();
        Piece pieceAdverse = null;
      //  System.out.println(newPosition.getPiece().getPlayerColor());
        ArrayList<int[]> doubleTest = new ArrayList<int[]>();
        int[] test = new int[2];
        test[0] = 8;
        test[1] = 8;
        Position posKing = pos[0][0];
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (pos[x][y].getPiece() != null && pos[x][y].getPiece().getLetter() == 'K' && pos[x][y].getPiece().getPlayerColor() != newPosition.getPiece().getPlayerColor())
                    posKing = pos[x][y];

            }
        }
       // System.out.println("X du roi :"+posKing.getRow()+" Y du roi : "+posKing.getColumn()+" couleur : "+posKing.getPiece().getPlayerColor());
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (pos[x][y].getPiece() != null && pos[x][y].getPiece().getPlayerColor() == newPosition.getPiece().getPlayerColor()) {
                    pieceAdverse = pos[x][y].getPiece();
                    //System.out.println(pieceAdverse.getLetter() + " : X de la piece :" + x + " Y de la piece : " + y + " couleur : " + pieceAdverse.getPlayerColor());

                    for (int i = 0; i < pieceAdverse.getMovements(x, y).length; i++) {
                        for (int j = 0; j < 2; j++) {
                            test[j] = pieceAdverse.getMovements(x,y)[i][j];

                            if (test[0] == posKing.getRow() && test[1] == posKing.getColumn()) {
                                doubleTest.add(test);
                              //  System.out.println(pieceAdverse.getLetter()+"  test[0] : "+test[0]+" test 1 : "+test[1]+" color : "+pieceAdverse.getPlayerColor());

                            } /*else if (test[0] == posKing.getRow() + 1 && test[1] == posKing.getColumn())
                                doubleTest.add(test);
                            else if (test[0] == posKing.getRow() && test[1] == posKing.getColumn() + 1)
                                doubleTest.add(test);
                            else if (test[0] == posKing.getRow() + 1 && test[1] == posKing.getColumn() + 1)
                                doubleTest.add(test);
                            else if (test[0] == posKing.getRow() - 1 && test[1] == posKing.getColumn() + 1)
                                doubleTest.add(test);
                            else if (test[0] == posKing.getRow() + 1 && test[1] == posKing.getColumn() - 1)
                                doubleTest.add(test);
                            else if (test[0] == posKing.getRow() - 1 && test[1] == posKing.getColumn())
                                doubleTest.add(test);
                            else if (test[0] == posKing.getRow() - 1 && test[1] == posKing.getColumn() - 1)
                                doubleTest.add(test);
                            else if (test[0] == posKing.getRow() && test[1] == posKing.getColumn() - 1)
                                doubleTest.add(test);*/
                        }
                        test[0] = 8;
                        test[1] = 8;
                    }
                }
                }

            }
        if(!doubleTest.isEmpty())
        {
            JFrame f = new JFrame("Echec");
            //Créer le JPanel
            JPanel panel = new JPanel();
            JLabel label = new JLabel("Echec du joueur : " + posKing.getPiece().getPlayerColor(), JLabel.CENTER);
            //Ajouter l'étiquette au frame
            //Spécifier la position et la taille du JPanel
            panel.setBounds(0, 0, 200, 200);
            //Spécifier la couleur d'arrière-plan du JPanel
            panel.setBackground(Color.lightGray);
            //Créer le bouton 1
            JButton btn1 = new JButton("Ok");
            //Spécifier la position et la taille du bouton
            btn1.setBounds(150, 150, 80, 30);
            //Spécifier la couleur d'arrière-plan du bouton
            btn1.setBackground(Color.WHITE);
            btn1.addActionListener(actionEvent -> {
                f.dispose();
            });
            //Ajouter les deux boutons au JPanel
            panel.add(label);
            panel.add(btn1);
            //Ajouter le JPanel au JFrame
            f.add(panel);
            f.setSize(200, 200);
            f.setLayout(null);
            f.setVisible(true);
            echec = true;
            echecColor = posKing.getPiece().getPlayerColor();
        }
    }
}
