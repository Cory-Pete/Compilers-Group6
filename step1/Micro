#!/bin/bash

antlr4 Little.g4
javac Little*.java

javac Driver.java
java Driver $1

rm -rf *.class
rm -rf Little*.java
rm -rf *.tokens
rm -rf *.interp
