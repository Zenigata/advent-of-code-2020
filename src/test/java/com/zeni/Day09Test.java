package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.zeni.day09.Xmas;

import org.junit.Test;

public class Day09Test {

    @Test
    public void should_do_nothing() {
        Xmas xmas = new Xmas();

        List<Long> numbers = new ArrayList<>();
        long result = xmas.findAnErrorIn(0, numbers);

        assertEquals(-1, result);
    }

    @Test
    public void should_find_no_error_with_a_simplest_case() {
        Xmas xmas = new Xmas();

        List<Long> numbers = Arrays.asList(20l, 22l, 42l);
        long result = xmas.findAnErrorIn(2, numbers);

        assertEquals(-1l, result);
    }

    @Test
    public void should_find_an_error_with_a_simplest_case() {
        Xmas xmas = new Xmas();

        List<Long> numbers = Arrays.asList(20l, 22l, 50l);
        long result = xmas.findAnErrorIn(2, numbers);

        assertEquals(50l, result);
    }

    @Test
    public void should_find_an_error_with_a_simpler_case() {
        Xmas xmas = new Xmas();

        List<Long> numbers = Arrays.asList(20l, 22l, 42l, 50l);
        long result = xmas.findAnErrorIn(2, numbers);

        assertEquals(50l, result);
    }

    @Test
    public void should_find_an_error_with_a_preamble_of_3() {
        Xmas xmas = new Xmas();

        List<Long> numbers = Arrays.asList(20l, 22l, 2l, 22l, 169l);
        long result = xmas.findAnErrorIn(3, numbers);

        assertEquals(169l, result);
    }

    @Test
    public void should_find_an_error_with_a_basic_sheet() throws URISyntaxException, IOException {
        Xmas xmas = new Xmas();

        List<Long> numbers = getInput("day09/basic.txt");
        long result = xmas.findAnErrorIn(5, numbers);

        assertEquals(127l, result);
    }

    @Test
    public void should_find_an_error_with_a_complex_sheet() throws URISyntaxException, IOException {
        Xmas xmas = new Xmas();

        List<Long> numbers = getInput("day09/input.txt");
        long result = xmas.findAnErrorIn(25, numbers);

        assertEquals(26134589l, result);
    }

    private List<Long> getInput(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        List<Long> numbers = new ArrayList<>();

        for (String line : Files.readAllLines(path)) {
            numbers.add(Long.parseLong(line));
        }

        return numbers;
    }
}
