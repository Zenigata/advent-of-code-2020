package com.zeni;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.zeni.day03.Forest;
import com.zeni.day03.Slope;
import com.zeni.day03.Square;

import org.junit.Test;

public class Day03Test {
    @Test
    public void should_meet_no_tree_with_an_empty_map() {
        Square[][] map = new Square[0][0];
        Slope slope = new Slope(3, 1);
        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(0, result);
    }

    @Test
    public void should_meet_no_tree_with_an_open_field() {
        Square[][] map = new Square[2][4];
        map[0][0] = Square.Open;
        map[0][1] = Square.Open;
        map[0][2] = Square.Open;
        map[0][3] = Square.Open;
        map[1][0] = Square.Open;
        map[1][1] = Square.Open;
        map[1][2] = Square.Open;
        map[1][3] = Square.Open;

        Forest forest = new Forest(map);
        Slope slope = new Slope(3, 1);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(0, result);
    }

    @Test
    public void should_meet_one_tree_with_a_forest() {
        Square[][] map = new Square[2][4];
        map[0][0] = Square.Tree;
        map[0][1] = Square.Tree;
        map[0][2] = Square.Tree;
        map[0][3] = Square.Tree;
        map[1][0] = Square.Tree;
        map[1][1] = Square.Tree;
        map[1][2] = Square.Tree;
        map[1][3] = Square.Tree;

        Forest forest = new Forest(map);
        Slope slope = new Slope(3, 1);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(1, result);
    }

    @Test
    public void should_find_some_trees_in_a_basic_forest() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input.txt");

        Forest forest = new Forest(map);
        Slope slope = new Slope(3, 1);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(7, result);
    }

    @Test
    public void should_find_some_trees_in_a_complex_forest() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input2.txt");

        Forest forest = new Forest(map);
        Slope slope = new Slope(3, 1);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(156, result);
    }

    @Test
    public void should_find_some_trees_in_a_basic_forest_with_a_slow_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input.txt");
        Slope slope = new Slope(1, 1);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(2, result);
    }

    @Test
    public void should_find_some_trees_in_a_basic_forest_with_a_fast_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input.txt");
        Slope slope = new Slope(5, 1);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(3, result);
    }

    @Test
    public void should_find_some_trees_in_a_basic_forest_with_a_very_fast_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input.txt");
        Slope slope = new Slope(7, 1);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(4, result);
    }

    @Test
    public void should_find_some_trees_in_a_basic_forest_with_another_slow_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input.txt");
        Slope slope = new Slope(1, 2);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(2, result);
    }

    @Test
    public void should_find_some_trees_in_a_complex_forest_with_a_slow_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input2.txt");
        Slope slope = new Slope(1, 1);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(79, result);
    }

    @Test
    public void should_find_some_trees_in_a_complex_forest_with_a_fast_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input2.txt");
        Slope slope = new Slope(5, 1);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(85, result);
    }

    @Test
    public void should_find_some_trees_in_a_complex_forest_with_a_very_fast_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input2.txt");
        Slope slope = new Slope(7, 1);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(82, result);
    }

    @Test
    public void should_find_some_trees_in_a_complex_forest_with_another_slow_slope() throws URISyntaxException, IOException {
        Square[][] map = buildMapFromSource("day03/input2.txt");
        Slope slope = new Slope(1, 2);

        Forest forest = new Forest(map);
        int result = forest.countTreesWhileSlidingWith(slope);
        assertEquals(41, result);
    }

    private Square[][] buildMapFromSource(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());
        List<String> lines = Files.readAllLines(path);

        Square[][] map = new Square[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            for (int j = 0; j < lines.get(i).length(); j++) {
                map[i][j] = Square.get(lines.get(i).charAt(j));
            }
        }
        return map;
    }
}
