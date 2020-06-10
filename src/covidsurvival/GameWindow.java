package covidsurvival;

import covidsurvival.entity.Player;
import covidsurvival.level.levels.Home;
import covidsurvival.level.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GameWindow extends JPanel implements ActionListener {

    private static final String NAME = "covidsurvival";
    public static final int HEIGHT = 1200; //TODO : adapt to level size
    public static final int WIDTH = 980;
    private ArrayList<BufferedImage> imageList = new ArrayList<>();
    private Home home = new Home(35,35);
    private final Player player = new Player(160, 160);
    private java.util.List<Obstacle> obstacles = new ArrayList<>();

    public GameWindow() {
        this.setFocusable(true);
        Timer mainTimer = new Timer(16, this);
        mainTimer.start();
        addKeyListener(player);
        obstacles = home.getObstacles();
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        home.paint(g2d);
        for (Obstacle obstacle : obstacles) {
            obstacle.paint(g2d);
        }
        player.draw(g2d);
    }

    public ArrayList<BufferedImage> getImageList() {
        return imageList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.update();
        player.move(obstacles);
        repaint();
    }
}
