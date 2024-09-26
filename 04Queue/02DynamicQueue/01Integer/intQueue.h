#ifndef INT_QUEUE 
#define INT_QUEUE

#include <stdbool.h>
#include <stdlib.h>

#define START NULL

struct node
{
	int data;
	struct node *next;
};


struct Queue
{
	struct node *front;
	struct node *rare;
};

void init( struct Queue *queue );
bool isEmpty( struct Queue *queue );
void addQ(struct Queue *queue, int data);
int delQ(struct Queue *queue);
int peek(struct Queue *queue);

void freeQueue(struct Queue *queue);


#endif