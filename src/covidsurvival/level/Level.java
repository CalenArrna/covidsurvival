package covidsurvival.level;

import covidsurvival.level.Obstacles.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level {
    Tile[][] tiles;
    Image image;
    private ArrayList<Obstacle> obstacles;
    private ArrayList<Obstacle> interactables;

    public Level(int width, int height) {
        tiles = new Tile[width][height];
        image = Toolkit.getDefaultToolkit().getImage("res/open_tileset.png");
        int levelRowCount = 16;
        int levelColCount = 20;
        //Construct the tiles here
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (i < 16 && j < 9) {
                    tiles[i][j] = new Tile(0, 6, 1, 1);
                }else if (i < 16 && j < 13) {
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
        fillObstacles(levelRowCount,levelColCount);
        fillInteractables();
    }

    private void fillObstacles (int rowCount, int colCount) {
    //Construct the objects on Level
            obstacles = new ArrayList<>();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (col == 8 && (row == 6 || row == 1)) {
                    obstacles.add(new TwoTileWall(32*col, 32*row,0));
                }else if (row == 6 && (col < 8 && col > 0)) {
                    obstacles.add(new TwoTileWall(32*col, 32*row,3));
                }else if (row >= 6 && col == 8) {
                    obstacles.add(row == colCount-1 ? new TwoTileWall(32*col,32*row,0)
                            : new OneTileWall(32*col,32*row,1,6));
                }
                if (row == 0 && col == 7) obstacles.add(new Desk(32*col,32*row));
                if (row == 4 && col == 2) obstacles.add(new Carpet1(32*col,32*row));
                if (row == 0 && col == 2) obstacles.add(new Bed(32*col,32*row));
                if (row == 9 &&col == 14) obstacles.add(new Fridge(32*col,32*row));
            }
        }
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public void paint(Graphics2D g) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].paint(g, j, i);
            }
        }
    }

    private void fillInteractables () {
        interactables = new ArrayList<>();
        for (Obstacle obstacle : obstacles) {
            if (obstacle instanceof Interactable) {
                interactables.add(obstacle);
            }
        }
    }

    public ArrayList<Obstacle> getInteractables() {
        return interactables;
    }
}
