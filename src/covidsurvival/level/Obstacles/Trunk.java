package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Trunk extends Obstacle {
    public Trunk(int x, int y) {
        super(x, y, 16, 3, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        this.rect = new Rectangle(x + 15, y + 13, 30, 32);
    }
}
