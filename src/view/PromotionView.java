package view;

import controller.PromotionObserver;
import model.PlayerColor;
import model.piece.*;

import javax.swing.*;
import java.awt.*;

public class PromotionView extends JFrame {
    private final String[] pieces = {"queen", "rook", "bishop", "knight"};

    public PromotionView(PromotionObserver observer) {
        setLayout(new GridLayout(2, 2));

        setTitle("Promotion");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        for (String p : pieces) {
            JButton button = new JButton(p);
            button.addActionListener(e -> {
                observer.promote(p);
                dispose();
            });
            add(button);
        }
    }
}
