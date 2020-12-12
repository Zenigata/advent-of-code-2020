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

  public long getTheFinalOccupiedSeatCountPart2() {
    if (positions.length < 1) {
      return 0;
    }
    // displayPositions();

    boolean isStabilized = false;
    while (!isStabilized) {
      isStabilized = updatePart2();
      // displayPositions();
    }
    return Arrays.stream(positions).flatMap(t -> Arrays.stream(t)).filter(p -> p == Position.OccupiedSeat).count();
  }

  private void displayPositions() {
    for (int i = 0; i < positions.length; i++) {
      for (int j = 0; j < positions[0].length; j++) {
        System.out.print(positions[i][j].getSymbol());
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
  }

  private boolean updatePart2() {
    boolean isStabilized = true;
    Position[][] newPositions = SerializationUtils.clone(this.positions);
    for (int i = 0; i < this.positions.length; i++) {
      for (int j = 0; j < this.positions[0].length; j++) {
        Position position = this.positions[i][j];
        if (Position.EmptySeat == position) {
          long count = countFirstOccupiedSeatsIn8Directions(i, j);
          if (count == 0) {
            newPositions[i][j] = Position.OccupiedSeat;
            isStabilized = false;
          }
        } else if (Position.OccupiedSeat == position) {
          long count = countFirstOccupiedSeatsIn8Directions(i, j);
          if (count >= 5) {
            newPositions[i][j] = Position.EmptySeat;
            isStabilized = false;
          }
        }
      }
    }
    this.positions = newPositions;
    return isStabilized;
  }

  private long countFirstOccupiedSeatsIn8Directions(int x, int y) {
    List<Position> local = new ArrayList<>();

    for (int i = x - 1; i >= 0; i--) {
      if (positions[i][y] != Position.Floor) {
        local.add(positions[i][y]);
        break;
      }
    }

    for (int i = x + 1; i < positions.length; i++) {
      if (positions[i][y] != Position.Floor) {
        local.add(positions[i][y]);
        break;
      }
    }

    for (int i = y - 1; i >= 0; i--) {
      if (positions[x][i] != Position.Floor) {
        local.add(positions[x][i]);
        break;
      }
    }

    for (int i = y + 1; i < positions[x].length; i++) {
      if (positions[x][i] != Position.Floor) {
        local.add(positions[x][i]);
        break;
      }
    }

    for (int i = 1; i < Math.min(x + 1, y + 1); i++) {
      if (positions[x - i][y - i] != Position.Floor) {
        local.add(positions[x - i][y - i]);
        break;
      }
    }

    for (int i = 1; i < Math.min(positions.length - x, positions[0].length - y); i++) {
      if (positions[x + i][y + i] != Position.Floor) {
        local.add(positions[x + i][y + i]);
        break;
      }
    }

    for (int i = 1; i < Math.min(y + 1, positions.length - x); i++) {
      if (positions[x + i][y - i] != Position.Floor) {
        local.add(positions[x + i][y - i]);
        break;
      }
    }

    for (int i = 1; i < Math.min(positions[0].length - y, x + 1); i++) {
      if (positions[x - i][y + i] != Position.Floor) {
        local.add(positions[x - i][y + i]);
        break;
      }
    }

    return local.stream().filter(p -> p == Position.OccupiedSeat).count();
  }
}
