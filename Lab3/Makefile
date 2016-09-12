# Makefile for Programming Assignment 2

JAVASRC    = Calc.java CalcTest.java
SOURCES    = ${JAVASRC} Makefile README
MAINCLASS  = Calc
CLASSES    = ${JAVASRC:.java=.class}
JARCLASSES = ${CLASSES} CalcTest.class
JARFILE    = CalcTest
TESTCLASS  = Calc
CLASSPATH  = "junit-4.12-beta-1.jar:hamcrest-core-1.3.jar:."

all : ${JARFILE}

${JARFILE} : ${CLASSES}
	echo "Main-class: ${MAINCLASS}" >Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	chmod +x ${JARFILE}
	rm Manifest

%.class : %.java
	javac -cp ${CLASSPATH} $<

test : ${TESTCLASS}Test.class ${TESTCLASS}.class
	java -cp ${CLASSPATH} org.junit.runner.JUnitCore ${TESTCLASS}Test

clean :
	rm -f *.class Manifest

spotless : clean
	rm -f ${JARFILE}

submit : ${SOURCES}
	submit ${SUBMITDIR} ${SOURCES}

.PHONY:all test clean spotless
