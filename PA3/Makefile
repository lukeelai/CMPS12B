#Luke Lai    Gabriel Reyes
#luelai      ghreyes
#1355154     1348575
#11/17/14
#Makefile
#A simple makefile for xref.java

JAVASRC    = xref.java auxlib.java Tree.java Queue.java
SOURCES    = ${JAVASRC} Makefile
ALLSOURCES = ${SOURCES}
MAINCLASS  = xref
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}

all: ${CLASSES}

%.class: %.java
	javac -Xlint $<

clean:
	rm -f *.class

test: all
	java xref test.txt

.PHONY: clean all test
