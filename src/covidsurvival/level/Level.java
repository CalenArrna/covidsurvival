package covidsurvival.level;

import covidsurvival.level.Obstacle;
import covidsurvival.level.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Level {
    protected Tile[][] tiles;
    protected Image image;
    protected ArrayList<Obstacle> obstacles;
    protected ArrayList<Obstacle> interactables;
    protected ArrayList<Level> adjacentLevelList;
    public int playerStartingPosX;
    public int playerStartingPosY;

    public Level(int height, int width) {
        tiles = new Tile[width][height];
        image = Toolkit.getDefaultToolkit().getImage("res/open_tileset.png");
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    protected abstract void fillObstacles(int rowCount, int colCount);

    public void paint(Graphics2D g) {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].paint(g, j, i);
            }
        }
    }

    protected void fillInteractables() {
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

    public ArrayList<Level> getAdjacentLevelList() {
        return adjacentLevelList;
    }

}
