package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class BigBush extends Obstacle {
    public BigBush(int x, int y) {
        super(x, y, 18, 0, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        this.rect = new Rectangle(x, y + 10, 58, 54);
    }
}
