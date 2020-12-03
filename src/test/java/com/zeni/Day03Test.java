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

import org.junit.Test;

public class Day03Test {
    @Test
    public void should_meet_no_tree_with_an_empty_map() {
        Square[][] map = new Square[0][0];
        int result = Day03.countTreesMet(map);
        assertEquals(0, result);
    }

    @Test
    public void should_meet_no_tree_with_an_open_field() {
        Square[][] map = new Square[4][2];
        map[0][0] = Square.Open;
        map[1][0] = Square.Open;
        map[2][0] = Square.Open;
        map[3][0] = Square.Open;
        map[0][1] = Square.Open;
        map[1][1] = Square.Open;
        map[2][1] = Square.Open;
        map[3][1] = Square.Open;

        int result = Day03.countTreesMet(map);
        assertEquals(0, result);
    }

    @Test
    public void should_meet_two_trees_with_a_forest() {
        Square[][] map = new Square[4][2];
        map[0][0] = Square.Tree;
        map[1][0] = Square.Tree;
        map[2][0] = Square.Tree;
        map[3][0] = Square.Tree;
        map[0][1] = Square.Tree;
        map[1][1] = Square.Tree;
        map[2][1] = Square.Tree;
        map[3][1] = Square.Tree;

        int result = Day03.countTreesMet(map);
        assertEquals(2, result);
    }

    @Test
    public void should_find_a_complex_solution_new_policy() throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource("day03/input.txt");
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path);

        Square[][] map = new Square[11][11];
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                map[i][j] = Square.get(lines.get(i).charAt(j));
            }
        }

        int result = Day03.countTreesMet(map);
        assertEquals(7, result);
    }
}
