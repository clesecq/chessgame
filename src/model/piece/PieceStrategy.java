package model.piece;

import model.*;

public interface PieceStrategy {

   Character getLetter();

   Integer getPoints() throws Exception;
   int[][] getMovements(int x, int y);
}
