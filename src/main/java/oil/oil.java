package oil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Oil
 * A large oil company is drilling for oil, and has nearly exhausted their resources.
 * They give you a grid full of values that represent plotted land that either has oil, or does not.
 * To drill the oil, they need to insert a pump into only well at a time.
 * If two grids are connected, they are considered as one well.
 * A diagonal connection still counts as a well connection.
 * Return all points where each well group can be drilled.
 * Example grid:
 * |-------------|
 * |x| |x|x| | | |
 * |-------------|
 * | | | |x| | | |
 * |-------------|
 * | | |x| | | |x|
 * |-------------|
 * | |x| | | |x| |
 * |-------------|
 */

class oil {

    public static class Tile {
        public Tile(int x, int y, boolean isWell) {
            this.x = x;
            this.y = y;
            this.isWell = isWell;
        }

        public int x, y;
        public boolean isWell, checked;

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            int length = s.nextInt();
            if (length <= 0) throw new Exception();
            int width = s.nextInt();
            if (width <= 0) throw new Exception();

            Tile[][] grid = new Tile[length][width];
            for (int y = 0; y < width; y++) {
                for (int x = 0; x < length; x++) {
                    int nextInt = s.nextInt();
                    if (nextInt != 1 && nextInt != 0) throw new Exception();
                    grid[x][y] = new Tile(x, y, nextInt == 1);
                }
            }

            List<List<Tile>> adjacentTiles = getAllAdjacentTiles(grid);

            for (List<Tile> l : adjacentTiles) {
                for (Tile t : l) {
                    System.out.print(t);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("INVALID INPUT");
        }


    }

    public static List<List<Tile>> getAllAdjacentTiles(Tile[][] grid) {
        List<List<Tile>> mappedTileList = new ArrayList<List<Tile>>();

        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y].isWell && !grid[x][y].checked) {
                    List<Tile> well = getAdjacentTiles(x, y, grid);
                    well.sort((t1, t2) -> (t1.y != t2.y ? (t1.y > t2.y ? 1 : -1) : (t1.x == t2.x ? 0 : (t1.x > t2.x ? 1 : -1))));
                    mappedTileList.add(well);
                }
            }
        }

        return mappedTileList;
    }

    // return a list of tiles that are next to target
    // and are valid hits, and the additional lists that may
    // already exist within mappedTileLst
    public static List<Tile> getAdjacentTiles(int x, int y, Tile[][] grid) {
        if (grid[x][y].checked) {
            return new ArrayList<Tile>();
        }
        grid[x][y].checked = true;
        List<Tile> tilesToReturn = new ArrayList<Tile>();
        for (int subX = x - 1; subX <= x + 1; subX++) {
            for (int subY = y - 1; subY <= y + 1; subY++) {
                if ((x == subX || y == subY) && subX >= 0 && subY >= 0 &&
                        subX < grid.length && subY < grid[x].length) {
                    Tile focus = grid[subX][subY];
                    if (focus.isWell) {
                        tilesToReturn.addAll(getAdjacentTiles(subX, subY, grid));
                    }
                }
            }
        }
        tilesToReturn.add(new Tile(x, y, false));
        return tilesToReturn;
    }

}