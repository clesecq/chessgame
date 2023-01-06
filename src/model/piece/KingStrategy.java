package model.piece;

import model.Position;

public class KingStrategy implements PieceStrategy {
    @Override
    public String getName() {
        return "king";
    }

    @Override
    public Integer getPoints() {
        // is imposible to get the points of a king
         return Integer.MIN_VALUE;
    }

    @Override
    public int[][] getMovements(int x, int y) {
        int[][] movements = new int[18][2];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                movements[i * 6 + j * 2] = (i == 1 && j == 1) ? new int[]{-1, -1} : new int[]{x - 1 + i, y - 1 + j};
                movements[i * 6 + j * 2 + 1] = new int[]{-1, -1};
            }
        }

        return movements;
    }

}
