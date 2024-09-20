#include "int_stack.h"



void init(struct Stack **top)
{
	//If given Stack is Pointing to some memory
	freeStack(&(*top));
	(*top)=BOTTOM;
}


bool isEmpty(struct Stack **top)
{
	return (*top) == BOTTOM;
}


void push(struct Stack **top, int data)
{
	struct Stack *temp = NEWNODE;
	temp->next = NULL;
	temp->prev = NULL;
	temp->data = data;

	if((*top) == BOTTOM)
	{
		(*top) = temp;
		return;
	}
	else
	{
		(*top)->next = temp;
		temp->prev = (*top);
		(*top) = (*top)->next;
	}

}


int pop(struct Stack **top)
{
	int data = (*top)->data;
	struct Stack *temp = (*top);
	(*top) = (*top)->prev;

	if(*top)
	{
		(*top)->next = NULL;
	}

	free(temp);
	return data;
	
}



int peek(struct Stack **top)
{
	return (*top)->data;
}




void freeStack(struct Stack **top)
{
	while( !isEmpty( &(*top) ) ) pop( &(*top) );
}