package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class GlassDoor extends Obstacle {
    public GlassDoor(int x, int y) {
        super(x, y, 23, 7, 2, 1);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y, 64, 24);
    }

}
