#Luke Lai
#1355154
#10/21/14
#Makefile
#makefile for pa1

JAVASRC = BusinessSearch.java
SOURCES = README makefile ${JAVASRC}
MAINCLASS = BusinessSearch
CLASSES = BusinessSearch.class
JARFILE = myBusinessSearch
JARCLASSES = ${CLASSES}

all: ${JARFILE}

${JARFILE}: ${CLASSES}
	echo "Main-class: ${MAINCLASS}" > Manifest
	jar cvfm ${JARFILE} Manifest ${JARCLASSES}
	rm Manifest
	chmod +x ${JARFILE}

${CLASSES}: ${JAVASRC}
	javac -Xlint ${JAVASRC}

clean:
	rm ${CLASSES} ${JARFIlE}

runBusinessSearch: BusinessSearch.class
	java BusinessSearch

.PHONY: clean all
