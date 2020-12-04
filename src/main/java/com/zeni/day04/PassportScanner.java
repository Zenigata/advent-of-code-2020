package com.zeni.day04;

import java.util.List;
import java.util.stream.Collectors;

public class PassportScanner {

  public int countValid(List<Passport> passwords) {
    return passwords.stream().filter(PassportScanner::isValid).collect(Collectors.toList()).size();
  }

  static boolean isValid(Passport passport) {
    return passport.getBirthYear() != 0 && passport.getIssueYear() != 0 && passport.getExpirationYear() != 0
        && !passport.getHeight().isBlank() && !passport.getHairColor().isBlank() && !passport.getEyeColor().isBlank()
        && !passport.getPassportID().isBlank();
  }

}
