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

import com.zeni.day12.Coordinates;
import com.zeni.day12.Ferry;
import com.zeni.day12.NavigationAction;
import com.zeni.day12.NavigationInstruction;

import org.junit.Test;

public class Day12Test {

    @Test
    public void should_do_the_complex_input_par() throws URISyntaxException, IOException {
        Ferry ferry = new Ferry();
        long result = ferry.getManhattanDistanceAfterMoving(getInput("day12/one-east.txt"));

        assertEquals(10, result);
    }

    @Test
    public void should_do_the_complex_input_pa() throws URISyntaxException, IOException {
        Ferry ferry = new Ferry();
        long result = ferry.getManhattanDistanceAfterMoving(getInput("day12/one-north.txt"));

        assertEquals(3, result);
    }

    @Test
    public void should_do_the_complex_input_p() throws URISyntaxException, IOException {
        Ferry ferry = new Ferry();
        long result = ferry.getManhattanDistanceAfterMoving(getInput("day12/basic.txt"));

        assertEquals(25, result);
    }

    @Test
    public void should_do_the_complex_input_() throws URISyntaxException, IOException {
        Ferry ferry = new Ferry();
        long result = ferry.getManhattanDistanceAfterMoving(getInput("day12/input.txt"));

        assertEquals(1221, result);
    }

    @Test
    public void should_do_the_complex_input() throws URISyntaxException, IOException {
        Ferry ferry = new Ferry();
        long result = ferry.getManhattanDistanceAfterMoving(new Coordinates(10, -1), getInput("day12/basic.txt"));

        assertEquals(286, result);
    }

    private List<NavigationInstruction> getInput(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        List<NavigationInstruction> instructions = new ArrayList<>();
        for (String line : Files.readAllLines(path)) {
            NavigationAction navigationAction = NavigationAction.get(line.substring(0, 1));
            instructions.add(new NavigationInstruction(navigationAction, Integer.parseInt(line.substring(1))));
        }
        return instructions;
    }
}
