#ifndef INT_STACK
#define INT_STACK 

#include<stdlib.h>
#include<stdbool.h>



#define NEWNODE (struct Stack*) malloc(sizeof(struct Stack))

#define BOTTOM NULL


struct Stack{
	struct Stack *prev;
	int data;
	struct Stack *next;
};





void init(struct Stack **top);
bool isEmpty(struct Stack **top);
void push(struct Stack **top, int data);
int pop(struct Stack **top);
int peek(struct Stack **top);


void freeStack(struct Stack **top);





#endif