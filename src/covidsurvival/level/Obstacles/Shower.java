package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Shower extends Obstacle {
    public Shower(int x, int y) {
        super(x, y, 7, 4, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y+8,64,56);
    }

}
