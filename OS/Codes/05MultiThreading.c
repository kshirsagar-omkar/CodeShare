#include<stdio.h>
#include<pthread.h>
#include<stdint.h>


#define ROW 2
#define COL 2
#define K 2


int matrix1[ROW][K] = {{1,2},{5,6}};
int matrix2[K][COL] = {{3,4},{7,8}};
int result[ROW][COL];



void *multiplyMatrix(void *arg){
	int row = (intptr_t)arg;


	for(int col =0; col<COL; ++col)
	{
		result[row][col] = 0;
		for(int k=0; k<K; ++k)
		{
			result[row][col] += matrix1[row][k] * matrix2[k][col];
		}
	}

	return NULL;
}


int main(){
	
	pthread_t threads[ROW];


	for(int i=0; i<ROW; ++i){
		int status = pthread_create(&threads[i], NULL, multiplyMatrix, (void *)(intptr_t)i);
		if(status != 0){
			printf("Failed to create threade!!");
			return 1;
		}
	}

	for(int i=0; i<ROW; ++i){
		int status = pthread_join(threads[i], NULL);
		if(status != 0){
			printf("Failed to join thread!!!");
			return 1;
		}
	}


	printf("Resultant Matrix : \n");
	for(int i=0; i<ROW; ++i){
		for(int j=0; j<COL; ++j){
			printf("%d ", result[i][j]);
		}
		printf("\n");
	}


	return 0;
}