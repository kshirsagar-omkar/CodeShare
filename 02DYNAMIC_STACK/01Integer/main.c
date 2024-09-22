#include<stdio.h>

#include "int_stack.h"




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

