//Luke Lai
//1355154
//luelai
//11/5/14
//queue.c
//Circular queue

#include <stdio.h>
#include <stdlib.h>

#include "minunit.h"

#define MAXSIZE 100

int tests_run = 0; // keep track of number of unit tests run

typedef enum q_status {
    /* Enumerated status codes for queue operations */
    q_success = 0,
    q_failure
} q_status;

/**** Private variables for queue ****/
static int head;
static int tail;
static int elem;
static int queue[MAXSIZE];
/**** Functions on queues ****/

q_status q_init(void) {
    /* Initialize the queue */
	head = 0;
	tail = 0;
	elem = 0;
	return q_success;
}

q_status q_insert(int value) {
    /* Insert an item into back of queue
    *  Returns q_success on success.
    */	
	if((head == tail && elem != 0) || (head == 0 && tail == MAXSIZE)){	
			return q_failure;		
		}
	else if(tail == MAXSIZE){
		tail = 0;
		queue[tail] = value;
		tail++;
	}else{
		queue[tail] = value;
		tail++;
			
	}elem++;
	return q_success;
}

q_status q_remove(int *value) {
    /* Remove item from front of queue
       Stores item at front of queue into pointer
       given as argument. Removes item from queue.
       Returns qSuccess on success.
    */
    	if(elem == 0 || value == NULL){
		return q_failure;
	}else{
		*value = queue[head];
		head++;
		if(head == MAXSIZE)
			head = 0;
	}elem--;
	return q_success;
	
}

q_status q_peek(int *value) {
    /* Peek at item at front of queue
       Stores item at front of queue into pointer
       given as argument. Queue is not altered.
       Returns qSuccess on success.
    */
    if(elem == 0 || value == NULL){
		return q_failure;
	}else{
		*value = queue[head];
	}return q_success;
}

q_status q_destroy(void) {
    /* Destroy the queue */
	head = 0;
	tail = 0;
	elem = 0;
	return q_success;
			
}

q_status q_is_empty(void) {
	if(elem == 0)
		return 0;
	else
		return 1;
}

/**** Unit tests ****/

char * test_lifecycle(void) {
    mu_assert("init", q_init() == q_success);
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_one_insert(void) {
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(7) == q_success);
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_one_insert_remove(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(16) == q_success);
    mu_assert("remove", q_remove(&v) == q_success);
    mu_assert("value", v == 16);
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_two_insert_remove(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(8) == q_success);
    mu_assert("insert", q_insert(91) == q_success);
    mu_assert("remove", q_remove(&v) == q_success);
    mu_assert("value", v == 8);
    mu_assert("remove", q_remove(&v) == q_success);
    mu_assert("value", v == 91);
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_multi_insert_remove(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(8) == q_success);
    mu_assert("insert", q_insert(91) == q_success);
    for(int i = 0; i < 1000; i++) {
        mu_assert("insert", q_insert(8) == q_success);
        mu_assert("insert", q_insert(91) == q_success);
        mu_assert("remove", q_remove(&v) == q_success);
        mu_assert("value", v == 8);
        mu_assert("remove", q_remove(&v) == q_success);
        mu_assert("value", v == 91);
    }
    mu_assert("remove", q_remove(&v) == q_success);
    mu_assert("value", v == 8);
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_indexed_insert_remove(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    for(int i = 0; i < 30; i++) {
        mu_assert("insert", q_insert(i) == q_success);
    }
    for(int i = 0; i < 1000; i++) {
        mu_assert("remove", q_remove(&v) == q_success);
        mu_assert("value", v == i);
        mu_assert("insert", q_insert(30 + i) == q_success);
    }
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_too_many_remove(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("remove", q_remove(&v) == q_failure);
    return NULL;
}

char * test_insert_too_many_remove(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    for(int i = 0; i < 30; i++) {
        mu_assert("insert", q_insert(i) == q_success);
    }
    for(int i = 0; i < 30; i++) {
        mu_assert("remove", q_remove(&v) == q_success);
        mu_assert("value", v == i);
    }
    mu_assert("remove", q_remove(&v) == q_failure);
    return NULL;
}

char * test_peek(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(18) == q_success);
    mu_assert("peek", q_peek(&v) == q_success);
    mu_assert("value", v == 18);
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_peek_two(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(18) == q_success);
    mu_assert("insert", q_insert(42) == q_success);
    mu_assert("peek", q_peek(&v) == q_success);
    mu_assert("value", v == 18);
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}
char * test_peek_deep(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    for(int i = 0; i < 30; i++) {
        mu_assert("insert", q_insert(i) == q_success);
    }
    for(int i = 0; i < 1000; i++) {
        mu_assert("peek", q_peek(&v) == q_success);
        mu_assert("value", v == i);
        mu_assert("remove", q_remove(&v) == q_success);
        mu_assert("value", v == i);
        mu_assert("insert", q_insert(30 + i) == q_success);
    }
    mu_assert("destroy", q_destroy() == q_success);
    return NULL;
}

char * test_peek_empty(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("peek", q_peek(&v) == q_failure);
    return NULL;
}


char * test_peek_two_empty(void) {
    int v;
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(18) == q_success);
    mu_assert("insert", q_insert(42) == q_success);
    mu_assert("remove", q_remove(&v) == q_success);
    mu_assert("remove", q_remove(&v) == q_success);
    mu_assert("peek", q_peek(&v) == q_failure);
    return NULL;
}

char * test_remove_null(void) {
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(18) == q_success);
    mu_assert("peek", q_remove(NULL) == q_failure);
    return NULL;
}

char * test_peek_null(void) {
    mu_assert("init", q_init() == q_success);
    mu_assert("insert", q_insert(18) == q_success);
    mu_assert("peek", q_peek(NULL) == q_failure);
    return NULL;
}

char * test_extra_three(void) {
	int v;
	mu_assert("init", q_init() == q_success);
	mu_assert("insert", q_insert(5) == q_success);
	mu_assert("insert", q_insert(12)== q_success);
	mu_assert("insert", q_insert(-1) == q_success);
	mu_assert("remove", q_remove(&v) == q_success);
	mu_assert("value", v == 5);
	mu_assert("remove", q_remove(&v) == q_success);
	mu_assert("value", v == 12);
	mu_assert("remove", q_remove(&v) == q_success);
	mu_assert("value", v == -1);
	mu_assert("destroy", q_destroy() == q_success);
	return NULL;
}

char * test_is_empty_one(void) {
	mu_assert("init", q_init() == q_success);
	mu_assert("empty", q_is_empty() == 0);
	return NULL;
}

char * test_is_empty_two(void) {
	mu_assert("init", q_init() == q_success);
	mu_assert("insert", q_insert(1) == q_success);
	mu_assert("empty", q_is_empty() == 1);
	return NULL;
}
		

char * all_tests(void) {
    /* Run all unit tests */
    mu_run_test(test_lifecycle);
    mu_run_test(test_one_insert);
    mu_run_test(test_one_insert_remove);
    mu_run_test(test_two_insert_remove);
    mu_run_test(test_multi_insert_remove);
    mu_run_test(test_indexed_insert_remove);
    mu_run_test(test_too_many_remove);
    mu_run_test(test_insert_too_many_remove);
    mu_run_test(test_peek);
    mu_run_test(test_peek_two);
    mu_run_test(test_peek_deep);
    mu_run_test(test_peek_empty);
    mu_run_test(test_peek_two_empty);
    mu_run_test(test_remove_null);
    mu_run_test(test_peek_null);
    mu_run_test(test_extra_three);
    mu_run_test(test_is_empty_one);
    mu_run_test(test_is_empty_two);
    return NULL;
}

/**** Main unit test runner ****/

int main(int argc, char *argv[]) {
    printf("Queue Module unit tests\n");
    char *result = all_tests();
    if (result) {
        printf("FAILURE at %s\n", result);
    } else {
        printf("ALL TESTS PASS\n");
    }
    printf("Tests run: %d\n", tests_run);
    return EXIT_SUCCESS;
}
