package covidsurvival.level;

import java.awt.*;

public class Level {
    Tile[][] tiles;
    Image image;

    public Level(int width, int height) {
        tiles = new Tile[width][height];
        image = Toolkit.getDefaultToolkit().getImage("res/open_tileset.png");
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (i < 16 && j < 9) {
                    tiles[i][j] = new Tile(0, 6, 1, 1);
                } else if (i < 16 && j < 13) {
                    tiles[i][j] = new Tile(0, 1, 1, 1);
                } else if (i < 8 && j < 20) {
                    tiles[i][j] = new Tile(0, 3, 1, 1);
                } else if (i < 16 && j < 20) {
                    tiles[i][j] = new Tile(0, 5, 1, 1);
                }
                else {
                    if (j % 2 == 0) {
                        tiles[i][j] = new Tile(16, 14, 1, 1);
                    } else {
                        tiles[i][j] = new Tile(16, 15, 1, 1);
                    }
                }
            }
        }
    }

    public void paint(Graphics2D g) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].paint(g, j, i);
            }
        }
    }
}
