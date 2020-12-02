package com.zeni;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class Day02 {

  public static int countValidPasswords(List<Policy> policies) {
    if (policies.isEmpty()) {
      return 0;
    }
    Policy policy = policies.get(0);
    policy.getPassword();
    int countMatches = StringUtils.countMatches(policy.getPassword(), policy.getCharacter());
    if (countMatches >= policy.getMin() && countMatches <= policy.getMax()) {
      return 1;
    }
    return 0;
  }

}
