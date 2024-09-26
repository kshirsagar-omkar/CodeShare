#ifndef PRIORITY_TABLE
#define PRIORITY_TABLE

#define OPERATOR_SIZE 6

struct PriorityTable
{
	char opr;			//used for store Operator
	int priority;		//Used for Priority of Operator 
};



int getPriority(char opr);



#endif