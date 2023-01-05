package model.piece;

import model.Color;
import model.Position;

public class KnightStrategy implements PieceStrategy {
    @Override
    public Character getLetter() {
        return 'N';
    }

    @Override
    public Integer getPoints() {
        return 3;
    }

    @Override
    public int[][] getMovements(int x, int y) {

        int[][] movements = new int[8][2];
        if(x<6 && y<7)
            movements[1] = new int[]{x+2,y+1};
        if(x<6 && y>0)
            movements[2] = new int[]{x+2,y-1};
        if(x>1 && y<7)
            movements[3] = new int[]{x-2,y+1};
        if(x>1 && y>0)
            movements[4] = new int[]{x-2,y-1};
        if(x<7 && y<6)
            movements[5] = new int[]{x+1,y+2};
        if(x<6 && y>1)
            movements[6] = new int[]{x+1,y-2};
        if(x>0 && y<6)
            movements[7] = new int[]{x-1,y+2};
        if(x>0 && y>1)
            movements[0] = new int[]{x-1,y-2};
        System.out.println("x égale : " +x+"y égale : "+y);
        return movements;

    }
}
