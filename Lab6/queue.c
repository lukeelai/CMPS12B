/* Luke Lai
 * luelai
 * 1355154
 * 11/21/14
 * queue.c
 * makes a queue with insert, delete, ismepty, destroy, printall
 */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "queue.h"

#define STUBPRINTF(...) fprintf(stderr, __VA_ARGS__);

/* Internal implementation definitions */
struct queue_node {
   queue_item_t value;
   struct queue_node *next;
};

typedef struct queue_node queue_node;

struct queue {
   queue_node *front;
   queue_node *rear;
};

/* Functions */

queue *queue_new(void) {
   	queue *n = malloc(sizeof(struct queue));
	n->front = NULL;
	n->rear = NULL;
	return n;
}

void queue_free(queue *this) {
	assert(queue_isempty(this));
   	free(this);
}

void queue_insert(queue *this, queue_item_t value) {
	queue_node *n = malloc(sizeof(struct queue_node));
	if(queue_isempty(this)){
		this->front = n;
		this->rear = n;
	}else{
		this->rear->next = n;
	}
	n->value = value;
	n->next = NULL;
	this->rear = n;
}

void queue_remove(queue *this) {
	if(queue_isempty(this)){
		return; 
	}else{
		queue_node *temp = this->front;
		this->front = this->front->next;
		free(temp->value);
		free(temp);
	}
}

queue_item_t queue_print(queue *this){
	if(queue_isempty(this))
		return NULL;
		return this->front->value;
}

void queue_destroy(queue *this){
	free(this);
}

bool queue_isempty(queue *this) {
   return this->front == NULL;
}
