package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Carpet extends Obstacle {
    public Carpet(int x, int y) {
        super(x, y, 5, 10, 3, 2);
        rect = new Rectangle();
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }
}
