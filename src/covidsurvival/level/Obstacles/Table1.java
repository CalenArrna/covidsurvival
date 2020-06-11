package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Table1 extends Obstacle {
    public Table1(int x, int y) {
        super(x, y, 13, 8, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y,64,60);
    }

}
