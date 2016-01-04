package de.heikomaass.rhinovsnashorn;

import static java.lang.System.out;

/**
 * Created by hmaass on 03.01.16.
 */
public class BenchmarkCallbacks {

    public static void addError(String name, Object error) {
        out.println("error:" + name + " " + error);
    }

    public static void addScore(Object score) {
        out.println("overall score: " + score);
    }

    public static void addResult(String name, Object result) {
        out.println("result: " + name + " " + result);
    }

    public static void showBox(String scriptable) {
        out.println("started: " + scriptable);
    }

}
