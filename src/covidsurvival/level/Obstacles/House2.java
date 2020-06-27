package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class House2 extends Obstacle {
    public House2(int x, int y) {
        super(x, y, 33, 9, 2, 3);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y,64,96);
    }

}
