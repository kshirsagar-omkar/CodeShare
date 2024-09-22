#include "int_stack.h"



void init(struct Stack *stack)
{

	freeStack(stack);	//if stack is not empty

	stack->head = NULL;
	stack->top = BOTTOM;
};




bool isEmpty(struct Stack *stack)
{
	return stack->top == BOTTOM;
}




void push(struct Stack *stack, int data)
{
	struct node *temp = NEWNODE;
	temp->next = NULL;
	temp->prev = NULL;
	temp->data = data;

	if(stack->top == BOTTOM)
	{
		stack->head = temp;
		stack->top = temp;
	}
	else
	{
		stack->top->next = temp;
		temp->prev = stack->top;
		stack->top = stack->top->next;
	}
}


int pop(struct Stack *stack)
{
	int data = stack->top->data;
	struct node *temp = stack->top;

	stack->top = stack->top->prev;

	if(stack->top != NULL)
	{
		stack->top->next = NULL;
	}
	else
	{
		stack->head = NULL;
	}

	free(temp);
	return data;
}



int peek(struct Stack *stack)
{
	return stack->top->data;
}



void freeStack(struct Stack *stack)
{
	if(stack)
	{
		while( !isEmpty(stack) ) pop(stack);
	}
}