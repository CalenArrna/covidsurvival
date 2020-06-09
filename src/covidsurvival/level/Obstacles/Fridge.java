package covidsurvival.level.Obstacles;

import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;

public class Fridge extends Obstacle implements Interactable {
    public Fridge(int x, int y) {
        super(x, y, 3, 0, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
    }

    @Override
    public void interact() {
        System.out.println("Im Cold and freezed!");
    }
}
