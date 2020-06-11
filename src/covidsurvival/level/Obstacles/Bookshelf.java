package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Bookshelf extends Obstacle {
    public Bookshelf(int x, int y) {
        super(x, y, 3, 7, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y,64,64);
    }

}
