package com.zeni.day04;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class PassportScanner {

  public int countValid(List<Passport> passwords) {
    return passwords.stream().filter(PassportScanner::isValid).collect(Collectors.toList()).size();
  }

  static boolean isValid(Passport passport) {
    return passport.getBirthYear() != 0 && passport.getIssueYear() != 0 && passport.getExpirationYear() != 0
        && StringUtils.isNotBlank(passport.getHeight()) && StringUtils.isNotBlank(passport.getHairColor())
        && StringUtils.isNotBlank(passport.getEyeColor()) && StringUtils.isNotBlank(passport.getPassportID());
  }

}
