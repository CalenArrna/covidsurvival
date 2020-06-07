package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Carpet2 extends Obstacle {
    public Carpet2(int x, int y) {
        super(x, y, 9, 6, 4, 3);
        rect = new Rectangle();
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }
}

