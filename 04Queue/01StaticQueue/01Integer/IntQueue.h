#ifndef INT_QUEUE
#define INT_QUEUE

#include <stdbool.h>

#define START -1
#define SIZE 5




void init();
bool isEmpty();
bool isFull();
void addQ(int data);
int delQ();
int peek();



#endif