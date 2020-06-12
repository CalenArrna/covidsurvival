package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Candles extends Obstacle {
    public Candles (int x, int y) {
        super(x, y, 9, 10, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y+30,32,24);
    }

}
