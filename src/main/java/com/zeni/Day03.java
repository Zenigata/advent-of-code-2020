package com.zeni;

public class Day03 {

  public static int countTreesMet(Square[][] map) {
    if (map.length == 0) {
      return 0;
    }
    int x = 0;
    int y = 0;

    int treeCount = 0;

    int moveX = 3;
    int moveY = 1;

    while (y + moveY < map[0].length) {
      x = (x + moveX) % map.length;
      y += moveY;

      if (map[y][x] == Square.Tree) {
        treeCount++;
      }
    }

    return treeCount;
  }

}
