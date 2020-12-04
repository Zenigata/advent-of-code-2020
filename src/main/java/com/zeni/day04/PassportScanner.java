package com.zeni.day04;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

public class PassportScanner {

  public int countValid(List<Passport> passwords) {
    return passwords.stream().filter(PassportScanner::isValid).collect(Collectors.toList()).size();
  }

  public int countStrictlyValid(List<Passport> passwords) {
    return passwords.stream().filter(PassportScanner::isValid).filter(PassportScanner::isStrictlyValid)
        .collect(Collectors.toList()).size();
  }

  static boolean isValid(Passport passport) {
    return passport.getBirthYear() != 0 && passport.getIssueYear() != 0 && passport.getExpirationYear() != 0
        && StringUtils.isNotBlank(passport.getHeight()) && StringUtils.isNotBlank(passport.getHairColor())
        && StringUtils.isNotBlank(passport.getEyeColor()) && StringUtils.isNotBlank(passport.getPassportID());
  }

  static boolean isStrictlyValid(Passport passport) {
    return validYear(passport.getBirthYear(), 4, 1920, 2002) && validYear(passport.getIssueYear(), 4, 2010, 2020)
        && validYear(passport.getExpirationYear(), 4, 2020, 2030) && validHeight(passport.getHeight())
        && validHairColor(passport.getHairColor()) && validEyeColor(passport.getEyeColor())
        && validPassportID(passport.getPassportID());
  }

  private static boolean validPassportID(String hairColor) {
    Pattern pattern = Pattern.compile("\\d{9}");
    Matcher matcher = pattern.matcher(hairColor);
    return matcher.matches();
  }

  private static boolean validEyeColor(String hairColor) {
    Pattern pattern = Pattern.compile("(amb|blu|brn|gry|grn|hzl|oth)");
    Matcher matcher = pattern.matcher(hairColor);
    return matcher.matches();
  }

  private static boolean validHairColor(String hairColor) {
    Pattern pattern = Pattern.compile("#[0-9a-f]{6}");
    Matcher matcher = pattern.matcher(hairColor);
    return matcher.matches();
  }

  private static boolean validHeight(String height) {
    Integer value = Integer.valueOf(height.substring(0, height.length() - 2));
    String type = height.substring(height.length() - 2, height.length());
    if ("cm".equals(type)) {
      return value >= 150 && value <= 193;
    } else if ("in".equals(type)) {
      return value >= 59 && value <= 76;
    } else {
      return false;
    }
  }

  private static boolean validYear(int year, int digits, int min, int max) {
    return countDigits(year) == digits && year >= min && year <= max;
  }

  private static int countDigits(int number) {
    if (number < 100000) {
      if (number < 100) {
        if (number < 10) {
          return 1;
        } else {
          return 2;
        }
      } else {
        if (number < 1000) {
          return 3;
        } else {
          if (number < 10000) {
            return 4;
          } else {
            return 5;
          }
        }
      }
    } else {
      if (number < 10000000) {
        if (number < 1000000) {
          return 6;
        } else {
          return 7;
        }
      } else {
        if (number < 100000000) {
          return 8;
        } else {
          if (number < 1000000000) {
            return 9;
          } else {
            return 10;
          }
        }
      }
    }
  }

}
