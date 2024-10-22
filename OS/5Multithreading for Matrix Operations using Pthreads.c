/*
Lab Assignment-5: Multithreading for Matrix Operations using Pthreads
*/


#include <stdio.h>
#include <pthread.h>

#define N 3  // Number of rows
#define M 3  // Number of columns

int matrixA[N][M] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
int matrixB[N][M] = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
int matrixC[N][M];

typedef struct {
    int row;
} MatrixArgs;

void* add_matrices(void* arg) {
    MatrixArgs* data = (MatrixArgs*)arg;
    int row = data->row;

    for (int i = 0; i < M; i++) {
        matrixC[row][i] = matrixA[row][i] + matrixB[row][i];
    }
    pthread_exit(0);
}

int main() {
    pthread_t threads[N];
    MatrixArgs args[N];

    for (int i = 0; i < N; i++) {
        args[i].row = i;
        pthread_create(&threads[i], NULL, add_matrices, (void*)&args[i]);
    }

    for (int i = 0; i < N; i++) {
        pthread_join(threads[i], NULL);
    }

    printf("Resultant Matrix (MatrixC):\n");
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            printf("%d ", matrixC[i][j]);
        }
        printf("\n");
    }

    return 0;
}
