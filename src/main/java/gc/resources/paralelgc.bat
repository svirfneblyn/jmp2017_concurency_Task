java -jar
-XX:+UseParallelGC
-Xmx8g
-XX:+PrintGCApplicationStoppedTime
-XX:+PrintGCApplicationConcurrentTime
-XX:+UnlockDiagnosticVMOptions
-XX:+PrintReferenceGC
-XX:+PrintGCTimeStamps
-XX:+PrintAdaptiveSizePolicy
-XX:+PrintGCDetails
-XX:LogFile=d:\gc.log
jmp2017_gc-1.0.jar