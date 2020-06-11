package covidsurvival;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameRunner {
    //TODO: Create interacts for objects
    //TODO: Fix Collosion
    //TODO: Fix dialog mark position
    //TODO: Change dialog rect to a nice img
    //TODO: Create a corridor map, for map change
    //TODO: Create a cat or a speakable NPC
    //TODO: Create a TV Show
    //TODO: Try out a Gif in the game
    //TODO: Can we play sounds? Music?
    //TODO: Test out the possibilities with this dialog box
    //TODO: Create a Covid level (health), when outside
    //TODO: Make the Rules of Covid level
    //TODO: Create the Game Over Method
    //TODO: Create a Game Menü
    //TODO: Create a simple tutorial KeyMapping and othersRU
    //TODO: Create a faceMaskedFrici bonus gloves
    //TODO: Create a better looking dialog window
    //TODO: Try to simplify code structure
    //TODO: Make outside level + at least 1 shop
    //TODO: Make a story

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
