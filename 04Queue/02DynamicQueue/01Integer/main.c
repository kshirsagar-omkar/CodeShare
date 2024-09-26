#include <stdio.h>
#include "intQueue.h"



int main()
{

	struct Queue *queue = (struct Queue*) malloc(sizeof(struct Queue));
	init(queue);


	while(1)
	{
		bool flag = false;
		int choice = 0;
		int data = 0;
		printf("\nMenu : \n1.addQ\n2.delQ\n3.peek\n4.exit\n\nEnter Choice : ");
		scanf("%d", &choice);

		switch(choice)
		{
			case 1:
					printf("\nEnter Data : ");
					scanf("%d",&data);
					addQ(queue, data);
					break;
			case 2:
					if( isEmpty(queue) )
					{
						printf("queue is Empty!!!\n");
					}
					else
					{
						printf("%d \n",delQ(queue));
					}
					break;
			case 3:
					if( isEmpty(queue) )
					{
						printf("queue is Empty!!!\n");
					}
					else
					{
						printf("%d \n",peek(queue));
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


	freeQueue(queue);
	free(queue);
	return 0;
}