package covidsurvival.level;

import java.awt.*;

public class Tile {
    private static int tileWidth = 32;
    private static int tileHeight = 32;
    private int row;
    private int col;
    private int width;
    private int height;
    Image image;


    public Tile(int row, int col, int width, int height, Image image) {
        this.row = row;
        this.col = col;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public void paint(Graphics2D g, int x, int y) {
    g.drawImage(image,x*tileWidth,y*tileHeight,x*tileWidth+tileWidth,y*tileHeight+tileHeight,
            col*tileWidth,row*tileHeight,col*tileWidth+tileWidth,row*tileHeight+tileHeight,null);
    }

}
