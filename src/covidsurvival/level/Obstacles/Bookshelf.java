package covidsurvival.level.Obstacles;

import covidsurvival.GameWindow;
import covidsurvival.Option;
import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Bookshelf extends Obstacle implements Interactable {
    private final int id;
    public Bookshelf(int x, int y) {
        super(x, y, 3, 7, 2, 2);
        id = 1; //TODO: make id unique
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x,y,64,64);
    }

    @Override
    public void interact() {
        java.util.List<Option> list = new ArrayList<>();
        List<String> text = new ArrayList<>();
        list.add(new Option("Olvasok egy könyvet.", () -> System.out.println("Helló")));
        list.add(new Option("Inkább nem.", () -> System.out.println("Viszlát")));
        text.add("Ezen a polcon lévő könyvek: ");
        text.add("Dan Millman : Békésharcos útja");
        text.add("Osho : Meditáció");
        text.add("Angol-Magyar kisszótár");
        text.add("J.K Rowling : Harry Potter és a bölcsek köve ");
        text.add("J.R.R Tolkien : A Gyűrűk Ura");
        text.add("George Locke : A Technológia forradalma");
        text.add("PC-GURU 2020 májusi szám");
        text.add("Robert C. Martin : Clean Code");
        GameWindow.getDialog().show(text, list);
    }

}
