package covidsurvival.level.levels;

import covidsurvival.Sound;
import covidsurvival.level.Level;
import covidsurvival.level.Obstacles.*;
import covidsurvival.level.Tile;

import java.util.ArrayList;

public class Corridor extends Level {


    public Corridor(int height, int width, Level from) {
        super(height, width);
        if (TV.isPowerIsOn() ){
            Sound.playSound(Sound.openSound(Sound.tvStatic2));
        }
        adjacentLevelList = new ArrayList<>();
        adjacentLevelList.add(from);
        adjacentLevelList.add(new Street(40, 40, this));
        playerStartingPosX = 350;
        playerStartingPosY = 50;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (i < 10 && j > 0 && j < 10 || i < 10 && j > 12 && j < 21) {
                    tiles[i][j] = new Tile(0, 5, 1, 1);
                } else if (i < 10 && j < 13 && j > 9) {
                    tiles[i][j] = new Tile(0, 4, 1, 1);
                } else {
                    tiles[i][j] = new Tile(0, 0, 1, 1);
                }
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
                if (row == 10 && (col > 0 && col != 11 && col < 20)) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 6));
                } else if (row == 11 && (col >= 0 && col != 11 && col < 21)) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, -1, 6));
                } else if ((row == 0 && (col > 0 && col != 11 && col < 20))) {
                    obstacles.add(new TwoTileWall(32 * col, 32 * row, 3));
                } else if ((col == 0 || col == 20) && (row < 11)) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 6));
                }

                if (row == 0 && col == 0) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 4));
                if (row == 0 && col == 20) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 5));
                if (row == 10 && col == 0) obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 4));
                if (row == 10 && col == 20) obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 5));

                if (row == 0 && col == 11) obstacles.add(new Frontdoor(32 * col, 32 * row,0,350,50));
                if (row == 10 && col == 11) obstacles.add(new Frontdoor(32 * col, 32 * row,1,350,260));

                if (row == 2 && col == 2) obstacles.add(new VendingMachine(32 * col, 32 * row));
                if (row == 7 && col == 3) obstacles.add(new Carpet1(32 * col, 32 * row));
                if (row == 7 && col == 15) obstacles.add(new Carpet1(32 * col, 32 * row));
                if (row == 8 && col == 19) obstacles.add(new Flower(32 * col, 32 * row));
                if (row == 2 && col > 14 && col < 18) obstacles.add(new BlueChair(32 * col, 32 * row));
                if (row == 5 && col > 0 && col < 10) obstacles.add(new Railing(32 * col, 32 * row));
                if (row == 5 && col > 12 && col < 20) obstacles.add(new Railing(32 * col, 32 * row));
            }
        }
    }

    @Override
    protected void fillNPC(int rowCount, int colCount) {

    }
}
