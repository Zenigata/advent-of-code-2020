package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.zeni.day05.BinaryBoarding;

import org.junit.Test;

public class Day05Test {

    @Test
    public void should_only_find_the_row() {
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = binaryBoarding.getRowNumber("FBFBBFF");
        assertEquals(44, result);
    }

    @Test
    public void should_only_find_the_column() {
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = binaryBoarding.getColumnNumber("RLR");
        assertEquals(5, result);
    }

    @Test
    public void should_find_the_seat_ID() {
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = binaryBoarding.getSeatID("FBFBBFFRLR");
        assertEquals(357, result);
    }

    @Test
    public void should_find_another_seat_ID() {
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = binaryBoarding.getSeatID("BFFFBBFRRR");
        assertEquals(567, result);
    }

    @Test
    public void should_find_another_seat_ID_again() {
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = binaryBoarding.getSeatID("FFFBBBFRRR");
        assertEquals(119, result);
    }

    @Test
    public void should_find_another_seat_ID_ever_again() {
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = binaryBoarding.getSeatID("BBFFBBFRLL");
        assertEquals(820, result);
    }

    @Test
    public void should_find_the_highest_seat_ID() throws URISyntaxException, IOException {
        BinaryBoarding binaryBoarding = new BinaryBoarding();

        int result = binaryBoarding.findTheHighestSeatIDIn(getBoardingPasses("day05/input.txt"));
        assertEquals(858, result);
    }

    private List<String> getBoardingPasses(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());
        return Files.readAllLines(path);
    }
}
