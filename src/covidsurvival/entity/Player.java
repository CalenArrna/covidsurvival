package covidsurvival.entity;


import covidsurvival.CovidBar;
import covidsurvival.GameRunner;
import covidsurvival.GameWindow;
import covidsurvival.level.Interactable;
import covidsurvival.level.Obstacle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Player extends Entity implements KeyListener {
    private int velX = 0, velY = 0;
    private int actualFrame = 0;
    private int countFrames = 0;
    private int direction = 2;
    private final Image image;
    private Rectangle interactRect = new Rectangle();
    private CovidBar covidBar;

    public Player(int x, int y) {
        super(x, y);
        rect = new Rectangle(x + 10, y + 40, 20, 10);
        image = Toolkit.getDefaultToolkit().getImage("res/frichim.png");
        covidBar = new CovidBar();

    }

    public void setPlayerStartingPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void increaseCovid() {
        covidBar.setValue(20);
    }

    public void update() {
        countFrames++;
        int frameDelay = 10;
        if (countFrames >= frameDelay) {
            if (velY != 0 || velX != 0) {
                int frameNumber = 3;
                if (actualFrame + 1 < frameNumber) {
                    actualFrame++;
                } else {
                    actualFrame = 0;
                }
                countFrames = 0;
            }
        }
    }

    public void draw(Graphics2D g2d) {
        int frameWidth = 36;
        int frameX = actualFrame * frameWidth;

        if (velY < 0) direction = 0;
        else if (velY > 0) direction = 2;
        else if (velX < 0) direction = 3;
        else if (velX > 0) direction = 1;
        if (!interactRect.isEmpty()) {  //TODO DUBUG ONLY
            g2d.draw(interactRect);
        }
        int frameHeight = 52;
        int frameY = direction * frameHeight;
        g2d.drawImage(image, this.x, this.y, x + frameWidth, y + frameHeight, frameX, frameY, frameX + frameWidth, frameY + frameHeight, null);

        g2d.setColor(Color.RED);
        g2d.drawRect(rect.x, rect.y, rect.width, rect.height);
    }

    public void move(List<Obstacle> obstacles) {
        int xPred = x, yPred = y;

        if (y + velY > 0 && y + velY < GameWindow.HEIGHT - 80) {
            yPred += velY;
        }
        if (x + velX > 0 && x + velX < GameWindow.WIDTH - 50) {
            xPred += velX;
        }
        Rectangle predrect = new Rectangle(xPred + 7, yPred + 40, rect.width, rect.height);
        boolean isCollided = false;
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getRect().intersects(predrect)) {
                isCollided = true;
                break;
            }
        }
        if (!isCollided) {
            x = xPred;
            y = yPred;
        }
        rect.setBounds(x + 7, y + 40, rect.width, rect.height);
    }

    public void keyPressed(KeyEvent e) {
        if (GameWindow.getDialog().isVisiable()) {
            interactRect = new Rectangle();
            return;
        }
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            velY = -2;
        } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            velX = -2;
        } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            velY = 2;
        } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            velX = 2;
        } else if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
            switch (direction) {
                case 0 -> interactRect = new Rectangle(x + 12, y, 10, 10);
                case 1 -> interactRect = new Rectangle(x + 36, y + 23, 10, 10);
                case 2 -> interactRect = new Rectangle(x + 12, y + 45, 10, 10);
                case 3 -> interactRect = new Rectangle(x - 10, y + 23, 10, 10);
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        if (GameWindow.getDialog().isVisiable()) {
            interactRect = new Rectangle();
            return;
        }
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
            velY = 0;
        } else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            velX = 0;
        } else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            velY = 0;
        } else if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            velX = 0;
        } else if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
            interactRect = new Rectangle();
        } else if (key == KeyEvent.VK_ESCAPE) {
            GameRunner.mainMenu.setVisible(true);
            GameRunner.sound.stopLoop();
            GameWindow.stopTimer();
            covidBar.setVisible(false);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public CovidBar getCovidBar() {
        return covidBar;
    }

    public void setCovidBar(CovidBar covidBar) {
        this.covidBar = covidBar;
    }

    public void interact(List<Obstacle> interactables) {
        if (interactables != null) {
            for (Obstacle interactable : interactables) {
                if (interactRect.intersects(interactable.getRect())) {
                    ((Interactable) interactable).interact();
                    System.out.println("interact of OBject called"); //TODO debug only
                }
            }
        }
    }

}