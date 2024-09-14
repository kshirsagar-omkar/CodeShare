#include <stdio.h>
#include <string.h>
#include "char_stack.h"
#include "reverse.h"



int main()
{

	char s[30] = {0};

	printf("Enter String : ");
	fgets(s, sizeof(s), stdin);


	reverseString(s);

	printf("\n");

	reverseWordsInString(s);


	return 0;
}