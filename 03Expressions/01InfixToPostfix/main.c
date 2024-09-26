#include <stdio.h>

#include "/home/vaibhav/Documents/omkar/DSA/DSA_using_C/03Stack/03Expressions/02PriorityTable/PriorityTable.h"
#include "/home/vaibhav/Documents/omkar/DSA/DSA_using_C/03Stack/02DYNAMIC_STACK/02Char/char_stack.h"


#define EXPRESSION_SIZE 50



int main()
{

	struct Stack *stack = (struct Stack*) malloc(sizeof(struct Stack));
	init(stack);

	char expression[EXPRESSION_SIZE];
	

	printf("Enter Infix Expression : ");
	scanf("%s",expression);


	for(int i=0; expression[i]; ++i)
	{
		if(expression[i]=='(')
		{
			push(stack, expression[i]);
			continue;
		}
		
		if(expression[i]==')')
		{
			while( !isEmpty(stack) 	)
			{
				char ch = pop(stack);
				if(ch == '(')
				{
					break;
				}
				printf("%c",ch);
			}
			continue;
		}


		if( getPriority( expression[i] ) == -1 )
		{
			printf("%c",expression[i]);
		}
		else
		{
			while( !isEmpty(stack) )
			{
				if( getPriority( peek(stack) ) >= getPriority( expression[i] ) )
				{
					printf("%c",pop(stack));
				}
				else
				{
					break;
				}
			}
			push(stack, expression[i]);
		}
	}
	while( !isEmpty(stack) ) printf("%c",pop(stack));
	printf("\n");

	

	free(stack);
	return 0;
}