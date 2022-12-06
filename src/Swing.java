
import javax.swing.*;
import java.awt.*;

public class Swing extends JFrame {
        public Swing() {
        setTitle("Chessboard");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 8));

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JLabel label = new JLabel();

                label.setOpaque(true);

                label.setBackground((i + j) % 2 == 0 ? Color.white : Color.black);
                add(label);
            }
        }
        setVisible(true);
    }
}
