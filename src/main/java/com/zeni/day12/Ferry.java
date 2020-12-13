package com.zeni.day12;

import java.util.List;

public class Ferry {

  private Coordinates coordinates = new Coordinates(0, 0);

  public long getManhattanDistanceAfterMoving(List<NavigationInstruction> instructions) {
    Direction direction = Direction.EAST;

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
        direction = turnLeft(direction, instruction.getValue() / 90);
      } else if (NavigationAction.RIGHT == action) {
        direction = turnRight(direction, instruction.getValue() / 90);
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

  public long getManhattanDistanceAfterMoving(Coordinates waypoint, List<NavigationInstruction> instructions) {
    for (NavigationInstruction instruction : instructions) {
      NavigationAction action = instruction.getAction();
      if (NavigationAction.FORWARD == action) {
        coordinates.setX(coordinates.getX() + waypoint.getX() * instruction.getValue());
        coordinates.setY(coordinates.getY() + waypoint.getY() * instruction.getValue());
      } else if (NavigationAction.LEFT == action) {
        waypoint = turnLeft(waypoint, instruction.getValue() / 90);
      } else if (NavigationAction.RIGHT == action) {
        waypoint = turnRight(waypoint, instruction.getValue() / 90);
      } else if (NavigationAction.NORTH == action) {
        waypoint.moveNorth(instruction.getValue());
      } else if (NavigationAction.SOUTH == action) {
        waypoint.moveSouth(instruction.getValue());
      } else if (NavigationAction.EAST == action) {
        waypoint.moveEast(instruction.getValue());
      } else if (NavigationAction.WEST == action) {
        waypoint.moveWest(instruction.getValue());
      } else {
        System.out.println("Danger! " + instruction.getValue());
      }
    }

    return coordinates.getManhattanDistance();
  }

  private Coordinates turnRight(Coordinates waypoint, int quarters) {
    return turnLeft(waypoint, 4 - quarters);
  }

  private Coordinates turnLeft(Coordinates waypoint, int quarters) {
    switch (quarters) {
      case 1:
        return new Coordinates(waypoint.getY(), -waypoint.getX());
      case 2:
        return new Coordinates(-waypoint.getX(), -waypoint.getY());
      case 3:
        return new Coordinates(-waypoint.getY(), waypoint.getX());
      default:
        System.out.println("Bug: " + quarters);
        return waypoint;
    }
  }

}
