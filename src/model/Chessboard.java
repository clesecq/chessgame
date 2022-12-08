package model;

import model.piece.Piece;

import java.util.ArrayList;

public class Chessboard {

    private Position[][] board = new Position[8][8];
    private ArrayList<Piece> capturedPiece = new ArrayList<>();

    public Chessboard()
    {
        Character[][] initial = {
            { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' },
            // { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', 'B', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            // { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
        };

        model.piece.Factory f = new model.piece.Factory(board);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Position position = new Position(i, j);
                Piece piece;

                switch (initial[i][j]){
                    case 'R':
                        piece = f.createRook(Color.WHITE);
                        break;
                    case 'N':
                        piece = f.createKnight(Color.WHITE);
                        break;
                    case 'B':
                        piece = f.createBishop(Color.WHITE);
                        break;
                    case 'Q':
                        piece = f.createQueen(Color.WHITE);
                        break;
                    case 'K':
                        piece = f.createKing(Color.WHITE);
                        break;
                    case 'P':
                        piece = f.createPawn(Color.WHITE);
                        break;
                    case 'r':
                        piece = f.createRook(Color.BLACK);
                        break;
                    case 'n':
                        piece = f.createKnight(Color.BLACK);
                        break;
                    case 'b':
                        piece = f.createBishop(Color.BLACK);
                        break;
                    case 'q':
                        piece = f.createQueen(Color.BLACK);
                        break;
                    case 'k':
                        piece = f.createKing(Color.BLACK);
                        break;
                    case 'p':
                        piece = f.createPawn(Color.BLACK);
                        break;
                    default:
                        piece = null;
                        break;
                }


                position.setPiece(piece);
                board[i][j] = position;
            }
        }
    }

    public void addCapturedPiece(model.piece.Piece piece)
    {
        capturedPiece.add(piece);
    }

    public Position[][] getBoard() {
        return board;
    }
}
