#include "IntQueue.h"


int Q[SIZE];
int front;
int rare;


void init()
{
	front = START;
	rare = START;
}

bool isEmpty()
{
	return ( front == rare );
}

bool isFull()
{
	return ( rare == SIZE-1 );
}

void addQ(int data)
{
	Q[++rare] = data;
}

int delQ()
{
	return Q[++front];
}

int peek()
{
	return Q[front+1];
}