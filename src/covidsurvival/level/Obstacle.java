package covidsurvival.level;

import covidsurvival.entity.Entity;

import java.awt.*;

public abstract class Obstacle extends Entity {
    private static int tileWidth = 32;
    private static int tileHeight = 32;
    private int row;
    private int col;
    private int width;
    private int height;
    static Image image;

    static {  image = Toolkit.getDefaultToolkit().getImage("res/open_tileset.png");
    }


    public Obstacle(int x, int y,int row, int col, int width, int height) {
        super(x, y);
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
        rect = new Rectangle(x,y,tileWidth*width,tileHeight*height);
    }
    public void paint(Graphics2D g) {
        g.drawImage(image,x,y,x+tileWidth*width,y+tileHeight*height,
                col*tileWidth,row*tileHeight,col*tileWidth+tileWidth*width,row*tileHeight+tileHeight*height,null);
    }
}
