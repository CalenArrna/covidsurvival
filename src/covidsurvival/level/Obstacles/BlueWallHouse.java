package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class BlueWallHouse extends Obstacle {
    public BlueWallHouse(int x, int y) {
        super(x, y, 24, 0, 4, 5);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y, 128, 156);
    }

}
