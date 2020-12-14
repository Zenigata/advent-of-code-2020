package com.zeni.day14;

import java.util.List;
import java.util.Map;

public class InitializingProgram {

  private Map<String, List<MemoryValue>> program;

  public InitializingProgram(Map<String, List<MemoryValue>> program) {
    this.program = program;
  }

  public Map<String, List<MemoryValue>> getProgram() {
    return program;
  }

  public void setProgram(Map<String, List<MemoryValue>> program) {
    this.program = program;
  }

}
