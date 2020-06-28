package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class BlueChair extends Obstacle {
    public BlueChair(int x, int y) {
        super(x, y, 10, 14, 1, 1);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x+5,y+3,20,23);
    }

}
