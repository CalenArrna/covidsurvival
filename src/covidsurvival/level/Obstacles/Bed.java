package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Bed extends Obstacle {
    public Bed(int x, int y) {
        super(x, y, 3, 13, 2, 3);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x+2,y+7,60,88);
    }

}
