package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class Toilette extends Obstacle {
    public Toilette(int x, int y) {
        super(x, y, 9, 0, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x+2,y+6,24,40);
    }

}
