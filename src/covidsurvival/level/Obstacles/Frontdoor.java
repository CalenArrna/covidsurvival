package covidsurvival.level.Obstacles;

import covidsurvival.GameWindow;
import covidsurvival.Option;
import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frontdoor extends Obstacle implements Interactable {
    private final int id;

    public Frontdoor(int x, int y) {
        super(x, y, 9, 5, 1, 2);
        id = 1; //TODO: create uniqe per level, to assiciate with different level loads
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }

    @Override
    public void interact() {
        List<Option> list = new ArrayList<>();
        list.add(new Option("Kimegyek az ajtón.", () -> GameWindow.setLevel(GameWindow.getLevel().getAdjacentLevelList().get(0))));
        list.add(new Option("Maradok.", () -> System.out.println("Maradtál.")));
        GameWindow.getDialog().show("", list);
    }
}
