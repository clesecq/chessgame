package model;

public interface PieceStrategy {

   Character getLetter();

   Integer getPoints();
   Position[] getMovements();
}
