#include<stdio.h>
#include<stdlib.h>



#define MAX 10



void initAlloc(int alloc[], int n)
{
	for(int i=0; i<n; ++i)
	{
		alloc[i] = -1;
	}
}

void dispAlloc(int alloc[], int n)
{
	printf("\n");
	for(int i=0; i<n; ++i)
	{
		if(alloc[i] != -1)
		{
			printf("Process %d Allocated to Block %d\n", i+1, alloc[i]+1);
		}
		else
		{
			printf("Process %d not Allocated!!\n", i+1);
		}
	}
	printf("\n");
}


void firstFit(int blockSize[], int m, int processSize[], int n)
{
	int alloc[n];
	initAlloc(alloc, n);

	for(int i=0; i<n; ++i)
	{
		for(int j=0; j<m; ++j)
		{
			if(blockSize[j] >= processSize[i])
			{
				alloc[i] = j;
				blockSize[j] -= processSize[i];
				break;
			}
		}
	}

	printf("\nFirst Fit Allocation : \n");
	dispAlloc(alloc,n);
}



void bestFit(int blockSize[], int m, int processSize[], int n)
{
	int alloc[n];
	initAlloc(alloc,n);

	for(int i=0; i<n; ++i)
	{
		int bestIndex = -1;
		for(int j=0; j<m; ++j)
		{
			if(blockSize[j] >= processSize[i])
			{
				if(bestIndex == -1 || blockSize[bestIndex] > blockSize[j])
				{
					bestIndex = j;
				}
			}
		}

		if(bestIndex != -1)
		{
			alloc[i] = bestIndex;
			blockSize[bestIndex] -= processSize[i];
		}
	}

	printf("Best Fit Allocation : \n");
	dispAlloc(alloc,n);
}



void worstFit(int blockSize[], int m, int processSize[], int n)
{
	int alloc[n];
	initAlloc(alloc, n);

	for(int i=0; i<n; ++i)
	{
		int worstIndex = -1;
		for(int j=0; j<m; ++j)
		{
			if(blockSize[j] >= processSize[i])
			{
				if(worstIndex == -1 || blockSize[worstIndex] < blockSize[j])
				{
					worstIndex = j;
				}
			}
		}
		if(worstIndex != -1)
		{
			alloc[i] = worstIndex;
			blockSize[worstIndex] -= processSize[i];
		}
	}


	printf("Worst Fit Allocation : \n");
	dispAlloc(alloc, n);
}


void acceptArray(int a[], int n)
{
	for(int i=0; i<n; ++i)
	{
		scanf("%d",&a[i]);
	}
}


void resetBlocksize(int copy[], int original[], int n)
{
	for(int i=0; i<n; ++i)
	{
		copy[i] = original[i];
	}
}



int main()
{
	int originalBlockSize[MAX] = {100, 500, 200, 300, 600};
	int blockSize[MAX];
	int processSize[MAX] = {212, 417, 112, 426};

	int m=5;
	int n=4;


	// printf("Enter Block Size : ");
	// scanf("%d",&m);

	// printf("Enter size of each Block : ");
	// acceptArray(blockSize, m);



	// printf("Enter Process Size : ");
	// scanf("%d",&n);

	// printf("Enter size of each Process : ");
	// acceptArray(processSize, n);


	resetBlocksize(blockSize, originalBlockSize, m);
	firstFit(blockSize, m, processSize, n);

	resetBlocksize(blockSize, originalBlockSize, m);
	bestFit(blockSize, m, processSize, n);

	resetBlocksize(blockSize, originalBlockSize, m);
	worstFit(blockSize, m, processSize, n);

	return 0;
}