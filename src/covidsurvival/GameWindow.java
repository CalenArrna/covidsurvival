package covidsurvival;

import covidsurvival.entity.Player;
import covidsurvival.level.Level;
import covidsurvival.level.Obstacle;
import covidsurvival.level.Obstacles.*;

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
    private final Player player = new Player(150, 110);
    private java.util.List<Obstacle> obstacles = new ArrayList<>();

    public GameWindow() {
        this.setFocusable(true);
        Timer mainTimer = new Timer(16, this);
        mainTimer.start();
        addKeyListener(player);
        obstacles = level.getObstacles();
        obstacles.add(new Chair1(205,25));
        obstacles.add(new Bookshelf(320,0));
        obstacles.add(new Radio(10,5));
        obstacles.add(new Fridge(420,260));
        obstacles.add(new Flower(10,220));
        obstacles.add(new Telephone(5,480));
        obstacles.add(new TV(100,220));
        obstacles.add(new Bookshelf2(190,240));
        obstacles.add(new Carpet2(55,330));
        obstacles.add(new Couch(80,480));
        obstacles.add(new Candles(235,450));
        obstacles.add(new Frontdoor(335,465));
        obstacles.add(new Table2(460,260));
        obstacles.add(new GasStove(530,260));
        obstacles.add(new Sink(570,260));
        obstacles.add(new Table1(510,380));
        obstacles.add(new Chair2(480,395));
        obstacles.add(new Chair2(570,395));
        obstacles.add(new Chair2(525,352));
        obstacles.add(new Chair2(525,435));
        obstacles.add(new Flower(440,450));
        obstacles.add(new Carpet2 (495,145));
        obstacles.add(new Toilette(435,200));
        obstacles.add(new Shower(550,10));
        obstacles.add(new MirroredSink(450,10));








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
