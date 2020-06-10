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
    private Level level = new Level(35, 35);
    private final Player player = new Player(200, 450);
    private java.util.List<Obstacle> obstacles = new ArrayList<>();
    private java.util.List<Obstacle> interactables = new ArrayList<>();
    static Timer mainTimer;

    public GameWindow() {
        this.setFocusable(true);
        mainTimer = new Timer(16, this);
        mainTimer.start();
        addKeyListener(player);
        obstacles = level.getObstacles();
        interactables = level.getInteractables();
        if (interactables == null) {
            System.out.println("Gameben is null");
        } else {
            System.out.println(interactables.get(0));
        }
        obstacles.add(new Chair1(205, 25));
        obstacles.add(new Bookshelf(320, 0));
        obstacles.add(new Radio(10, 5));
        obstacles.add(new Flower(10, 220));
        obstacles.add(new Telephone(5, 480));
        obstacles.add(new TV(100, 220));
        obstacles.add(new Bookshelf2(190, 240));
        obstacles.add(new Carpet2(55, 330));
        obstacles.add(new Couch(80, 480));
        obstacles.add(new Candles(235, 450));
        obstacles.add(new Frontdoor(335, 465));
        obstacles.add(new Table2(460, 260));
        obstacles.add(new GasStove(530, 260));
        obstacles.add(new Sink(570, 260));
        obstacles.add(new Table1(510, 380));
        obstacles.add(new Chair2(480, 395));
        obstacles.add(new Chair2(570, 395));
        obstacles.add(new Chair2(525, 352));
        obstacles.add(new Chair2(525, 435));
        obstacles.add(new Flower(440, 450));
        obstacles.add(new Carpet2(495, 145));
        obstacles.add(new Toilette(435, 200));
        obstacles.add(new Shower(550, 10));
        obstacles.add(new MirroredSink(450, 10));
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
        player.interact(interactables);
        repaint();
    }

    public static void drawThePopUpWindow(Graphics2D g, int width, int height, String text,
                                          String answ1, String answ2, String answ3, String answ4) {

        mainTimer.stop();
        Font font = new Font("arial", Font.BOLD, 14);
        g.setFont(font);
        int windowX = WIDTH / 2 - width / 2;
        int windowY = HEIGHT / 2 - height / 2;
        g.drawRect(windowX, windowY, width, height);
        g.setColor(Color.WHITE);
        g.fillRect(windowX, windowY, width, height);
        g.setColor(Color.BLACK);
        g.drawString(text, windowX + 10, windowY + 20);
        g.drawString(answ1, windowX + 20, windowY + 45);
        g.drawString(answ2, windowX + 20, windowY + 60);
        // if (!answ4 != null)) g.drawString(answ4, windowX+10, windowY+70);

        mainTimer.start();


    }
}
