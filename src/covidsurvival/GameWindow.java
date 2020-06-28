package covidsurvival;

import covidsurvival.entity.Player;
import covidsurvival.level.Level;
import covidsurvival.level.NPC;
import covidsurvival.level.Obstacle;
//import covidsurvival.level.levels.Corridor;
import covidsurvival.level.levels.Home;
import covidsurvival.level.levels.Street;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GameWindow extends JPanel implements ActionListener {

    private static final String NAME = "covidsurvival";
    public static final int HEIGHT = 980; //TODO : adapt to level size
    public static final int WIDTH = 1200;
    private static Level level;
    private static Player player;
    private static java.util.List<Obstacle> obstacles = new ArrayList<>();
    private static java.util.List<NPC> npc = new ArrayList<>();
    private static java.util.List<Obstacle> interactables = new ArrayList<>();
    public static Timer mainTimer;
    private static final Dialog dialog = new Dialog();

    public GameWindow() {
        level = new Home(70, 28);
        player = new Player(50, 150);
        this.setFocusable(true);
        addKeyListener(player);
        addKeyListener(dialog);
        obstacles = level.getObstacles();
        interactables = level.getInteractables();
        npc = level.getNPC();
        System.out.println("Fut a gameWindow");
        startTimer();
    }

    void startTimer() {
        mainTimer = new Timer(16, this);
        mainTimer.start();
    }

    public static void stopTimer() {
        mainTimer.stop();
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

    public static Level getLevel() {
        return level;
    }

    public static void setLevel(Level level) {
        GameWindow.level = level;
        obstacles = GameWindow.level.getObstacles();
        interactables = GameWindow.level.getInteractables();
        npc = GameWindow.level.getNPC();
        player.setX(GameWindow.level.playerStartingPosX);
        player.setY(GameWindow.level.playerStartingPosY);
        Sound.playSound(Sound.openSound(Sound.door));
    }

}
