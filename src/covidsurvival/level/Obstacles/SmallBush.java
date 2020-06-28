package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class SmallBush extends Obstacle {
    public SmallBush(int x, int y) {
        super(x, y, 18, 2, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        this.rect = new Rectangle(x + 16, y + 16, 32, 32);
    }
}
