#include<stdio.h>
#include<stdlib.h>


int comp(const void *a, const void *b)
{
	return *(int*)a-*(int*)b;
}




void fcfs(int req[], int n, int head)
{
	int total_movement = 0;

	printf("\nFCFS Disk Scheduling Algorithm :");
	printf("\nOrder of request servicing :");

	for(int i=0; i<n; ++i)
	{
		printf("%d ",req[i]);
		total_movement += abs(req[i] - head);
		head = req[i];
	}


	printf("\nTotal Movement : %d\n",total_movement);

}





void scan(int req[], int n, int head, int diskSize, int direction)
{
	int total_movement = 0;

	qsort(req, n, sizeof(int), comp);



	printf("\nSCAN Disk Scheduling Algorithm : ");
	printf("\nOrder of request servicing : ");


	if(direction == 1)//increasing order
	{
		for(int i=0; i<n; ++i)
		{
			if(req[i] >= head)
			{
				printf("%d ",req[i]);
				total_movement += abs(req[i] - head);
				head = req[i];
			}
		}

		if(head != diskSize - 1)
		{
			total_movement += abs(diskSize - 1 - head);
			head = diskSize - 1;
			printf("%d ", head);
		}

		for(int i=n-1; i>=0; --i)
		{
			if(req[i] < head)
			{
				printf("%d ", req[i]);
				total_movement += abs(req[i] - head);
				head = req[i];
			}
		}

	}
	else
	{
		for(int i=n-1; i>=0; --i)
		{
			if(req[i] <= head)
			{
				printf("%d ", req[i]);
				total_movement += abs(head - req[i]);
				head = req[i];
			}
		}
		if(head != 0)
		{
			total_movement += abs(head-0);
			head = 0;
			printf("%d ", head);
		}
		for(int i=0; i<n; ++i)
		{
			if(req[i]>head)
			{
				printf("%d ", req[i]);
				total_movement += abs(head - req[i]);
				head = req[i];
			}
		}
	}


	printf("\ntotal head movement : %d \n", total_movement);
}



int main()
{

	int req[8] = {98, 183, 37, 122, 14, 124, 65, 67};
	int n = 8;
	int diskSize = 200;
	int head = 53;


	fcfs(req, n, head);

    scan(req, n, head, diskSize, 1);  // Direction 1 (increasing)
    scan(req, n, head, diskSize, 0);  // Direction 0 (decreasing)

	return 0;
}