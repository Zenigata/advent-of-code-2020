package com.zeni.day11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;

public class SeatingSystem {

  private Position[][] positions;

  public SeatingSystem(Position[][] positions) {
    this.positions = positions;
  }

  public long getTheFinalOccupiedSeatCount() {
    if (positions.length < 1) {
      return 0;
    }

    boolean isStabilized = false;
    while (!isStabilized) {
      isStabilized = update();
    }
    return Arrays.stream(positions).flatMap(t -> Arrays.stream(t)).filter(p -> p == Position.OccupiedSeat).count();
  }

  private boolean update() {
    boolean isStabilized = true;
    Position[][] newPositions = SerializationUtils.clone(this.positions);
    for (int i = 0; i < this.positions.length; i++) {
      for (int j = 0; j < this.positions[0].length; j++) {
        Position position = this.positions[i][j];
        if (Position.EmptySeat == position) {
          long count = countAdjacentOccupiedSeats(i, j);
          if (count == 0) {
            newPositions[i][j] = Position.OccupiedSeat;
            isStabilized = false;
          }
        } else if (Position.OccupiedSeat == position) {
          long count = countAdjacentOccupiedSeats(i, j);
          if (count >= 4) {
            newPositions[i][j] = Position.EmptySeat;
            isStabilized = false;
          }
        }
      }
    }
    this.positions = newPositions;
    return isStabilized;
  }

  private long countAdjacentOccupiedSeats(int x, int y) {
    List<Position> local = new ArrayList<>();
    for (int i = Math.max(0, x - 1); i < Math.min(x + 2, positions.length); i++) {
      for (int j = Math.max(0, y - 1); j < Math.min(y + 2, positions[i].length); j++) {
        if (i != x || j != y) {
          local.add(positions[i][j]);
        }
      }
    }
    return local.stream().filter(p -> p == Position.OccupiedSeat).count();
  }
}
