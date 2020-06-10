package covidsurvival.level.Obstacles;

import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;

public class Fridge extends Obstacle implements Interactable {
    public Fridge(int x, int y) {
        super(x, y, 3, 0, 1, 2);
    }

    boolean isInteract = false;

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        if (isInteract) {
            drawInteract(g);
        }
    }

    @Override
    public void interact() {
        isInteract = true;
    }
    // System.out.println("Im Cold and freezed!");


    public void drawInteract(Graphics2D g) {
        Font font = new Font("arial", Font.BOLD, 16);
        g.setFont(font);
        g.drawRect(50, 50, 200, 50);
        g.setColor(Color.WHITE);
        g.fillRect(50, 50, 200, 50);
        g.setColor(Color.BLACK);
        g.drawString("Im Cold and freezed!", 60, 80);
    }
}
