package com.zeni.day03;

public class Forest {

  private Square[][] map;

  public Forest(Square[][] map) {
    this.map = map;
  }

  public int countTreesWhileSlidingWith(Slope slope) {
    if (map.length == 0) {
      return 0;
    }
    int x = 0;
    int y = 0;

    int treeCount = 0;

    while (y + slope.getMoveY() < map.length) {
      x = (x + slope.getMoveX()) % map[0].length;
      y += slope.getMoveY();

      if (map[y][x] == Square.Tree) {
        treeCount++;
      }
    }

    return treeCount;
  }

}
