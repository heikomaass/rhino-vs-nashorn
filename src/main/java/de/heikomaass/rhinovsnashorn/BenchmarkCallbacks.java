package de.heikomaass.rhinovsnashorn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.System.out;

/**
 * Created by hmaass on 03.01.16.
 */
public class BenchmarkCallbacks {

    // yeah, static members are not soo great, but the octane BenchmarkSuite needs a reference to a "static" method.
    private static HashMap<String, List<String>> RESULTS_BY_NAME = new HashMap<>();
    private static List<String> SCORES = new ArrayList<>();

    public static void addError(String name, Object error) {
        out.println(name + "," + error);
    }

    public static void addScore(String score) {
        out.println("overall score: " + score);
        SCORES.add(score);
    }

    public static void addResult(String name, String result) {
        out.println(name + "," + result);
        List<String> results = RESULTS_BY_NAME.get(name);
        if (results == null) {
            results = new ArrayList<>();
        }
        results.add(result);
        RESULTS_BY_NAME.put(name, results);
    }

    public static void showBox(String name) {
        out.println("started: " + name);
    }

    public static void exportToCsv() {
        RESULTS_BY_NAME.forEach((name, results) -> {
            out.println(name + "," + String.join(",", results));
        });
    }
}
