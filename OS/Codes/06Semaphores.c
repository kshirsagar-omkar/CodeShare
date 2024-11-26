#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>
#include<semaphore.h>



#define BUFFER_SIZE 5
#define NUM_PRODUCTION 10



int buffer[BUFFER_SIZE], count=0;
sem_t empty, mutex, full;

void* producer(void *arg)
{
    for(int i=0; i<NUM_PRODUCTION; ++i)
    {
        sem_wait(&empty);
        sem_wait(&mutex);
        buffer[count++] = i;
        printf("Producer Produced : %d\n", i);
        sem_post(&mutex);
        sem_post(&full);
    }
    return NULL;
}


void* consumer(void* args)
{
    for(int i=0; i<NUM_PRODUCTION; ++i)
    {
        sem_wait(&full);
        sem_wait(&mutex);
        printf("Consumer Consumed : %d\n",buffer[--count]);
        sem_post(&mutex);
        sem_post(&empty);
    }
}


int main()
{

    pthread_t prod, cons;

    sem_init(&empty, 0, BUFFER_SIZE);
    sem_init(&mutex, 0, 1);
    sem_init(&full, 0, 0);

    pthread_create(&prod, NULL, producer, NULL);
    pthread_create(&cons, NULL, consumer, NULL);

    pthread_join(prod, NULL);
    pthread_join(cons, NULL);

    sem_destroy(&empty);
    sem_destroy(&mutex);
    sem_destroy(&full);

    return 0;
}