package model;

import model.piece.FactoryStrategy;
import model.piece.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Chessboard {

    private Position[][] board = new Position[8][8];
    private ArrayList<Piece> capturedPiece = new ArrayList<>();

    public ArrayList<MoveObserver> moveObservers = new ArrayList<>();

    public Chessboard()
    {
        JFrame K = new JFrame("King-Noir");
        K.setSize(150,150);
        String KimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\black-king.png";
        ImageIcon Kicone = new ImageIcon(KimgUrl);
        Image Kimage = Kicone.getImage(); // transform it
        Image Knewimg = Kimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        Kicone = new ImageIcon(Knewimg);  // transform it back
        JLabel Kjlabel = new JLabel(Kicone, JLabel.CENTER);
        K.getContentPane().add(Kjlabel);
        K.validate();

        JFrame k = new JFrame("King-Blanc");
        k.setSize(150,150);
        String kimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\white-king.png";
        ImageIcon kicone = new ImageIcon(kimgUrl);
        Image kimage = kicone.getImage(); // transform it
        Image knewimg = kimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        kicone = new ImageIcon(knewimg);  // transform it back
        JLabel kjlabel = new JLabel(kicone, JLabel.CENTER);
        k.getContentPane().add(kjlabel);
        k.validate();

        JFrame N = new JFrame("Chevalier-Noir");
        N.setSize(150,150);
        String NimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\black-knight.png";
        ImageIcon Nicone = new ImageIcon(NimgUrl);
        Image Nimage = Nicone.getImage(); // transform it
        Image Nnewimg = Nimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        Nicone = new ImageIcon(Nnewimg);  // transform it back
        JLabel Njlabel = new JLabel(Nicone, JLabel.CENTER);
        N.getContentPane().add(Njlabel);
        N.validate();

        JFrame n = new JFrame("Chevalier-Blanc");
        n.setSize(150,150);
        String nimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\white-knight.png";
        ImageIcon nicone = new ImageIcon(nimgUrl);
        Image nimage = nicone.getImage(); // transform it
        Image nnewimg = nimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        nicone = new ImageIcon(nnewimg);  // transform it back
        JLabel njlabel = new JLabel(nicone, JLabel.CENTER);
        n.getContentPane().add(njlabel);
        n.validate();

        JFrame B = new JFrame("Fou-Noir");
        B.setSize(150,150);
        String BimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\black-Bishop.png";
        ImageIcon Bicone = new ImageIcon(BimgUrl);
        Image Bimage = Bicone.getImage(); // transform it
        Image Bnewimg = Bimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        Bicone = new ImageIcon(Bnewimg);  // transform it back
        JLabel Bjlabel = new JLabel(Bicone, JLabel.CENTER);
        B.getContentPane().add(Bjlabel);
        B.validate();

        JFrame b = new JFrame("Fou-Blanc");
        b.setSize(150,150);
        String bimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\white-bishop.png";
        ImageIcon bicone = new ImageIcon(bimgUrl);
        Image bimage = bicone.getImage(); // transform it
        Image bnewimg = bimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        bicone = new ImageIcon(bnewimg);  // transform it back
        JLabel bjlabel = new JLabel(bicone, JLabel.CENTER);
        b.getContentPane().add(bjlabel);
        b.validate();

        JFrame R = new JFrame("Tour-Noir");
        R.setSize(150,150);
        String RimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\black-rook.png";
        ImageIcon Ricone = new ImageIcon(RimgUrl);
        Image Rimage = Ricone.getImage(); // transform it
        Image Rnewimg = Rimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        Ricone = new ImageIcon(Rnewimg);  // transform it back
        JLabel Rjlabel = new JLabel(Ricone, JLabel.CENTER);
        R.getContentPane().add(Rjlabel);
        R.validate();

        JFrame r = new JFrame("Tour-blanc");
        r.setSize(150,150);
        String rimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\white-rook.png";
        ImageIcon ricone = new ImageIcon(rimgUrl);
        Image rimage = ricone.getImage(); // transform it
        Image rnewimg = rimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        ricone = new ImageIcon(rnewimg);  // transform it bacr
        JLabel rjlabel = new JLabel(ricone, JLabel.CENTER);
        r.getContentPane().add(rjlabel);
        r.validate();

        JFrame Q = new JFrame("Reine-Noir");
        Q.setSize(150,150);
        String QimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\black-queen.png";
        ImageIcon Qicone = new ImageIcon(QimgUrl);
        Image Qimage = Qicone.getImage(); // transform it
        Image Qnewimg = Qimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        Qicone = new ImageIcon(Qnewimg);  // transform it back
        JLabel Qjlabel = new JLabel(Qicone, JLabel.CENTER);
        Q.getContentPane().add(Qjlabel);
        Q.validate();

        JFrame q = new JFrame("Reine-Blanc");
        q.setSize(150,150);
        String qimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\white-queen.png";
        ImageIcon qicone = new ImageIcon(qimgUrl);
        Image qimage = qicone.getImage(); // transform it
        Image qnewimg = qimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        qicone = new ImageIcon(qnewimg);  // transform it back
        JLabel qjlabel = new JLabel(qicone, JLabel.CENTER);
        q.getContentPane().add(qjlabel);
        q.validate();

        JFrame P = new JFrame("Reine-Noir");
        P.setSize(150,150);
        String PimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\black-pawn.png";
        ImageIcon Picone = new ImageIcon(PimgUrl);
        Image Pimage = Picone.getImage(); // transform it
        Image Pnewimg = Pimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        Picone = new ImageIcon(Pnewimg);  // transform it back
        JLabel Pjlabel = new JLabel(Picone, JLabel.CENTER);
        P.getContentPane().add(Pjlabel);
        P.validate();

        JFrame p = new JFrame("Point-blanc");
        p.setSize(150,150);
        String pimgUrl="C:\\Users\\pettv\\a31-chessgame\\src\\model\\picture\\white-pawn.png";
        ImageIcon picone = new ImageIcon(pimgUrl);
        Image pimage = picone.getImage(); // transform it
        Image pnewimg = pimage.getScaledInstance(110, 110,  Image.SCALE_AREA_AVERAGING); // scale it the smooth way
        picone = new ImageIcon(pnewimg);  // transform it back
        JLabel pjlabel = new JLabel(picone, JLabel.CENTER);
        p.getContentPane().add(pjlabel);
        p.validate();






        Character[][] initial = {
            { 'R', 'N', 'B', 'Q', 'K', 'B', 'N', 'R' },
            { 'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { 'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p' },
            { 'r', 'n', 'b', 'q', 'k', 'b', 'n', 'r' },
        };

        FactoryStrategy f = new FactoryStrategy();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Piece piece;
                Character letter = initial[i][j];

                switch (letter){
                    case 'R', 'r' -> piece = f.createRook('R' == letter ? Color.WHITE : Color.BLACK);
                    case 'N', 'n' -> piece = f.createKnight('N' == letter ? Color.WHITE : Color.BLACK);
                    case 'B', 'b' -> piece = f.createBishop('B' == letter ? Color.WHITE : Color.BLACK);
                    case 'Q', 'q' -> piece = f.createQueen('Q' == letter ? Color.WHITE : Color.BLACK);
                    case 'K', 'k' -> piece = f.createKing('K' == letter ? Color.WHITE : Color.BLACK);
                    case 'P', 'p' -> piece = f.createPawn('P' == letter ? Color.WHITE : Color.BLACK);
                    default -> piece = null;
                }

                Position position = new Position(i, j);
                position.setPiece(piece);
                board[i][j] = position;
            }
        }
    }

    public void addCapturedPiece(Piece piece)
    {
        capturedPiece.add(piece);
    }

    public Position[][] getBoard() {
        return board;
    }

    public Position[] getMovements(Position position) {
        Position[] positions = new Position[]{};
        Piece piece = position.getPiece();
        int i = 0, j = 0;

        if (piece != null) {
            int[][] movements = piece.getMovements(position.getRow(), position.getColumn());

            positions = new Position[movements.length];
            while (i < movements.length) {
                if (movements[i] == null)
                    break;

                if (movements[i][0] == -1 && movements[i][1] == -1) {
                    i++;
                    continue;
                }

                Position potentialPosition = board[movements[i][0]][movements[i][1]];

                if (potentialPosition.getPiece() != null) {
                    if (potentialPosition.getPiece().getColor() != piece.getColor()) {
                        positions[j++] = potentialPosition;
                    }

                    i++;
                    while (i < movements.length && !Arrays.equals(movements[i], new int[]{-1, -1}))
                        i++;
                } else {
                    positions[j++] = potentialPosition;
                    i++;
                }
            }
        }

        return Arrays.copyOf(positions, j);
    }

    public void movePiece(Position from, Position to)
    {
        for (MoveObserver moveObserver : moveObservers)
            moveObserver.beforeMove(from, to);

        to.setPiece(from.getPiece());
        from.setPiece(null);

        for (MoveObserver moveObserver : moveObservers)
            moveObserver.afterMove(from, to);
    }
}
