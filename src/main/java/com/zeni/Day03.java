package com.zeni;

public class Day03 {

  public static int countTreesMet(Square[][] map) {
    if (map.length == 0) {
      return 0;
    }
    int x = 0;
    int y = 0;

    int treeCount = 0;

    if (map[x][y] == Square.Tree) {
      treeCount++;
    }

    int moveX = 3;
    int moveY = 1;

    while (x + moveX <= map.length && y + moveY <= map[0].length) {
      x += moveX;
      y += moveY;

      if (map[x][y] == Square.Tree) {
        treeCount++;
      }
    }

    return treeCount;
  }

}
