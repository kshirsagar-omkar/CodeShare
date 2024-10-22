/*


Lab Assignment-4: CPU Scheduling Algorithms
a) FCFS (First-Come, First-Served) Scheduling


*/


#include<stdio.h>

int main() {
    int n, i;
    int arrival_time[10], burst_time[10], waiting_time[10], turnaround_time[10];
    int total_wt = 0, total_tat = 0;

    printf("Enter number of processes: ");
    scanf("%d", &n);

    printf("Enter Arrival Time and Burst Time for each process:\n");
    for(i=0; i<n; i++) {
        printf("Process %d - Arrival Time: ", i+1);
        scanf("%d", &arrival_time[i]);
        printf("Process %d - Burst Time: ", i+1);
        scanf("%d", &burst_time[i]);
    }

    // FCFS Scheduling
    waiting_time[0] = 0;
    for(i=1; i<n; i++) {
        waiting_time[i] = burst_time[i-1] + waiting_time[i-1];
    }

    for(i=0; i<n; i++) {
        turnaround_time[i] = burst_time[i] + waiting_time[i];
        total_wt += waiting_time[i];
        total_tat += turnaround_time[i];
    }

    printf("\nProcess\tArrival Time\tBurst Time\tWaiting Time\tTurnaround Time\n");
    for(i=0; i<n; i++) {
        printf("%d\t%d\t\t%d\t\t%d\t\t%d\n", i+1, arrival_time[i], burst_time[i], waiting_time[i], turnaround_time[i]);
    }

    printf("\nAverage Waiting Time = %.2f", (float)total_wt/n);
    printf("\nAverage Turnaround Time = %.2f\n", (float)total_tat/n);
    return 0;
}




/*
b) SJF (Shortest Job First) Scheduling
*/





#include<stdio.h>

int main() {
    int n, i, j, min, temp;
    int arrival_time[10], burst_time[10], waiting_time[10], turnaround_time[10];
    int total_wt = 0, total_tat = 0;

    printf("Enter number of processes: ");
    scanf("%d", &n);

    printf("Enter Arrival Time and Burst Time for each process:\n");
    for(i=0; i<n; i++) {
        printf("Process %d - Arrival Time: ", i+1);
        scanf("%d", &arrival_time[i]);
        printf("Process %d - Burst Time: ", i+1);
        scanf("%d", &burst_time[i]);
    }

    // SJF Scheduling
    for(i=0; i<n-1; i++) {
        min = i;
        for(j=i+1; j<n; j++) {
            if(burst_time[j] < burst_time[min])
                min = j;
        }
        temp = burst_time[i];
        burst_time[i] = burst_time[min];
        burst_time[min] = temp;
    }

    waiting_time[0] = 0;
    for(i=1; i<n; i++) {
        waiting_time[i] = burst_time[i-1] + waiting_time[i-1];
    }

    for(i=0; i<n; i++) {
        turnaround_time[i] = burst_time[i] + waiting_time[i];
        total_wt += waiting_time[i];
        total_tat += turnaround_time[i];
    }

    printf("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time\n");
    for(i=0; i<n; i++) {
        printf("%d\t%d\t\t%d\t\t%d\n", i+1, burst_time[i], waiting_time[i], turnaround_time[i]);
    }

    printf("\nAverage Waiting Time = %.2f", (float)total_wt/n);
    printf("\nAverage Turnaround Time = %.2f\n", (float)total_tat/n);
    return 0;
}








/*
c) Round Robin Scheduling
*/








#include<stdio.h>

int main() {
    int n, i, time_quantum, count = 0, t = 0, remaining;
    int arrival_time[10], burst_time[10], remaining_time[10], waiting_time[10], turnaround_time[10];

    printf("Enter number of processes: ");
    scanf("%d", &n);
    remaining = n;

    printf("Enter Arrival Time and Burst Time for each process:\n");
    for(i=0; i<n; i++) {
        printf("Process %d - Arrival Time: ", i+1);
        scanf("%d", &arrival_time[i]);
        printf("Process %d - Burst Time: ", i+1);
        scanf("%d", &burst_time[i]);
        remaining_time[i] = burst_time[i];
    }

    printf("Enter Time Quantum: ");
    scanf("%d", &time_quantum);

    printf("\nProcess\tBurst Time\tTurnaround Time\tWaiting Time\n");
    while(remaining != 0) {
        for(i=0; i<n; i++) {
            if(remaining_time[i] > 0) {
                if(remaining_time[i] <= time_quantum) {
                    t += remaining_time[i];
                    turnaround_time[i] = t - arrival_time[i];
                    waiting_time[i] = turnaround_time[i] - burst_time[i];
                    remaining_time[i] = 0;
                    remaining--;
                    printf("%d\t%d\t\t%d\t\t%d\n", i+1, burst_time[i], turnaround_time[i], waiting_time[i]);
                } else {
                    t += time_quantum;
                    remaining_time[i] -= time_quantum;
                }
            }
        }
    }
    return 0;
}
