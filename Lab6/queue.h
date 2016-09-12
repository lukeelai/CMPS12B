/* Luke Lai
 * luelai
 * 1355154
 * 11/21/14
 * queue.h
 * header for queue.c
 */

#ifndef __QUEUE_H__
#define __QUEUE_H__

#include <stdbool.h>

/* External interface declarations */

struct queue;
typedef struct queue queue;
typedef char *queue_item_t;

/* Function declarations */

queue *queue_new(void);

void queue_free(queue*);

void queue_insert(queue*, queue_item_t);

void queue_remove(queue*);

bool queue_isempty(queue*);

void queue_destroy(queue*);

queue_item_t queue_print(queue*);

#endif
