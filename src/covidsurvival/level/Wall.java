package covidsurvival.level;

import java.awt.*;

public class Wall extends Obstacle{
    private static final int DIAMETER = 30;
    int x = 330;
    int y = 400;
    int xa = 1;
    int ya = 1;

    public void paint(Graphics2D g) {
        g.drawImage(Toolkit.getDefaultToolkit().getImage("virus.png"),this.x,this.y,null);
    }

    public Wall(int x, int y, int row, int col, int width, int height, int x1, int y1, int xa, int ya) {
        super(x, y, row, col, width, height);
        this.x = x1;
        this.y = y1;
        this.xa = xa;
        this.ya = ya;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 57, 53);
    }
}
