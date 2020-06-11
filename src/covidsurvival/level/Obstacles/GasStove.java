package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class GasStove extends Obstacle {
    public GasStove(int x, int y) {
        super(x, y, 3, 1, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y+18,32,43);
    }

}
