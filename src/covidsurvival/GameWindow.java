package covidsurvival;

import covidsurvival.entity.Player;
import covidsurvival.level.Level;
import covidsurvival.level.Obstacle;
import covidsurvival.level.Obstacles.Carpet;
import covidsurvival.level.Obstacles.Desk;
import covidsurvival.level.Obstacles.Fridge;
import covidsurvival.level.Obstacles.Tree;

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
    private Level level = new Level(35,35);
    private final Player player = new Player(15, 200);
    private java.util.List<Obstacle> obstacles = new ArrayList<>();

    public GameWindow() {
        this.setFocusable(true);
        Timer mainTimer = new Timer(16, this);
        mainTimer.start();
        addKeyListener(player);
        obstacles.add(new Tree(150,150));
        obstacles.add(new Tree(200,200));
        obstacles.add(new Desk(10,10));
        obstacles.add(new Fridge(100,110));
        obstacles.add(new Carpet(500,30));

        //obstacles.add(new Obstacle(200,200,15,0,3,3));
    }


    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        level.paint(g2d);
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
