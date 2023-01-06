package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class CapturedView extends javax.swing.JPanel {
    private final JPanel capturedPanel = new JPanel(new GridLayout(8, 2));
    private final JLabel scoreLabel = new JLabel("0");

    public CapturedView(String title) {
        super(new BorderLayout());

        JLabel titleLabel = new JLabel(title);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);


        scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(scoreLabel, BorderLayout.SOUTH);

        add(capturedPanel, BorderLayout.CENTER);
        Dimension d = new Dimension(100, 400);
        setMinimumSize(d);
        setMaximumSize(d);
        setSize(d);
    }

    public void addPiece(String piecePath) {
        try {
            Image img = ImageIO.read(getClass().getClassLoader().getResource("picture/" + piecePath + ".png"));
            img = img.getScaledInstance(33, 33, Image.SCALE_SMOOTH);
            capturedPanel.add(new JLabel(new ImageIcon(img)));
        } catch (IOException e) {
            System.exit(1);
        }
    }

    public void addScore(int score) {
        scoreLabel.setText(String.valueOf(Integer.parseInt(scoreLabel.getText()) + score));
    }
}
