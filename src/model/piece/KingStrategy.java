package model.piece;

import model.Position;

public class KingStrategy implements PieceStrategy {
    @Override
    public Character getLetter() {
        return 'K';
    }

    @Override
    public Integer getPoints() throws Exception {
         throw new Exception("Le roi ne peut mourir");
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
