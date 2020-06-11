package covidsurvival;

import covidsurvival.entity.Player;
import covidsurvival.level.Level;
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
    private Level level = new Home(70,28);
    private final Player player = new Player(level.playerStartingPosX, level.playerStartingPosY);
    private java.util.List<Obstacle> obstacles = new ArrayList<>();
    private java.util.List<Obstacle> interactables = new ArrayList<>();
    static Timer mainTimer;
    private static Dialog dialog = new Dialog();

    public GameWindow() {
        this.setFocusable(true);
        mainTimer = new Timer(16, this);
        mainTimer.start();
        addKeyListener(player);
        addKeyListener(dialog);
        obstacles = level.getObstacles();
        interactables = level.getInteractables();
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
        if (dialog.isVisiable) {
            dialog.paint(g2d);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!dialog.isVisiable) {
            player.update();
            player.move(obstacles);
            player.interact(interactables);
        }
        repaint();
    }

    public static Dialog getDialog() {
        return dialog;
    }
}
