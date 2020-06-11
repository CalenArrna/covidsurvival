package covidsurvival.level.Obstacles;

import covidsurvival.GameWindow;
import covidsurvival.Option;
import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Fridge extends Obstacle implements Interactable {
    public Fridge(int x, int y) {
        super(x, y, 3, 0, 1, 2);
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.drawRect(rect.x,rect.y,rect.width,rect.height);

    }

    @Override
    public void interact() {
        List<Option> list = new ArrayList<>();
        list.add(new Option("Ezt fogjuk csinálni.", () -> System.out.println("Helló")));
        list.add(new Option("Nem ezt fogjuk csinálni.", () -> System.out.println("Viszlát")));

        GameWindow.getDialog().show("I'm the fridge", list);
    }
}
