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
  
  class Tile {
    public int x, y;
    public bool isWell, checked;
  }
  public static void main(String[] args) {
    Tile[][] grid;
    List<List<Tile>> mappedTileList;
    
    for (int x = 0; x < grid.length(); x++) {
      for (int y = 0; y < grid[x].length(); y++) {
        if (grid[x][y].isWell && !grid[x][y].checked) {
          mappedTileList.add(getAdjacentTiles(x, y, grid);
        }
      }
    }
    
    
  }
    // return a list of tiles that are next to target
    // and are valid hits, and the additional lists that may
    // already exist within mappedTileLst
  public static List<Tile> getAdjacentTiles(int x, int y, Tile[][] grid) {
    if (grid[x][y].checked) {
      return new ArrayList<>();
    }
    grid[x][y].checked = true;
    List<Tile> tilesToReturn = new ArrayList<>();
    for (int subX = x-1; subX <= x + 1, subX++) {
      for (int subY = y-1; subY <= y + 1, subY++) {
        if (subX >= 0 && subY >= 0    
            subX < grid.length() && subY < grid[x].length()) {
            Tile focus = grid[subX][subY];
          if (focus.isWell) {
            tilesToReturn.join(getAdjacentTiles(subX, subY, grid);
          }    
        }
      }
    }
    tilesToReturn.add(new Tile(x, y));
    return tilesToReturn;
  }
  
}