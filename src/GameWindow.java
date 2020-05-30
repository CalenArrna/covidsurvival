import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JFrame{

    private static final String NAME ="CovidSurvival" ;
    public static final int HEIGHT = 256;
    public static final int WIDTH = 455;

    public GameWindow () {
        super(NAME);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK);
    }

    public static void main(String[] args) {
       new GameWindow().setVisible(true);

        
    }
    public void paint(Graphics g) {
       super.paint(g);
        BufferedImage image = null;
        try {
          image = ImageIO.read(new File("res/frichim.png"));
          g.drawImage(image, 150,150, null);
        } catch (IOException e) {
           System.out.println(e.getMessage());
       }
    }

/*    private void gameEvents() {
        this.addKeyListener();
    }*/
}
