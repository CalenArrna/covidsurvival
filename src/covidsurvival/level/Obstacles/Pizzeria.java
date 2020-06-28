package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Pizzeria extends Obstacle {
    public Pizzeria(int x, int y) {
        super(x, y, 34, 5, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y, 64, 64);
    }

}
