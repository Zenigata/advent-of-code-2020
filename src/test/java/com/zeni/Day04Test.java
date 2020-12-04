package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.zeni.day04.Passport;
import com.zeni.day04.PassportScanner;

import org.junit.Test;

public class Day04Test {

    @Test
    public void should_valid_one_password() throws URISyntaxException, IOException {
        PassportScanner scanner = new PassportScanner();

        int result = scanner.countValid(getPasswordsFrom("day04/one.txt"));
        assertEquals(1, result);
    }

    @Test
    public void should_valid_more_passwords() throws URISyntaxException, IOException {
        PassportScanner scanner = new PassportScanner();

        int result = scanner.countValid(getPasswordsFrom("day04/basic.txt"));
        assertEquals(2, result);
    }

    @Test
    public void should_valid_a_lot_of_passwords() throws URISyntaxException, IOException {
        PassportScanner scanner = new PassportScanner();

        int result = scanner.countValid(getPasswordsFrom("day04/input.txt"));
        assertEquals(204, result);
    }

    @Test
    public void should_valid_strictly_more_passwords() throws URISyntaxException, IOException {
        PassportScanner scanner = new PassportScanner();

        int result = scanner.countStrictlyValid(getPasswordsFrom("day04/strict.txt"));
        assertEquals(4, result);
    }

    @Test
    public void should_valid_strictly_a_lot_of_passwords() throws URISyntaxException, IOException {
        PassportScanner scanner = new PassportScanner();

        int result = scanner.countStrictlyValid(getPasswordsFrom("day04/input.txt"));
        assertEquals(179, result);
    }

    private List<Passport> getPasswordsFrom(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());
        String text = new String(Files.readAllBytes(path));

        List<Passport> passports = new ArrayList<>();

        String[] rawPassports = text.split("\n\n");

        for (int i = 0; i < rawPassports.length; i++) {
            String[] fields = rawPassports[i].split("[ \n]");
            int birthYear = 0;
            int issueYear = 0;
            int expirationYear = 0;
            String height = null;
            String hairColor = null;
            String eyeColor = null;
            String passportID = null;
            String countryID = null;

            for (int j = 0; j < fields.length; j++) {
                switch (fields[j].substring(0, fields[j].indexOf(":"))) {
                    case "byr":
                        birthYear = Integer.valueOf(fields[j].substring(fields[j].indexOf(":") + 1));
                        break;
                    case "iyr":
                        issueYear = Integer.valueOf(fields[j].substring(fields[j].indexOf(":") + 1));
                        break;
                    case "eyr":
                        expirationYear = Integer.valueOf(fields[j].substring(fields[j].indexOf(":") + 1));
                        break;
                    case "hgt":
                        height = fields[j].substring(fields[j].indexOf(":") + 1);
                        break;
                    case "hcl":
                        hairColor = fields[j].substring(fields[j].indexOf(":") + 1);
                        break;
                    case "ecl":
                        eyeColor = fields[j].substring(fields[j].indexOf(":") + 1);
                        break;
                    case "pid":
                        passportID = fields[j].substring(fields[j].indexOf(":") + 1);
                        break;
                    case "cid":
                        countryID = fields[j].substring(fields[j].indexOf(":") + 1);
                        break;
                }
            }

            Passport passport = new Passport(birthYear, issueYear, expirationYear, height, hairColor, eyeColor,
                    passportID, countryID);
            passports.add(passport);
        }

        return passports;
    }
}
