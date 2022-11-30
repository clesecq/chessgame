package model;

import java.awt.*;
import java.awt.Color;

public class Piece {

    private Color color ;

    private Position position;

    private PieceStrategy strategy;

    private Integer points ;

    private Character letter ;

    public Piece(){}

    public Color getColor()
    {
        return this.color;
    }
    public Integer getPoints()
    {
        return strategy.getPoints();
    }
    public Character getLetter()
    {
        return strategy.getLetter();
    }
    public void move(Position oldPosition, Position newPosition)
    {
       this.position = newPosition;
    }
    public Position[] getMovements(Position currentPosition)
    {
        return strategy.getMovements();
    }

}
