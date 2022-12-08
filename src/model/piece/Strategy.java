package model.piece;

import model.*;

public interface Strategy {

   Character getLetter();

   Integer getPoints() throws Exception;
   Position[] getMovements(Position currentPosition);
}
