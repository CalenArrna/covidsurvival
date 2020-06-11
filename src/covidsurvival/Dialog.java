package covidsurvival;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class Dialog implements KeyListener {
    boolean isVisiable = false;
    private String text;
    private List<String> MultilineText;
    private List<Option> options;
    private int selected;
    private int width = 400;
    private int height = 150;


    void paint(Graphics2D g) {
        Font font = new Font("arial", Font.BOLD, 14);
        g.setFont(font);
        int windowX = GameWindow.WIDTH / 2 - 200 / 2;
        int windowY = GameWindow.HEIGHT / 2 - 200 / 2;
        g.drawRect(windowX, windowY, width, height);
        g.setColor(Color.WHITE);
        g.fillRect(windowX, windowY, width, height);
        g.setColor(Color.BLACK);
        g.drawString(text, windowX + 10, windowY + 20);
        int y = 52;
        int i = 0;
        for (Option option : options) {
            if (selected == i) {
                g.fillRect(windowX+5, windowY+y-10,10,10);
            }
            g.drawString(option.title, windowX + 20, windowY + y);
            y+=15;
            i++;
        }
    }

    public void show(String text, List<Option> answers) {
        this.text = text;
        options = answers;
        isVisiable = true;
    }

    public void hide() {
        isVisiable = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!isVisiable) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            selected = (selected + 1) % options.size();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            selected = (selected - 1 + options.size()) % options.size();
        } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
           options.get(selected).action.execute();
           hide();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }

    public boolean isVisiable() {
        return isVisiable;
    }
}
