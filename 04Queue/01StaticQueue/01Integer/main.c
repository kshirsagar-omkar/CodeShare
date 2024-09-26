#include <stdio.h>
#include "IntQueue.h"



int main()
{

	init();

	
	
	while(1)
	{
		int flag = false;
		int choice = 0;
		int data = 0;
		printf("\nMenu : \n1.addQ\n2.delQ\n3.peek\n4.exit\nEnter Choice : ");
		scanf("%d", &choice);

		switch(choice)
		{
			case 1:
					if( isFull() )
					{
						printf("Queue is full\n");
					}
					else
					{
						printf("\nEnter Data : ");
						scanf("%d",&data);
						addQ(data);
					}
					break;
			case 2:
					if( isEmpty() )
					{
						printf("Queue is Empty\n");
					}
					else
					{
						printf("%d \n",delQ());
					}
					break;
			case 3:
					if( isEmpty() )
					{
						printf("Queue is Empty\n");
					}
					else
					{
						printf("%d \n",peek());
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
		printf("\n");
	}

	return 0;	
}