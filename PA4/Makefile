# Luke Lai   and   Gabriel Reyes
# luelai    and   ghreyes
# CMPS12b
# 12/7/2014
# Makefile
# A simple makefile for cyoa.java and demo.adventure

JAVASRC    = cyoa.java
SOURCES    = ${JAVASRC} Makefile
ALLSOURCES = ${SOURCES}
MAINCLASS  = cyoa
CLASSES    = cyoa.class Node.class Onode.class Dllist.class

all: ${CLASSES}

%.class: %.java
	javac -Xlint $<

clean:
	rm -f *.class

test: all
	java cyoa demo.adventure

.PHONY: clean all test
