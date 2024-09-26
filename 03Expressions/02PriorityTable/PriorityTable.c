/*
	include : "/home/vaibhav/Documents/omkar/DSA/DSA_using_C/03Stack/03Expressions/02PriorityTable/PriorityTable.h"
	compile : /home/vaibhav/Documents/omkar/DSA/DSA_using_C/03Stack/03Expressions/02PriorityTable/PriorityTable.c 
*/





#include "PriorityTable.h"


struct PriorityTable operatorTable[OPERATOR_SIZE] ={
													{'$',3},
													{'*',2},
													{'/',2},
													{'-',1},
													{'+',1},
													{'(',0}
												  };


int getPriority(char opr)
{
	for(char i=0; i<OPERATOR_SIZE; ++i)
	{
		if( operatorTable[i].opr == opr )
			return operatorTable[i].priority;
	}
	return -1;
}