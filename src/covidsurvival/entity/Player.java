package covidsurvival.entity;

import covidsurvival.GameWindow;
import covidsurvival.level.Obstacle;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class Player extends Entity implements KeyListener {
    private int velX = 0, velY = 0;
    private int frameWidth = 36, frameHeight = 52;
    private int frameNumber = 3;
    private int actualFrame = 0;
    private int frameDelay = 10;
    private int countFrames = 0;
    private int direction = 2;
    private Image image;

    public Player(int x, int y) {
        super(x, y);
        rect = new Rectangle(x, y, frameWidth, frameHeight);
       image = Toolkit.getDefaultToolkit().getImage("res/frichim.png");
    }

    public void update() {
        countFrames++;
        if (countFrames >= frameDelay) {
            if (velY != 0 || velX != 0) {
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
        int frameX = actualFrame * frameWidth;

        if (velY < 0) direction = 0;
        else if (velY > 0) direction = 2;
        else if (velX < 0) direction = 3;
        else if (velX > 0) direction = 1;

        int frameY = direction * frameHeight;
        g2d.drawImage(image, this.x, this.y, x + frameWidth, y + frameHeight, frameX, frameY, frameX + frameWidth, frameY + frameHeight, null);
    }

    public void move (List<Obstacle> obstacles) {
        int xPred = x, yPred = y;

        if (y + velY > 0 && y + velY < GameWindow.HEIGHT - 80) {
            yPred += velY;
        }
        if (x + velX > 0 && x + velX < GameWindow.WIDTH - 50) {
            xPred += velX;
        }
        Rectangle predrect = new Rectangle(xPred,yPred,frameWidth,frameHeight);
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
        rect.setBounds(x, y, rect.width, rect.height);
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            velY = -2;
        } else if (key == KeyEvent.VK_LEFT) {
            velX = -2;
        } else if (key == KeyEvent.VK_DOWN) {
            velY = 2;
        } else if (key == KeyEvent.VK_RIGHT) {
            velX = 2;
        }
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) {
            velY = 0;
        } else if (key == KeyEvent.VK_LEFT) {
            velX = 0;
        } else if (key == KeyEvent.VK_DOWN) {
            velY = 0;
        } else if (key == KeyEvent.VK_RIGHT) {
            velX = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
