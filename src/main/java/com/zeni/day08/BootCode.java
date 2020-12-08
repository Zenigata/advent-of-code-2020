package com.zeni.day08;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BootCode {

  public int showAccumulatorValueWhenLoopStartsAgain(List<Instruction> instructions) {
    int accumulator = 0;
    Set<Instruction> instructionsUsed = new HashSet<>();

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

}
