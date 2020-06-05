package covidsurvival.level;

import java.awt.*;

public class Level {
    Tile [][] tiles;
    Image image;

    public Level(int width, int height) {
        tiles = new Tile[width][height];
        image = Toolkit.getDefaultToolkit().getImage("res/open_tileset.png");
        for (int i = 0; i < tiles.length ; i++) {
            for (int j = 0; j < tiles[i].length ; j++) {
                if (j % 2 == 0) {
                    tiles[i][j] = new Tile(0,5,1,1,image);
                }else {
                    tiles[i][j] = new Tile(0,2,1,1,image);
                }
            }
        }
    }

    public void paint (Graphics2D g) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].paint(g,j,i);
            }
        }
    }
}
