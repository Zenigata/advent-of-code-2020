package com.zeni.day04;

public class Passport {

  private int birthYear;
  private int issueYear;
  private int expirationYear;
  private String height;
  private String hairColor;
  private String eyeColor;
  private String passportID;
  private String countryID;

  public Passport(int birthYear, int issueYear, int expirationYear, String height, String hairColor, String eyeColor,
      String passportID, String countryID) {
    this.birthYear = birthYear;
    this.issueYear = issueYear;
    this.expirationYear = expirationYear;
    this.height = height;
    this.hairColor = hairColor;
    this.eyeColor = eyeColor;
    this.passportID = passportID;
    this.countryID = countryID;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public void setBirthYear(int birthYear) {
    this.birthYear = birthYear;
  }

  public int getIssueYear() {
    return issueYear;
  }

  public void setIssueYear(int issueYear) {
    this.issueYear = issueYear;
  }

  public int getExpirationYear() {
    return expirationYear;
  }

  public void setExpirationYear(int expirationYear) {
    this.expirationYear = expirationYear;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getHairColor() {
    return hairColor;
  }

  public void setHairColor(String hairColor) {
    this.hairColor = hairColor;
  }

  public String getEyeColor() {
    return eyeColor;
  }

  public void setEyeColor(String eyeColor) {
    this.eyeColor = eyeColor;
  }

  public String getPassportID() {
    return passportID;
  }

  public void setPassportID(String passportID) {
    this.passportID = passportID;
  }

  public String getCountryID() {
    return countryID;
  }

  public void setCountryID(String countryID) {
    this.countryID = countryID;
  }

}
