import javax.swing.*;
import java.awt.*;

public class Game {

    private static final String NAME ="CovidSurvival" ;
    public static final int HEIGHT = 256;
    public static final int WIDTH = 455;

    public static void main(String[] args) {

        JFrame frame = new JFrame(Game.NAME);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        
    }
}
