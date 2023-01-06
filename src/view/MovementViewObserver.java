package view;

import controller.CaseState;
import model.Color;
import model.MoveObserver;
import model.Position;
import model.piece.FactoryStrategy;
import model.piece.Piece;

import java.util.Scanner;

public class MovementViewObserver implements MoveObserver {
    private ChessboardView chessboardView;

    public MovementViewObserver(ChessboardView chessboardView) {
        this.chessboardView = chessboardView;
    }

    /**
     * Empty the cell of the old position.
     */
    @Override
    public void beforeMove(Position oldPosition, Position newPosition) {
        chessboardView.getCell(oldPosition).empty();
    }

    /**
     * Set the piece in the new position.
     */
    @Override
    public void afterMove(Position oldPosition, Position newPosition) {
        if (newPosition.getPiece().getLetter() == 'P' && newPosition.getRow() == 7 || newPosition.getPiece().getLetter() == 'P' && newPosition.getRow() == 0) {
            System.out.println("Choisissez avec qui vous voulez switch entre la Reine 'Q', le Fou 'B', la Tour 'R' et le Cavalier 'N': \n");
            FactoryStrategy f = new FactoryStrategy();
            Piece piece = f.createRook(newPosition.getPiece().getColor());
            Scanner sc = new Scanner(System.in);
            String np = sc.next();
            char nomPiece = np.charAt(0);
            if (nomPiece == 'R')
                piece = f.createRook(newPosition.getPiece().getColor());
            else if (nomPiece == 'Q')
                piece = f.createQueen(newPosition.getPiece().getColor());
            else if (nomPiece == 'B')
                piece = f.createBishop(newPosition.getPiece().getColor());
            else if (nomPiece == 'N')
                piece = f.createKnight(newPosition.getPiece().getColor());
            newPosition.setPiece(piece);
            chessboardView.getCase(newPosition).setPiece(piece.getLetter().toString());
        } else
            chessboardView.getCase(newPosition).setPiece(newPosition.getPiece().getLetter().toString());
    }
}
