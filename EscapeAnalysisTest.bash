#!/bin/bash
mkdir -p out
javac src/EscapeAnalysisTest.java -d out
java -cp "./out" \
-server \
-verbose:gc \
-XX:+UnlockDiagnosticVMOptions \
-XX:+TraceClassLoading \
-XX:MaxInlineSize=60 \
-XX:+LogCompilation \
EscapeAnalysisTest > /dev/null

# add this to get c1/c2 native assemblies too
# Note: you need to first build hsdis [https://github.com/AdoptOpenJDK/jitwatch/wiki/Building-hsdis]
#
# -XX:+PrintAssembly \
#
# Add this to change size limit of a method's byte-codes for inlining
#
# -XX:MaxInlineSize=100 \
