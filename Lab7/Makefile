# Luke Lai
# luelai
# cmps012b
# 12/3/14
# Makefile
# A simple makefile for main.c

MKFILE    = Makefile

GCC      = gcc -g -O0 -Wall -Wextra -std=gnu99

CSOURCE   = main.c
OBJECTS   = ${CSOURCE:.c=.o}
EXECBIN   = hash
SOURCES   = ${CSOURCE} ${MKFILE}
WORDS     = words.txt

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
	./${EXECBIN} ${WORDS}

.PHONY: all clean spotless test
