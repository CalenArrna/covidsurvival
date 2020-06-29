package covidsurvival;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GameRunner {
    //TODO: Create interacts for objects
    //TODO: Change dialog rect to a nice img
    //TODO: Create a cat or a speakable NPC
    //TODO: Create a TV Show
    //TODO: Try out a Gif in the game
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
    //TODO: Get rid of Obstacles inheritance from Entity (sepatate living and not living things)


    public static Sound sound = new Sound();
    public static MainMenu mainMenu = new MainMenu();
    public static GameWindow gameWindow = new GameWindow();
    public static JFrame frame = new JFrame("CovidSurvival");

    public static void main(String[] args) {
        frame.add(mainMenu).setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public static void setGameWindow(GameWindow gameWindow) {
        frame.dispose();
        frame = new JFrame("CovidSurvival");
        GameRunner.gameWindow = gameWindow;
        frame.add(mainMenu).setBackground(Color.BLACK);
        frame.add(gameWindow).setBackground(Color.BLACK);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }
}
