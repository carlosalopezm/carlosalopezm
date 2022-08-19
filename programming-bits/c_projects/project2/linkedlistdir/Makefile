CC = gcc
CFLAGS = -g -Wall 
LDFLAGS = -g
liblinkedlist.a: linkedlist.o
	ar rcs  $@ $+

linkedlist.o: linkedlist.c linkedlist.h


.PHONY: clean
clean: 	 
	rm -f *.o  a.out core main
.PHONY:	clean_all
clean_all: 
	rm -f *.o *.o~ *.c~ *.h~ Makefile~  a.out  core main 
.PHONY: deep_clean 
deep_clean:
	rm -f .*.un~ *.o *.o~ *.c~ *.h~ Makefile~ libmylist.a mylist-test

