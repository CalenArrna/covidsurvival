package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class TwoTileWall extends Obstacle {
    int part;
    public TwoTileWall(int x, int y, int part) {
        super(x, y, 1, part, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }
}
