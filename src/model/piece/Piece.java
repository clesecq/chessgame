package model.piece;

import model.Position;

import java.awt.Color;

public class Piece {

    private Color color ;

    private Position position;

    private Strategy strategy;

    private Integer points ;

    private Character letter ;

    public Piece(){}

    public Color getColor()
    {
        return this.color;
    }
    public Integer getPoints() throws Exception {
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
