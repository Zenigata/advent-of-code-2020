package com.zeni.day12;

import java.util.List;

public class Ferry {

  private Coordinates coordinates = new Coordinates(0, 0);

  private Direction direction = Direction.EAST;

  public long getManhattanDistanceAfterMoving(List<NavigationInstruction> instructions) {

    for (NavigationInstruction instruction : instructions) {
      NavigationAction action = instruction.getAction();
      if (NavigationAction.FORWARD == action) {
        if (direction == Direction.EAST) {
          coordinates.moveEast(instruction.getValue());
        } else if (direction == Direction.WEST) {
          coordinates.moveWest(instruction.getValue());
        } else if (direction == Direction.NORTH) {
          coordinates.moveNorth(instruction.getValue());
        } else {
          coordinates.moveSouth(instruction.getValue());
        }
      } else if (NavigationAction.LEFT == action) {
        this.direction = turnLeft(this.direction, instruction.getValue() / 90);
      } else if (NavigationAction.RIGHT == action) {
        this.direction = turnRight(this.direction, instruction.getValue() / 90);
      } else if (NavigationAction.NORTH == action) {
        coordinates.moveNorth(instruction.getValue());
      } else if (NavigationAction.SOUTH == action) {
        coordinates.moveSouth(instruction.getValue());
      } else if (NavigationAction.EAST == action) {
        coordinates.moveEast(instruction.getValue());
      } else if (NavigationAction.WEST == action) {
        coordinates.moveWest(instruction.getValue());
      } else {
        System.out.println("Danger! " + instruction.getValue());
      }
    }

    return coordinates.getManhattanDistance();
  }

  private Direction turnRight(Direction direction, int quarters) {
    return turnLeft(direction, 4 - quarters);
  }

  private Direction turnLeft(Direction direction, int quarters) {
    return Direction.get(direction.getNumber() + quarters);
  }

  public long getManhattanDistanceAfterMoving(Coordinates coordinates, List<NavigationInstruction> instructions) {
    return 0;
  }

}
