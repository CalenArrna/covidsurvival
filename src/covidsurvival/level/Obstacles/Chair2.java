package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Chair2 extends Obstacle {
    public Chair2(int x, int y) {
        super(x, y, 13, 10, 1, 1);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);rect.setBounds(x+7,y+8,19,18);
    }

}
