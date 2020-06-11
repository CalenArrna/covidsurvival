package covidsurvival.level.Obstacles;

import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;

public class Radio extends Obstacle implements Interactable {
    public Radio (int x, int y) {
        super(x, y, 3, 6, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(rect.x,rect.y,rect.width,rect.height);
    }

    @Override
    public void interact() {
        System.out.println("I'm the Radio");
    }
}
