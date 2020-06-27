package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class House1 extends Obstacle {
    public House1(int x, int y) {
        super(x, y, 33, 7, 2, 3);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y, 64, 96);
    }

}
