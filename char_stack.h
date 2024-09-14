#ifndef STATIC_STACK
#define STATIC_STACK


#include <stdbool.h>


#define SIZE 30
#define BOTTOM -1



struct StaticStack
{
	int top;
	char stack[SIZE];
	
};




void init(struct StaticStack *stack);

bool isEmpty(struct StaticStack *stack);
bool isFull(struct StaticStack *stack);

void push(struct StaticStack *stack, char data);
char pop(struct StaticStack *stack);
char peek(struct StaticStack *stack);


void display(struct StaticStack *stack);

#endif
