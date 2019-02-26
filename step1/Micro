#!/bin/bash

java -jar /usr/local/lib/antlr-4.7.1-complete.jar Little.g4
javac Little*.java

javac Driver.java
java Driver $1

rm -rf *.class
rm -rf Little*.java
rm -rf *.tokens
rm -rf *.interp
