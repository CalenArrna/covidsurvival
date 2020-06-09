package covidsurvival.level.Obstacles;

import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;

public class TV extends Obstacle implements Interactable {
    public TV (int x, int y) {
        super(x, y, 3, 11, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }

    @Override
    public void interact() {
        System.out.println("Im TV");
    }
}
