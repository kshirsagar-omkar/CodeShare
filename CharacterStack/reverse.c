#include <stdio.h>
#include "char_stack.h"
#include "reverse.h"


void printAndPop(struct StaticStack *stack)
{
	while( !isEmpty(stack) )
	{
		printf("%c",pop(stack));
	}
	printf(" ");
}


void reverseString(const char *s)
{
	struct StaticStack stack;
	init(&stack);

	for (int i = 0; s[i] ; ++i)
	{
		push(&stack, s[i]);
	}


	printAndPop(&stack);
}




void reverseWordsInString(const char *s)
{
	struct StaticStack stack;
	init(&stack);

	for(int i=0; s[i+1]; ++i)
	{
		if(s[i]==' ')
		{
			printAndPop(&stack);
		}
		else if(s[i+1]=='\n')
		{
			push(&stack,s[i]);
			printAndPop(&stack);
		}
		else
		{
			push(&stack,s[i]);
		}
	}
}

