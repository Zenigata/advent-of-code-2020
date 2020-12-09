package com.zeni.day08;

import java.util.ArrayList;
import java.util.List;

public class BootCode {

  public int showTheAccumulatorValueWhenLoopStartsAgain(List<Instruction> instructions) {
    int accumulator = 0;
    List<Instruction> instructionsUsed = new ArrayList<>();

    for (int i = 0; i < instructions.size(); i++) {
      Instruction instruction = instructions.get(i);

      if (instructionsUsed.contains(instruction)) {
        return accumulator;
      }
      instructionsUsed.add(instruction);

      if (instruction.getOperation() == Operation.ACC) {
        accumulator += instruction.getArgument();
      } else if (instruction.getOperation() == Operation.JMP) {
        i += instruction.getArgument() - 1;
      }
    }
    return 0;
  }

  public int showTheFinalAccumulatorValue(List<Instruction> instructions) {
    int finalValue = 0;
    int updatedIndex = -1;

    while (finalValue == 0) {
      List<Instruction> instructionsFixed = new ArrayList<>(instructions);
      updatedIndex = findTheNewIndexToChange(updatedIndex, instructions);

      if (updatedIndex == -2) {
        return 0;
      }

      changeANegativeJMP(updatedIndex, instructionsFixed);
      // changeANOP(updatedIndex, instructionsFixed);
      System.out.println(updatedIndex + 1);
      finalValue = validUpdate(instructionsFixed);
    }
    return finalValue;
  }

  private void changeANOP(int updatedIndex, List<Instruction> instructions) {
    Instruction oldInstruction = instructions.get(updatedIndex);
    Instruction newInstruction = new Instruction(Operation.JMP, oldInstruction.getArgument());
    instructions.remove(updatedIndex);
    instructions.add(updatedIndex, newInstruction);
  }

  private int findTheNewIndexToChange(int updatedIndex, List<Instruction> instructions) {
    for (int i = updatedIndex + 1; i < instructions.size(); i++) {
      if (instructions.get(i).getOperation() == Operation.JMP && instructions.get(i).getArgument() > 0) {
        // if (instructions.get(i).getOperation() == Operation.NOP) {
        return i;
      }
    }
    return -2;
  }

  private void changeANegativeJMP(int updatedIndex, List<Instruction> instructions) {
    Instruction oldInstruction = instructions.get(updatedIndex);
    Instruction newInstruction = new Instruction(Operation.NOP, oldInstruction.getArgument());
    instructions.remove(updatedIndex);
    instructions.add(updatedIndex, newInstruction);
  }

  private int validUpdate(List<Instruction> instructions) {
    int accumulator = 0;
    List<Instruction> instructionsUsed = new ArrayList<>();

    for (int i = 0; i < instructions.size(); i++) {
      Instruction instruction = instructions.get(i);

      if (instructionsUsed.contains(instruction)) {
        return 0;
      }
      instructionsUsed.add(instruction);

      if (instruction.getOperation() == Operation.ACC) {
        accumulator += instruction.getArgument();
      } else if (instruction.getOperation() == Operation.JMP) {
        i += instruction.getArgument() - 1;
      }
    }
    return accumulator;
  }
}
