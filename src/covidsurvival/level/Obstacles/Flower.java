package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Flower extends Obstacle {
    public Flower(int x, int y) {
        super(x, y, 5, 7, 1, 2);
    }

//    public Flower(int x, int y, int row, int col, int width, int height) {
//        super(x, y, row, col, width, height);
//    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x+5,y+34,22,20);
    }

}
