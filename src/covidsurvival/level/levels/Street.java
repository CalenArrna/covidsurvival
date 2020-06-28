package covidsurvival.level.levels;

import covidsurvival.level.NPC;
import covidsurvival.level.Level;
import covidsurvival.level.Obstacles.*;
import covidsurvival.level.Tile;

import java.util.ArrayList;

public class Street extends Level {


    public Street(int height, int width, Level from) {
        super(height, width);
        adjacentLevelList = new ArrayList<>();
        adjacentLevelList.add(from);
        //adjacentLevelList.add(new Corridor(20, 20,this));
        playerStartingPosX = 1150;
        playerStartingPosY = 220;
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles.length; j++) {
                if (j == 0 && i < 20) {
                    tiles[i][j] = new Tile(21, 3, 1, 1);
                } else if (j == 39 && i < 20) {
                    tiles[i][j] = new Tile(21, 5, 1, 1);
                } else if (i == 0 && j < 40) {
                    tiles[i][j] = new Tile(20, 4, 1, 1);
                } else if (i == 20 && j < 40) {
                    tiles[i][j] = new Tile(22, 4, 1, 1);
                } else if ((i == 7 && j > 1 && j < 20) || (i == 18 && j > 1 && j < 20) || (i == 15 && j > 3 && j < 20) ||
                        (i == 10 && j > 3 && j < 20) || (i == 2 && j > 22 && j < 31) || (i == 15 && j > 22 && j < 31) ||
                        (i == 10 && j > 32 && j < 39) || (i == 7 && j > 32 && j < 39) || (i == 12 && j > 24 && j < 29) ||
                        (i == 5 && j > 24 && j < 29) || (i == 4 && j > 20 && j < 23) || (i == 7 && j > 22 && j < 26) ||
                        (i == 10 && j > 22 && j < 26) || (i == 7 && j > 27 && j < 31) || (i == 10 && j > 27 && j < 31) ||
                        (i == 4 && j > 30 && j < 33) || (i == 13 && j > 20 && j < 23) || (i == 13 && j > 30 && j < 33) ||
                        (j == 1 && i > 6 && i < 19) || (j == 4 && i > 9 && i < 16) || (j == 20 && i > 3 && i < 8) ||
                        (j == 20 && i > 9 && i < 14) || (j == 20 && i > 14 && i < 19) || (j == 22 && i > 1 && i < 4) ||
                        (j == 22 && i > 13 && i < 16) || (j == 31 && i > 1 && i < 4) || (j == 31 && i > 13 && i < 16) ||
                        (j == 23 && i > 7 && i < 11) || (j == 30 && i > 7 && i < 11) || (j == 33 && i > 3 && i < 8) ||
                        (j == 33 && i > 10 && i < 14) || (i == 6 && j == 25) || (i == 6 && j == 28) || (i == 11 && j == 25) ||
                        (i == 11 && j == 28) || (j == 38 && i > 7 && i < 11)) {
                    tiles[i][j] = new Tile(0, 12, 1, 1); // járda
                } else if (i == 8 && j == 20) {
                    tiles[i][j] = new Tile(27, 9, 1, 1); //zebra teteje
                } else if (i == 9 && j == 20) {
                    tiles[i][j] = new Tile(28, 9, 1, 1); //zebra alja
                } else if ((i == 8 && j > 3 && j < 20) || (i == 16 && j > 3 && j < 20) || (i == 8 && j > 32 && j < 40)) {
                    tiles[i][j] = new Tile(27, 8, 1, 1); //út felső fele
                } else if ((i == 9 && j > 3 && j < 20) || (i == 17 && j > 3 && j < 20) || (i == 9 && j > 32 && j < 40)) {
                    tiles[i][j] = new Tile(28, 8, 1, 1); //út alsó fele
                } else if (i > 9 && i < 16 && j == 2) {
                    tiles[i][j] = new Tile(26, 8, 1, 1); //út bal oldala
                } else if (i > 9 && i < 16 && j == 3) {
                    tiles[i][j] = new Tile(26, 9, 1, 1); //út jobb oldala
                } else if ((i == 8 && j == 2) || (i == 16 && j == 2) || (i == 7 && j == 21) || (i == 9 && j == 21) ||
                        (i == 5 && j == 21) || (i == 11 && j == 21) || (i == 5 && j == 23) || (i == 11 && j == 23) ||
                        (i == 3 && j == 23) || (i == 13 && j == 23) || (i == 13 && j == 25) || (i == 13 && j == 27) ||
                        (i == 13 && j == 29) || (i == 3 && j == 25) || (i == 3 && j == 27) || (i == 3 && j == 29) ||
                        (i == 5 && j == 29) || (i == 11 && j == 29) || (i == 11 && j == 31) || (i == 5 && j == 31) ||
                        (i == 7 && j == 31) || (i == 9 && j == 31)) {
                    tiles[i][j] = new Tile(27, 10, 1, 1); //út bal felső sarka (négyzet)
                } else if ((i == 8 && j == 3) || (i == 16 && j == 3) || (i == 7 && j == 22) || (i == 9 && j == 22) ||
                        (i == 5 && j == 22) || (i == 11 && j == 22) || (i == 5 && j == 24) || (i == 11 && j == 24) ||
                        (i == 3 && j == 24) || (i == 13 && j == 24) || (i == 13 && j == 26) || (i == 13 && j == 28) ||
                        (i == 13 && j == 30) || (i == 3 && j == 26) || (i == 3 && j == 28) || (i == 3 && j == 30) ||
                        (i == 5 && j == 30) || (i == 11 && j == 30) || (i == 11 && j == 32) || (i == 5 && j == 32) ||
                        (i == 7 && j == 32) || (i == 9 && j == 32)) {
                    tiles[i][j] = new Tile(27, 11, 1, 1); //út jobb felső sarka (négyzet)
                } else if ((i == 9 && j == 2) || (i == 17 && j == 2) || (i == 8 && j == 21) || (i == 10 && j == 21) ||
                        (i == 6 && j == 21) || (i == 12 && j == 21) || (i == 6 && j == 23) || (i == 12 && j == 23) ||
                        (i == 4 && j == 23) || (i == 14 && j == 23) || (i == 14 && j == 25) || (i == 14 && j == 27) ||
                        (i == 14 && j == 29) || (i == 4 && j == 25) || (i == 4 && j == 27) || (i == 4 && j == 29) ||
                        (i == 6 && j == 29) || (i == 12 && j == 29) || (i == 12 && j == 31) || (i == 6 && j == 31) ||
                        (i == 8 && j == 31) || (i == 10 && j == 31)) {
                    tiles[i][j] = new Tile(28, 10, 1, 1); //út bal alsó sarka (négyzet)
                } else if ((i == 9 && j == 3) || (i == 17 && j == 3) || (i == 8 && j == 22) || (i == 10 && j == 22) ||
                        (i == 6 && j == 22) || (i == 12 && j == 22) || (i == 6 && j == 24) || (i == 12 && j == 24) ||
                        (i == 4 && j == 24) || (i == 14 && j == 24) || (i == 14 && j == 26) || (i == 14 && j == 28) ||
                        (i == 14 && j == 30) || (i == 4 && j == 26) || (i == 4 && j == 28) || (i == 4 && j == 30) ||
                        (i == 6 && j == 30) || (i == 12 && j == 30) || (i == 12 && j == 32) || (i == 6 && j == 32) ||
                        (i == 8 && j == 32) || (i == 10 && j == 32)) {
                    tiles[i][j] = new Tile(28, 11, 1, 1); //út jobb alsó sarka (négyzet)
                } else if ((i == 7 && j == 27) || (i == 8 && j == 25) || (i == 3 && j == 10) || (i == 11 && j == 13)) {
                    tiles[i][j] = new Tile(18, 6, 1, 1); // virág
                } else if ((i == 9 && j == 29) || (i == 10 && j == 26) || (i == 15 && j == 26) || (i == 15 && j == 36) || (i == 13 && j == 16)) {
                    tiles[i][j] = new Tile(19, 6, 1, 1); // virág
                } else {
                    tiles[i][j] = new Tile(18, 5, 1, 1); // fű
                }
            }
        }
        fillObstacles(30, 40);
        fillInteractables();
        fillNPC(30, 40);
    }

    @Override
    protected void fillObstacles(int rowCount, int colCount) {
        obstacles = new ArrayList<>();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                if (row == 3 && col == 35) {
                    obstacles.add(new YellowRoofHouse(32 * col, 32 * row));
                } else if (row == 11 && col == 6) {
                    obstacles.add(new YellowWallHouse(32 * col, 32 * row));
                } else if (row == 2 && col == 15) {
                    obstacles.add(new BlueWallHouse(32 * col, 32 * row));
                } else if (row == 6 && col == 15) {
                    obstacles.add(new GlassDoor(32 * col, 32 * row));
                } else if (row == 5 && col == 3) {
                    obstacles.add(new Pizzeria(32 * col, 32 * row));
                } else if (row == 4 && col == 6) {
                    obstacles.add(new House1(32 * col, 32 * row));
                } else if (row == 4 && col == 10) {
                    obstacles.add(new House2(32 * col, 32 * row));
                } else if ((row == 11 && col == 11) || (row == 1 && col == 10) || (row == 2 && col == 20)) {
                    obstacles.add(new BigBush(32 * col, 32 * row));
                } else if ((row == 6 && col == 26) || (row == 8 && col == 28) || (row == 8 && col == 24) || (row == 10 && col == 26)) {
                    obstacles.add(new SmallBush(32 * col, 32 * row));
                } else if ((row == 17 && col == 28) || (row == 14 && col == 35) || (row == 1 && col == 33)) {
                    obstacles.add(new Trunk(32 * col, 32 * row));
                } else if ((row == 15 && col == 21) || (row == 17 && col == 32) || (row == 1 && col == 1)) {
                    obstacles.add(new Tree(32 * col, 32 * row));
                } else if (row == 5 && col == 36) {
                    obstacles.add(new Frontdoor(32 * col, 32 * row + 16, 0));
                }
                if (row == 10 && col == 33) {
                    obstacles.add(new Dotty(32 * col, 32 * row + 16));
                }

            }
        }
    }

    @Override
    protected void fillNPC(int rowCount, int colCount) {

    }


}
