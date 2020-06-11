package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Table2 extends Obstacle {
    public Table2 (int x, int y) {
        super(x, y, 3, 2, 2, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y+21,64,40);
    }

}
