package covidsurvival.level.Obstacles;

import covidsurvival.GameWindow;
import covidsurvival.Option;
import covidsurvival.Sound;
import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frontdoor extends Obstacle implements Interactable {
    private final int id;
    private final int playerX;
    private final int playerY;

    public Frontdoor(int x, int y, int id, int playerX, int playerY) {
        super(x, y, 9, 5, 1, 2);
        this.id=id;
        this.playerX = playerX;
        this.playerY = playerY;
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y,32,44);
    }

    @Override
    public void interact() {
        List<Option> list = new ArrayList<>();
        list.add(new Option("Kimegyek az ajtón.", () ->  {
            GameWindow.getLevel().setPlayerStartingPosition(playerX,playerY);
            GameWindow.setLevel(GameWindow.getLevel().getAdjacentLevelList().get(id));
        }));

        list.add(new Option("Maradok.", () -> System.out.println("Maradtál.")));
        GameWindow.getDialog().show(new ArrayList<>(), list);
    }
}
