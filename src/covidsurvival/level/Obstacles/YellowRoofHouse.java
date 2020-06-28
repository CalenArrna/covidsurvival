package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class YellowRoofHouse extends Obstacle {
    public YellowRoofHouse(int x, int y) {
        super(x, y, 29, 0, 4, 4);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y, 128, 128);
    }

}
