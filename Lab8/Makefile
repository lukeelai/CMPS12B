# Luke Lai
# luelai
# cmps012b
# 12/8/14
# Makefile
# A simple makefile for heap.c

MKFILE    = Makefile

GCC      = gcc -g -O0 -Wall -Wextra -std=gnu99

CSOURCE   = heap.c
OBJECTS   = ${CSOURCE:.c=.o}
EXECBIN   = heap
SOURCES   = ${CSOURCE} ${MKFILE}

all : ${EXECBIN}

${EXECBIN} : ${OBJECTS}
	${GCC} -o $@ ${OBJECTS}

%.o : %.c
	${GCC} -c $<

clean :
	rm -f ${OBJECTS} core

spotless : clean
	rm -f ${EXECBIN}

test : ${EXECBIN}
	./${EXECBIN} 10 test.txt

.PHONY: all clean spotless test
