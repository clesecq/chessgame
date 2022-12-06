package model.piece;

import model.Position;

public interface Strategy {

   Character getLetter();

   Integer getPoints() throws Exception;
   Position[] getMovements();
}
