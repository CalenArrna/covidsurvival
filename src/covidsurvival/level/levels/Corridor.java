package covidsurvival.level.levels;

import covidsurvival.level.Level;
import covidsurvival.level.Obstacles.Frontdoor;
import covidsurvival.level.Obstacles.OneTileWall;
import covidsurvival.level.Tile;

import java.util.ArrayList;

public class Corridor extends Level {


    public Corridor(int height, int width, Level from) {
        super(height, width);
        adjacentLevelList = new ArrayList<>();
        adjacentLevelList.add(from);
        playerStartingPosX = 150;
        playerStartingPosY = 150;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j] = new Tile(16, 15, 1, 1);
            }
        }
        fillObstacles(30, 30);
        fillInteractables();
    }

    @Override
    protected void fillObstacles(int rowCount, int colCount) {
        obstacles = new ArrayList<>();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if ((row == 16 && (col > 0 && col < 8) || row == 16 && (col > 8 && col < 11)
                        || row == 16 && (col == 12) || row == 16 && (col > 13 && col < 20))) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 6));
                }
                if (row == 16 && col == 11) obstacles.add(new Frontdoor(32 * col, 32 * row));
            }
        }
    }
}