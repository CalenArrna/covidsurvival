package covidsurvival.entity;
import covidsurvival.level.NPC;
import java.awt.*;
public class Dotty extends NPC {
    public Dotty(int x, int y) {
        super(x, y, 1, 1, 1, 1);
        covidRect=new Rectangle(this.x-15, this.y-15, 90,90);
    }
    public Rectangle covidRect;
    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        this.rect = new Rectangle(x + 10, y + 40, 20, 10);
        covidRect.setBounds(this.x-25, this.y-18, 90,90);
        g.setColor(Color.GREEN);
        g.drawRect(covidRect.x, covidRect.y, covidRect.width, covidRect.height);
    }

    public Rectangle getCovidRect() {
        return covidRect;
    }
}