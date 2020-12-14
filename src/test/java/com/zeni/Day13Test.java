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

import com.zeni.day13.BusSchedule;
import com.zeni.day13.BusScheduling;
import com.zeni.day13.SchedulingOptimizer;

import org.junit.Test;

public class Day13Test {

    @Test
    public void should_do_the_easy_input() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/easy.txt"));
        long result = schedulingOptimizer.getProductOfBusIdAndWaitingMinutes();

        assertEquals(6, result);
    }

    @Test
    public void should_do_the_basic_input() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/basic.txt"));
        long result = schedulingOptimizer.getProductOfBusIdAndWaitingMinutes();

        assertEquals(295, result);
    }

    @Test
    public void should_do_the_complex_input() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/input.txt"));
        long result = schedulingOptimizer.getProductOfBusIdAndWaitingMinutes();

        assertEquals(4135, result);
    }

    @Test
    public void should_do_the_context_with_a_basic_example() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/easy-2.txt"));
        long result = schedulingOptimizer.getTheEarlierTimestampForTheContest();

        assertEquals(3417, result);
    }

    @Test
    public void should_do_the_context_with_an_easy_example() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/basic.txt"));
        long result = schedulingOptimizer.getTheEarlierTimestampForTheContest();

        assertEquals(1068781, result);
    }

    @Test
    public void should_do_the_context_with_a_basic_example_2() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/basic-2.txt"));
        long result = schedulingOptimizer.getTheEarlierTimestampForTheContest();

        assertEquals(754018, result);
    }

    @Test
    public void should_do_the_context_with_a_basic_example_3() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/basic-3.txt"));
        long result = schedulingOptimizer.getTheEarlierTimestampForTheContest();

        assertEquals(779210, result);
    }

    @Test
    public void should_do_the_context_with_a_basic_example_4() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/basic-4.txt"));
        long result = schedulingOptimizer.getTheEarlierTimestampForTheContest();

        assertEquals(1261476, result);
    }

    @Test
    public void should_do_the_context_with_a_basic_example_5() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/basic-5.txt"));
        long result = schedulingOptimizer.getTheEarlierTimestampForTheContest();

        assertEquals(1202161486, result);
    }

    @Test
    public void should_do_the_context_with_a_complex_example() throws URISyntaxException, IOException {
        SchedulingOptimizer schedulingOptimizer = new SchedulingOptimizer(getInput("day13/input.txt"));
        long result = schedulingOptimizer.getTheEarlierTimestampForTheContest();

        assertEquals(1202161486, result);
    }

    private BusScheduling getInput(String filePath) throws URISyntaxException, IOException {
        URL url = Thread.currentThread().getContextClassLoader().getResource(filePath);
        Path path = Paths.get(url.toURI());

        List<String> lines = Files.readAllLines(path);
        long departureTime = Long.parseLong(lines.get(0));

        List<BusSchedule> busSchedules = new ArrayList<>();
        String[] split = lines.get(1).split(",");
        for (int i = 0; i < split.length; i++) {
            if (!"x".equals(split[i])) {
                busSchedules.add(new BusSchedule(i, Long.parseLong(split[i])));
            }
        }

        return new BusScheduling(departureTime, busSchedules);
    }
}
