package covidsurvival.level.levels;

import covidsurvival.level.Level;
import covidsurvival.level.Obstacles.*;
import covidsurvival.level.Tile;

import java.util.ArrayList;

public class Home extends Level {

    public Home(int width, int height) {
        super(width, height);
        playerStartingPosX = 164;
        playerStartingPosY = 164;
        int levelRowCount = 18;
        int levelColCount = 21;
        //Construct the tiles here
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (i > 1 && i < 16 && j < 9) {
                    tiles[i][j] = new Tile(0, 6, 1, 1);
                } else if (i < 16 && j < 13) {
                    tiles[i][j] = new Tile(0, 1, 1, 1);
                } else if (i < 8 && j < 20) {
                    tiles[i][j] = new Tile(0, 3, 1, 1);
                } else if (i < 16 && j < 20) {
                    tiles[i][j] = new Tile(0, 5, 1, 1);
                } else {
                    if (j % 2 == 0) {
                        tiles[i][j] = new Tile(16, 14, 1, 1);
                    } else {
                        tiles[i][j] = new Tile(16, 15, 1, 1);
                    }
                }
            }
        }
        fillObstacles(levelRowCount, levelColCount);
        fillInteractables();
    }

    protected void fillObstacles(int rowCount, int colCount) {
        //Construct the objects on Level
        obstacles = new ArrayList<>();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if ((row == 16 && (col > 0 && col < 8) || row == 16 && (col > 8 && col < 11)
                        || row == 16 && (col == 12) || row == 16 && (col > 13 && col < 20))) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 6));
                } else if (row == 17 && (col >= 0 && col < 11) || row == 17 && (col > 11 && col < 21)) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, -1, 6));
                } else if ((row == 8 && (col < 8 && col > 0)) || row == 8 && (col > 13 && col < 20) || row == 0 && (col > 0 && col < 20)) {
                    obstacles.add(new TwoTileWall(32 * col, 32 * row, 3));
                } else if ((col == 0 && row >= 1 && row < 8) || (col == 20 && row >= 1 && row < 8)
                        || (col == 0 && row >= 8 && row < 16) || (col == 20 && row >= 8 && row < 16)
                        || (col == 8 && row >= 14 && row < 16) || (col == 13 && row >= 14 && row < 16)
                        || (col == 8 && row == 7) || (col == 13 && row == 7)
                        || (col == 8 && row == 1) || (col == 13 && row == 1)) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 6));
                } else if ((col == 8 && (row == 9 || row == 2)) || (col == 13 && (row == 9 || row == 2))) {
                    obstacles.add(new TwoTileWall(32 * col, 32 * row, 0));
                }

                if (row == 6 && col == 8) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 3));
                if (row == 6 && col == 13) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 3));
                if (row == 13 && col == 8) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 3));
                if (row == 13 && col == 13) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 3));

                if (row == 0 && col == 0) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 4));
                if (row == 0 && col == 20) obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 5));
                if (row == 16 && col == 0) obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 4));
                if (row == 16 && col == 20) obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 5));

                if (row == 0 && col == 8 || row == 0 && col == 13) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 1));
                }
                if (row == 16 && col == 8 || row == 16 && col == 13) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 2));
                }
                if (row == 8 && col == 0 || row == 8 && col == 13) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 0, 2));
                }
                if (row == 8 && col == 8 || row == 8 && col == 20) {
                    obstacles.add(new OneTileWall(32 * col, 32 * row, 1, 1));
                }

                if (row == 2 && col == 7) obstacles.add(new Desk(32 * col, 32 * row));
                if (row == 6 && col == 4) obstacles.add(new Carpet1(32 * col, 32 * row));
                if (row == 6 && col == 1) obstacles.add(new Carpet1(32 * col, 32 * row));
                if (row == 2 && col == 3) obstacles.add(new Bed(32 * col, 32 * row));
                if (row == 16 && col == 11) obstacles.add(new Frontdoor(32 * col, 32 * row));
                if (row == 3 && col == 6) obstacles.add(new Chair1(32 * col, 32 * row));
                if (row == 1 && col == 10) obstacles.add(new Bookshelf(32 * col, 32 * row));
                if (row == 2 && col == 1) obstacles.add(new Radio(32 * col, 32 * row));
                if (row == 9 && col == 14) obstacles.add(new Fridge(32 * col, 32 * row));
                if (row == 10 && col == 1) obstacles.add(new Flower(32 * col, 32 * row));
                if (row == 9 && col == 4) obstacles.add(new TV(32 * col, 32 * row));
                if (row == 9 && col == 6) obstacles.add(new Bookshelf2(32 * col, 32 * row));
                if (row == 12 && col == 2) obstacles.add(new Carpet2(32 * col, 32 * row));
                if (row == 15 && col == 3) obstacles.add(new Couch(32 * col, 32 * row));
                if (row == 14 && col == 7) obstacles.add(new Candles(32 * col, 32 * row));
                if (row == 9 && col == 15) obstacles.add(new Table2(32 * col, 32 * row));
                if (row == 9 && col == 19) obstacles.add(new GasStove(32 * col, 32 * row));
                if (row == 9 && col == 17) obstacles.add(new Sink(32 * col, 32 * row));
                if (row == 13 && col == 16) obstacles.add(new Table1(32 * col, 32 * row));
                if (row == 13 && col == 15) obstacles.add(new Chair2(32 * col, 32 * row));
                if (row == 13 && col == 18) obstacles.add(new Chair2(32 * col, 32 * row));
                if (row == 14 && col == 15) obstacles.add(new Chair2(32 * col, 32 * row));
                if (row == 14 && col == 18) obstacles.add(new Chair2(32 * col, 32 * row));
                if (row == 14 && col == 19) obstacles.add(new Flower(32 * col, 32 * row));
                if (row == 5 && col == 16) obstacles.add(new Carpet2(32 * col, 32 * row));
                if (row == 6 && col == 14) obstacles.add(new Toilette(32 * col, 32 * row));
                if (row == 1 && col == 18) obstacles.add(new Shower(32 * col, 32 * row));
                if (row == 2 && col == 18) obstacles.add(new Hole(32 * col, 32 * row));
                if (row == 2 && col == 15) obstacles.add(new MirroredSink(32 * col, 32 * row));
            }
        }
    }


}
