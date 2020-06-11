package covidsurvival.level.Obstacles;

import covidsurvival.level.Obstacle;

import java.awt.*;

public class MirroredSink extends Obstacle {
    public MirroredSink(int x, int y) {
        super(x, y, 9, 1, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(rect.x,rect.y,rect.width,rect.height);
    }

}
