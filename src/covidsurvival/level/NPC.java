package covidsurvival.level;
import covidsurvival.entity.Entity;

import java.awt.*;

public abstract class NPC extends Obstacle {

    public NPC(int x, int y, int row, int col, int width, int height) {
        super(x, y,row,col, width,height);
        tileWidth=36;
        tileHeight=52;
        image = Toolkit.getDefaultToolkit().getImage("res/dotty.png");
    }


    @Override
    public void paint(Graphics2D g) {
        g.drawImage(image,x,y,x+tileWidth*width,y+tileHeight*height,
                col*tileWidth,row*tileHeight,col*tileWidth+tileWidth*width,row*tileHeight+tileHeight*height,null);
    }
}
