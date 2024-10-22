/*
Lab Assignment-9: Disk Scheduling Algorithms
a) FCFS (First-Come, First-Served) Disk Scheduling
*/



#include <stdio.h>
#include <stdlib.h>

void FCFS(int request[], int n, int head) {
    int total_seek_time = 0;

    printf("Order of request servicing: ");
    for (int i = 0; i < n; i++) {
        printf("%d -> ", request[i]);
        total_seek_time += abs(request[i] - head);
        head = request[i];
    }
    printf("\nTotal seek time: %d\n", total_seek_time);
}

int main() {
    int n, head;
    printf("Enter number of disk requests: ");
    scanf("%d", &n);

    int request[n];
    printf("Enter the disk requests: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &request[i]);
    }

    printf("Enter the initial head position: ");
    scanf("%d", &head);

    FCFS(request, n, head);
    return 0;
}








/*
b) SCAN Disk Scheduling
*/







#include <stdio.h>
#include <stdlib.h>

void SCAN(int request[], int n, int head, int disk_size, int direction) {
    int total_seek_time = 0, i;
    
    printf("Order of request servicing: ");
    // Sort requests
    for (i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (request[j] > request[j + 1]) {
                int temp = request[j];
                request[j] = request[j + 1];
                request[j + 1] = temp;
            }
        }
    }

    if (direction == 1) { // Going towards larger numbers
        for (i = 0; i < n && request[i] < head; i++);
        for (; i < n; i++) {
            printf("%d -> ", request[i]);
            total_seek_time += abs(request[i] - head);
            head = request[i];
        }
        printf("%d -> ", disk_size - 1);
        total_seek_time += abs((disk_size - 1) - head);
        head = disk_size - 1;
        for (i = n - 1; i >= 0 && request[i] > head; i--);
        for (; i >= 0; i--) {
            printf("%d -> ", request[i]);
            total_seek_time += abs(request[i] - head);
            head = request[i];
        }
    } else { // Going towards smaller numbers
        for (i = n - 1; i >= 0 && request[i] > head; i--);
        for (; i >= 0; i--) {
            printf("%d -> ", request[i]);
            total_seek_time += abs(request[i] - head);
            head = request[i];
        }
        printf("0 -> ");
        total_seek_time += abs(head - 0);
        head = 0;
        for (i = 0; i < n && request[i] < head; i++);
        for (; i < n; i++) {
            printf("%d -> ", request[i]);
            total_seek_time += abs(request[i] - head);
            head = request[i];
        }
    }

    printf("\nTotal seek time: %d\n", total_seek_time);
}

int main() {
    int n, head, disk_size, direction;

    printf("Enter number of disk requests: ");
    scanf("%d", &n);

    int request[n];
    printf("Enter the disk requests: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &request[i]);
    }

    printf("Enter the initial head position: ");
    scanf("%d", &head);

    printf("Enter the disk size: ");
    scanf("%d", &disk_size);

    printf("Enter the head movement direction (1 for up, 0 for down): ");
    scanf("%d", &direction);

    SCAN(request, n, head, disk_size, direction);
    return 0;
}
