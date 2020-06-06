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
                if (i < 7 && j < 10 ) {
                    tiles[i][j] = new Tile(0, 3, 1, 1);
                }else if (i < 7 && j < 25){
                    tiles[i][j] = new Tile(0, 6, 1, 1);
                    }
                else {
                    if (j % 2 == 0) {
                        tiles[i][j] = new Tile(0, 5, 1, 1);
                    } else {
                        tiles[i][j] = new Tile(0, 4, 1, 1);
                    }
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
