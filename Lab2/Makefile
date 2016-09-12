# Luke Lai
# 1355154
# 10/19/14
# Makefile
# Makefile for lab2

JAVASRC = greet.java greetings.java
SOURCES = README makefile ${JAVASRC}
CLASSES = greet.class greetings.class
JARFILE = myGreet myGreetings
JARCLASSES = ${CLASSES}

all: ${JARFILE}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}
	
runGreet: greet.class
	java greet

runGreetings: greetings.class
	java greetings

clean: 
	rm ${CLASSES} ${JARFILE}

.PHONY: clean all
