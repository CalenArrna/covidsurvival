package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class BlueWallPiece extends Obstacle {
    public BlueWallPiece(int x, int y) {
        super(x, y, 23, 5, 2, 1);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y + 30, 32, 24);
    }

}
