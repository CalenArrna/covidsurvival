package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Desk extends Obstacle {
    public Desk(int x, int y) {
        super(x, y, 3, 12, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }
}
