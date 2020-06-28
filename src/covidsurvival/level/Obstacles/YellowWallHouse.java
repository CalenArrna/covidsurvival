package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class YellowWallHouse extends Obstacle {
    public YellowWallHouse(int x, int y) {
        super(x, y, 25, 4, 4, 4);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y + 20, 128, 110);
    }

}
