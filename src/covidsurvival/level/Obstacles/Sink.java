package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Sink extends Obstacle {
    public Sink(int x, int y) {
        super(x, y, 3, 4, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);rect.setBounds(x,y+18,64,42);
    }

}
