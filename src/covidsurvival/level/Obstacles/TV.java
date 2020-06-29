package covidsurvival.level.Obstacles;

import covidsurvival.GameRunner;
import covidsurvival.GameWindow;
import covidsurvival.Option;
import covidsurvival.Sound;
import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static covidsurvival.Sound.gyorfi;
import static covidsurvival.Sound.tvStatic;

public class TV extends Obstacle implements Interactable { //TODO: fix the bug, that tv sound playing after leaving home...
    List<String> text = new ArrayList<>();
    public static boolean powerIsOn = false;


    public TV(int x, int y) {
        super(x, y, 3, 11, 1, 2);
        text.add("Television:");

    }

    public void powerSwitch() {
        powerIsOn = !powerIsOn;
    }

    public static boolean isPowerIsOn() {
        return powerIsOn;
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        rect.setBounds(x, y + 23, 31, 40);
        g.setColor(Color.BLACK);
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }

    @Override
    public void interact() {
        List<Option> list = new ArrayList<>();
        if (!powerIsOn) {
            list.add(new Option("Bekapcsolás.", () -> {
                System.out.println("Bekapcsoltad a TV-t, itt majd más fog történni!");
                powerSwitch();
                GameRunner.sound.playBGMSound(Sound.openSound(tvStatic));
            }));
            list.add(new Option("Távozás.", () -> System.out.println("Viszlát...ez majd semmi lesz")));
        } else {
            list.add(new Option("Válts csatornát.", () -> {
                System.out.println("Viszlát...ez majd semmi lesz");
                GameRunner.sound.stopLoop();
                GameRunner.sound.playBGMSound(Sound.openSound(gyorfi));
                GameRunner.showGif();
                GameRunner.frame.setVisible(true);
            }));
            list.add(new Option("Kikapcsolás.", () -> {
                System.out.println("Kikapcs.");
                GameRunner.sound.stopLoop();
                powerSwitch();
                GameRunner.hideGif();
            }));
            list.add(new Option("Távozás.", () -> System.out.println("Viszlát...ez majd semmi lesz")));
        }
        GameWindow.getDialog().show(text, list);
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}