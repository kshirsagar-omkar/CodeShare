/*
Lab Assignment-6: Producer-Consumer Problem using Semaphores
*/


#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>

#define BUFFER_SIZE 5
int buffer[BUFFER_SIZE];
int count = 0;

sem_t empty, full, mutex;

void* producer(void* arg) {
    int item;
    for (int i = 0; i < 10; i++) {
        item = i;
        sem_wait(&empty);
        sem_wait(&mutex);
        
        // Critical Section
        buffer[count++] = item;
        printf("Producer produced: %d\n", item);
        
        sem_post(&mutex);
        sem_post(&full);
    }
}

void* consumer(void* arg) {
    int item;
    for (int i = 0; i < 10; i++) {
        sem_wait(&full);
        sem_wait(&mutex);
        
        // Critical Section
        item = buffer[--count];
        printf("Consumer consumed: %d\n", item);
        
        sem_post(&mutex);
        sem_post(&empty);
    }
}

int main() {
    pthread_t prod, cons;
    
    sem_init(&empty, 0, BUFFER_SIZE);
    sem_init(&full, 0, 0);
    sem_init(&mutex, 0, 1);
    
    pthread_create(&prod, NULL, producer, NULL);
    pthread_create(&cons, NULL, consumer, NULL);
    
    pthread_join(prod, NULL);
    pthread_join(cons, NULL);
    
    sem_destroy(&empty);
    sem_destroy(&full);
    sem_destroy(&mutex);

    return 0;
}
