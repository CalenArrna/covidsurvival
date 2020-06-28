package covidsurvival.level;


import java.awt.*;
import java.util.ArrayList;

public abstract class Level {
    protected Tile[][] tiles;
    protected Image image;
    protected Image image2;
    protected ArrayList<Obstacle> obstacles;
    protected ArrayList<NPC> npc = new ArrayList<>();
    protected ArrayList<Obstacle> interactables;
    protected ArrayList<Level> adjacentLevelList;
    public int playerStartingPosX;
    public int playerStartingPosY;

    public Level(int height, int width) {
        tiles = new Tile[width][height];
        image = Toolkit.getDefaultToolkit().getImage("res/open_tileset.png");
        image2 = Toolkit.getDefaultToolkit().getImage("res/dotty.png");
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public ArrayList<NPC> getNPC() {
        return npc;
    }

    protected abstract void fillObstacles(int rowCount, int colCount);

    protected abstract void fillNPC(int rowCount, int colCount);

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

    public void setPlayerStartingPosX(int playerStartingPosX) {
        this.playerStartingPosX = playerStartingPosX;
    }

    public void setPlayerStartingPosY(int playerStartingPosY) {
        this.playerStartingPosY = playerStartingPosY;
    }
}
