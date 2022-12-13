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
        int[][] movements = pieceStrategy.getMovements(x, y);
        for (int i = 0; i < movements.length; i++) {
            if (movements[i][0] < 0 || movements[i][0] > 7 || movements[i][1] < 0 || movements[i][1] > 7)
                movements[i] = new int[]{-1, -1};

            if (movements[i][0] == x && movements[i][1] == y)
                movements[i] = new int[]{-1, -1};
        }

        return movements;
    }

    public void setStrategy(PieceStrategy pieceStrategy)
    {
        this.pieceStrategy = pieceStrategy;
    }

}
