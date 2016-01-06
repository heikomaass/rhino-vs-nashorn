# rhino-vs-nashorn
An [ octane 2.0 ] (https://github.com/chromium/octane) based testing suite for rhino and nashorn scripting engine.
At the moment the [Rhino Version 1.7.7 ] (https://github.com/mozilla/rhino/releases/tag/Rhino1_7_7_RELEASE) is benchmarked.

## How to run
```
export MAVEN_OPTS=-Xmx1024m
mvn exec:java -Dexec.mainClass="de.heikomaass.rhinovsnashorn.NashornBenchmark"
mvn exec:java -Dexec.mainClass="de.heikomaass.rhinovsnashorn.RhinoBenchmark"
```

## Example test results

The following test results were generated on a MacBook Pro (2 GHz Core i7) with JDK 1.8.0\_65. 
The heap size (Xmx) was set to 1024m. Please note that Rhino could not run some of the tests
because the generated classes of the optimizer exceeded the 64k bytecode limit.

Test                | Rhino Score\* | Nashorn Score\*|
--------------------|---------------|----------------|
richards            | 502,5         | 1084           |
deltablue           | 531,5         | 131            |
crypto              | 499,5         | 778,5          |
RayTrace            | 643           | 631,5          |
EarleyBoyer         | 673           | 694,5          |
RegExp              | 170           | 495,5          |        
Splay               | 998           | 1700,5         |
SplayLatency        | 769,5         | 864,5          |
NavierStokes        | 513           | 1199,5         |
PdfJS               | -             | 397,5          |
Mandreel            | -             | 187,5          |
MandreelLatency     | -             | 193,5          |
Gameboy             | 1405,5        | 376            |
CodeLoad            | 3919,5        | 57,55          |
Box2D               | 594           | 151,5          |
TypeScript          | -             | 1014,5         |


\* Median score of four test runs
