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
        ScriptableObject scope = context.initStandardObjects();
        scope.put("callbacks", scope, new BenchmarkCallbacks());

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
//        addScript("/mandreel.js", context, scope);
//        addScript("/gbemu-part1.js", context, scope);
//        addScript("/gbemu-part2.js", context, scope);
        addScript("/code-load.js", context, scope);
        addScript("/box2d.js", context, scope);
//        addScript("/zlib.js", context, scope);
//        addScript("/zlib-data.js", context, scope);
//        addScript("/typescript.js", context, scope);
//        addScript("/typescript-input.js", context, scope);
//        addScript("/typescript-compiler.js", context, scope);

        context.evaluateString(scope, " BenchmarkSuite.RunSuites({\n" +
                "      NotifyStart : callbacks.showBox,\n" +
                "      NotifyError : callbacks.addError,\n" +
                "      NotifyResult : callbacks.addResult,\n" +
                "      NotifyScore : callbacks.addScore\n" +
                "    },\n" +
                "    []);", "RunSuites", 1, null);
    }

    private static void addScript(String path, Context context, ScriptableObject scope) throws IOException {
        try (Reader reader = Utils.fromResource(path)) {
            context.evaluateReader(scope, reader, path, 1, null);
        }
    }

}
