#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>




#define NEWNODE (struct node*) malloc(sizeof(struct node))
#define BOTTOM NULL




struct node
{
	struct node *next;
	int data;
	struct node *prev;
};



struct Stack
{
	struct node *head;		// Hold LinkedList
	struct node *top;		// Point To Topmost Node
};




void init(struct Stack *stack);
bool isEmpty(struct Stack *stack);
void push(struct Stack *stack, int data);
int pop(struct Stack *stack);
int peek(struct Stack *stack);
void freeStack(struct Stack *stack);





void init(struct Stack *stack)
{

	freeStack(stack);

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





void display(struct Stack *stack)
{
	if(stack == NULL)
	{
		return;
	}

	struct node* t = stack->head;
	printf("\n");
	while(t)
	{
		printf("%d ",t->data);
		t = t->next;
	}
	printf("\n");
}



int main()
{
	struct Stack *stack = (struct Stack*) malloc(sizeof(struct Stack));
	init(stack);


	while(1)
	{
		bool flag = false;
		int choice = 0;
		int data = 0;
		printf("\nMenu : \n1.push\n2.pop\n3.peek\n4.exit\n\nEnter Choice : ");
		scanf("%d", &choice);

		switch(choice)
		{
			case 1:
					printf("\nEnter Data : ");
					scanf("%d",&data);
					push(stack, data);
					break;
			case 2:
					if( isEmpty(stack) )
					{
						printf("stack is Empty!!!\n");
					}
					else
					{
						printf("%d \n",pop(stack));
					}
					break;
			case 3:
					if( isEmpty(stack) )
					{
						printf("stack is Empty!!!\n");
					}
					else
					{
						printf("%d \n",peek(stack));
					}
					break;
			case 4:
					flag = true;
					break;
			default:
				printf("\n***Invalid Choice!!!***\n");
		}
		if(flag)
		{
			printf("\nEnding The Application...\n");
			break;
		}
	}



	freeStack(stack);


	free(stack);
	return 0;
}

