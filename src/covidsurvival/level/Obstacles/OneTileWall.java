package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class OneTileWall extends Obstacle {
    public OneTileWall(int x, int y, int partX, int partY) {
        super(x, y, 1+partX, 4+partY, 1, 1);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }
}
