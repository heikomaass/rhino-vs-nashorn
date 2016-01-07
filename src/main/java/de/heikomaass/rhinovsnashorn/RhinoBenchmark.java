package de.heikomaass.rhinovsnashorn;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptableObject;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by hmaass on 03.01.16.
 */
public class RhinoBenchmark {

    public static void main(String[] args) throws Exception {
        Context context = Context.enter();
        context.setLanguageVersion(Context.VERSION_1_8);
        ScriptableObject scope = context.initStandardObjects();

        addScript("/base.js", context, scope);
        addScript("/richards.js", context, scope);
        addScript("/deltablue.js", context, scope);
        addScript("/crypto.js", context, scope);
        addScript("/raytrace.js", context, scope);
        addScript("/earley-boyer.js", context, scope);
        addScript("/regexp.js", context, scope);
        addScript("/splay.js", context, scope);
        addScript("/navier-stokes.js", context, scope);
//        addScript("/pdfjs.js", context, scope);
        addScript("/code-load.js", context, scope);

        for (int i = 0; i < 4; i++) {
            context.evaluateString(scope, " BenchmarkSuite.RunSuites({\n" +
                    "      NotifyStart : Packages.de.heikomaass.rhinovsnashorn.BenchmarkCallbacks.showBox,\n" +
                    "      NotifyError : Packages.de.heikomaass.rhinovsnashorn.BenchmarkCallbacks.addError,\n" +
                    "      NotifyResult : Packages.de.heikomaass.rhinovsnashorn.BenchmarkCallbacks.addResult,\n" +
                    "      NotifyScore : Packages.de.heikomaass.rhinovsnashorn.BenchmarkCallbacks.addScore\n" +
                    "    },\n" +
                    "    []);", "RunSuites", 1, null);
        }
        BenchmarkCallbacks.exportToCsv();

    }

    private static void addScript(String path, Context context, ScriptableObject scope) throws IOException {
        try (Reader reader = Utils.fromResource(path)) {
            context.evaluateReader(scope, reader, path, 1, null);
        }
    }

}
