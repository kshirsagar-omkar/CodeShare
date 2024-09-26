#include "intQueue.h"


void init( struct Queue *queue )
{
	freeQueue(queue);		//if queue is already exist
	queue->front = START; 
	queue->rare = START;
}


bool isEmpty( struct Queue *queue )
{
	return queue->front == NULL;
}


void addQ(struct Queue *queue, int data)
{
	struct node *temp = (struct node*) malloc( sizeof(struct node) );
	temp->next = NULL;
	temp->data = data;

	if(queue->rare == NULL)
	{
		queue->front = temp;
		queue->rare = temp;
	}
	else
	{
		queue->rare->next = temp;
		queue->rare = queue->rare->next;
	}
}


int delQ(struct Queue *queue)
{
	int data = queue->front->data;
	struct node *temp = queue->front;
	queue->front = queue->front->next;
	if(queue->front == NULL)
	{
		queue->rare = START;
	}
	free(temp);
	return data;
}


int peek(struct Queue *queue)
{
	return queue->front->data;
}


void freeQueue(struct Queue *queue)
{
	while( !isEmpty(queue) ) delQ(queue);
}