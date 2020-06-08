package covidsurvival;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameRunner {

    public static void main(String[] args) {
        JFrame frame = new JFrame("CovidSurvival");
        frame.add(new GameWindow()).setBackground(Color.BLACK);
        frame.setSize(GameWindow.WIDTH, GameWindow.HEIGHT);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getPreferredSize();
    }
}
