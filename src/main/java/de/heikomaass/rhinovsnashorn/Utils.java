package de.heikomaass.rhinovsnashorn;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by hmaass on 04.01.16.
 */
public class Utils {

    public static Reader fromResource(String path) {
        InputStream baseStream = RhinoBenchmark.class.getResourceAsStream(path);
        return new InputStreamReader(baseStream);
    }

}
