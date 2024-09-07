#include <stdio.h>
#include <stdlib.h>


#define COLNEWNODE (struct NodeCol*) malloc(sizeof(struct NodeCol))
#define ROWNEWNODE (struct NodeRow*) malloc(sizeof(struct NodeRow))

struct NodeCol
{
	int data;
	struct NodeCol *next;
};


struct NodeRow
{
	struct NodeCol *current;
	struct NodeRow *down;	
};







struct NodeCol* createCol(const int n)
{

	if( n <= 0 )
	{
		printf("error : Check The Input size !!\n");
		return NULL;
	}

	struct NodeCol *firstNode = COLNEWNODE;

	struct NodeCol *lastNode = firstNode;
	printf("\nEnter The Data : ");
	scanf("%d",&lastNode->data);
	lastNode->next = NULL;	

	for(size_t i=2; i<=n; ++i)
	{
		lastNode->next = COLNEWNODE;
		lastNode = lastNode->next;

		printf("Enter The Data : ");
		scanf("%d",&lastNode->data);
		lastNode->next = NULL;	
	}
	return firstNode;
}



struct NodeRow *createRow(const int row)
{
	if( row <= 0 )
	{
		printf("error : Check The Input size !!\n");
		return NULL;
	}

	struct NodeRow *head = ROWNEWNODE;
	struct NodeRow *temp = head;
	int col = 0;

	printf("\nHow Many Columns Youn Want To Create : ");
	scanf("%d",&col);

	temp->current = createCol(col);
	temp->down = NULL;

	for(size_t i=2; i<=row; ++i)
	{
		temp->down = ROWNEWNODE;
		temp = temp->down;

		printf("\nHow Many Columns Youn Want To Create : ");
		scanf("%d",&col);

		temp->current = createCol(col);
		temp->down = NULL;
	}
	return head;
}




void display(struct NodeCol *firstNode)
{
	struct NodeCol *temp = firstNode;

	while(temp)
	{
		printf("%d --> ", temp->data);
		temp = temp->next;
	}
	printf("NULL\n");
}




void MatrixDisplay(struct NodeRow *head)
{
	if(!head)
	{
		printf("ERROR 'MatrixDisplay' : Given Node is Empty!!!");
		exit(0);
	}

	struct NodeRow *temp = head;

	printf("\n\nLinked List : \n\n");
	
	while(temp)
	{
		display(temp->current); 
		printf("|\nv\n");
		temp = temp->down;
	}
	printf("NULL\n");
} 

struct NodeCol* freeRow(struct NodeCol *firstNode)
{

	while(firstNode)
	{
		struct NodeCol *temp = firstNode;
		firstNode = firstNode->next;
		free(temp);
	}
	return firstNode;
}


struct NodeRow *freeAll(struct NodeRow *head)
{
	while(head)
	{
		struct NodeRow *temp = head;
		head = head->down;
		temp->current = freeRow(temp->current);
		free(temp);
	}
	return head;
}



int main()
{

	


	
	struct NodeRow *head = NULL;

	int row=0;
	printf("How Many Rows Youn Want To Create : ");
	scanf("%d",&row);

	head = createRow(row);
	MatrixDisplay(head);





	head = freeAll(head);

	return 0;
}