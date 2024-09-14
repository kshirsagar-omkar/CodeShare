#include "char_stack.h"
#include <stdio.h>




void init(struct StaticStack *stack)
{
	stack->top = BOTTOM;
}



bool isEmpty(struct StaticStack *stack)
{
	return stack->top == BOTTOM;
}


bool isFull(struct StaticStack *stack)
{
	return stack->top == SIZE-1;
}


void push(struct StaticStack *stack, char data)
{
	stack->stack[++stack->top] = data;
}

char pop(struct StaticStack *stack)
{
	return stack->stack[stack->top--];
}


char peek(struct StaticStack *stack)
{
	return stack->stack[stack->top];
}



void display(struct StaticStack *stack)
{
	for(int i=0; i<=stack->top; ++i)
	{
		printf("%d ",stack->stack[i]);
	}
	printf("\n");
}