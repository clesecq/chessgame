package model.piece;

import model.*;

public class Piece {

    private Color color ;

    private Position position;

    private PieceStrategy pieceStrategy;

    private Integer points ;

    private Character letter ;

    public Piece(Color color){
        this.color = color;
    }

    public Color getColor()
    {
        return this.color;
    }
    public Integer getPoints() throws Exception {
        return pieceStrategy.getPoints();
    }
    public Character getLetter()
    {
        return pieceStrategy.getLetter();
    }

    public int[][] getMovements(int x, int y)
    {
        return pieceStrategy.getMovements(x, y);
    }

    public void setStrategy(PieceStrategy pieceStrategy)
    {
        this.pieceStrategy = pieceStrategy;
    }

}
