# rhino-vs-nashorn
An [ octane 2.0 ] (https://github.com/chromium/octane) based testing suite for rhino and nashorn scripting engine.
At the moment the [Rhino Version 1.7.7 ] (https://github.com/mozilla/rhino/releases/tag/Rhino1_7_7_RELEASE) is benchmarked.
Some tests from the octane testsuite were not repeatable (e.g. gbemu or Box2D). I excluded them from my tests,
because I want to see how the engines will optimize the code.

## How to run
```
export MAVEN_OPTS=-Xmx1024m
mvn exec:java -Dexec.mainClass="de.heikomaass.rhinovsnashorn.NashornBenchmark"
mvn exec:java -Dexec.mainClass="de.heikomaass.rhinovsnashorn.RhinoBenchmark"
```

## Example test results

The following test results were generated on a MacBook Pro (2 GHz Core i7) with JDK 1.8.0\_65. 
The heap size (Xmx) was set to 1024m. All testsuites were executed four times to allow the engines to speed up.

### Mozilla Rhino

Test             | Iteration 1   | Iteration 2   | Iteration 3   | Iteration 4   |
-----------------|---------------|---------------|---------------|---------------|
Splay|1083|1148|1210|1863
Crypto|470|489|486|454
RegExp|171|191|179|178
RayTrace|636|606|590|594
SplayLatency|521|1066|1115|1396
NavierStokes|639|626|645|663
Richards|509|462|479|544
EarleyBoyer|695|686|678|669
CodeLoad|3891|7657|9686|9586
DeltaBlue|488|499|489|482

Please note that pdfjs-test is missing because the bytecode generator exceeds the 64k bytecode length for a method and fails
with an error.

### Nashorn (1.8.0u65)
Test             | Iteration 1   | Iteration 2   | Iteration 3   | Iteration 4   |
-----------------|---------------|---------------|---------------|---------------|
Splay|2035|2559|4425|3773
Crypto|726|1227|1448|1626
RegExp|494|527|583|591
RayTrace|600|939|954|885
SplayLatency|1421|1729|1530|1547
NavierStokes|1249|1484|1478|1525
Richards|123|3746|3675|4152
EarleyBoyer|667|4059|3990|4005
CodeLoad|71.7|173|259|293
PdfJS|363|912|1134|1078
DeltaBlue|105|286|1765|1798

