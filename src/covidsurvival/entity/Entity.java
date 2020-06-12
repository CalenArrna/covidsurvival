package covidsurvival.entity;

import java.awt.*;

public abstract class Entity {
    protected int x, y;
    protected Rectangle rect = new Rectangle();

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
    }

    public void draw(Graphics2D g2d) {

    }

    public Rectangle getRect() {
        return rect;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
