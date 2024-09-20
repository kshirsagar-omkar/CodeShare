#include<stdio.h>

#include "int_stack.h"

int main()
{
	struct Stack *stack=NULL;



	init(&stack);

	while(1)
	{
		int flag = false;
		int choice = 0;
		int data = 0;
		printf("\nMenu : \n1.push\n2.pop\n3.peek\n4.exit\nEnter Choice : ");
		scanf("%d", &choice);

		switch(choice)
		{
			case 1:
					printf("\nEnter Data : ");
					scanf("%d",&data);
					push(&stack, data);
					break;
			case 2:
					if( isEmpty(&stack) )
					{
						printf("stack is Empty\n");
					}
					else
					{
						printf("%d \n",pop(&stack));
					}
					break;
			case 3:
					if( isEmpty(&stack) )
					{
						printf("stack is Empty\n");
					}
					else
					{
						printf("%d \n",peek(&stack));
					}
					break;
			case 4:
					flag = true;
					break;
			default:
				printf("***Invalid Choice!!!***\n");
		}
		if(flag)
		{
			printf("Ending The Application...\n");
			break;
		}
	}



	//Free All Remaing Stack After Succesfull Execution
	freeStack(&stack);

	return 0;
}