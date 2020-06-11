package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Frontdoor extends Obstacle {
    public Frontdoor(int x, int y) {
        super(x, y, 9, 5, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y,32,44);
    }

}
