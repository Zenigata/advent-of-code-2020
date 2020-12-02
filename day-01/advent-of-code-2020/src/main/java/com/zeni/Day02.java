package com.zeni;

import java.util.List;
import java.util.stream.Collectors;

public class Day02 {

  public static int countValidPasswords(List<Policy> policies) {
    if (policies.isEmpty()) {
      return 0;
    }

    return policies.stream().filter(Policy::isValid).collect(Collectors.toList()).size();
  }

}
