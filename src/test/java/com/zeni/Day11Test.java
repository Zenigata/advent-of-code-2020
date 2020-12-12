package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.zeni.day11.Position;
import com.zeni.day11.SeatingSystem;

import org.junit.Test;

public class Day11Test {

    @Test
    public void should_do_nothing() {
        Position[][] positions = new Position[0][0];
        SeatingSystem seatingSystem = new SeatingSystem(positions);

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(0, result);
    }

    @Test
    public void should_do_nothing_again() {
        Position[][] positions = new Position[3][3];
        positions[0][0] = Position.Floor;
        positions[0][1] = Position.Floor;
        positions[0][2] = Position.Floor;
        positions[1][0] = Position.Floor;
        positions[1][1] = Position.Floor;
        positions[1][2] = Position.Floor;
        positions[2][0] = Position.Floor;
        positions[2][1] = Position.Floor;
        positions[2][2] = Position.Floor;
        SeatingSystem seatingSystem = new SeatingSystem(positions);

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(0, result);
    }

    @Test
    public void should_do_nothing_ever_again() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/one-dot.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(0, result);
    }

    @Test
    public void should_return_one_occupied_seat() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/one-#.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(1, result);
    }

    @Test
    public void should_return_one_occupied_seat_again() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/one-L.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(1, result);
    }

    @Test
    public void should_return_three_occupied_seats() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/three-L.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(3, result);
    }

    @Test
    public void should_return_four_occupied_seats() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/nine-L.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(4, result);
    }

    @Test
    public void should_return_four_occupied_seats_again() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/mix-L.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(4, result);
    }

    @Test
    public void should_do_the_basic_input() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/basic.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(37, result);
    }

    @Test
    public void should_do_the_complex_input() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/input.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCount();

        assertEquals(2251, result);
    }

    @Test
    public void should_do_the_basic_input_part_2() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/basic.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCountPart2();

        assertEquals(26, result);
    }

    @Test
    public void should_do_the_complex_input_part_2() throws URISyntaxException, IOException {
        SeatingSystem seatingSystem = new SeatingSystem(getInput("day11/input.txt"));

        long result = seatingSystem.getTheFinalOccupiedSeatCountPart2();

        assertEquals(2019, result);
    }

    private Position[][] getInput(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path);

        Position[][] map = new Position[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                map[i][j] = Position.get(lines.get(i).charAt(j));
            }
        }
        return map;
    }
}
