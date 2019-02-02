#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#include <string.h>
#include <pthread.h> 
#include <unistd.h>
int numThreads; 

void createPhilosophers(int nThreads); 
void *philosopherThread(void *pVoid); 
void think(); 
void getChopsticks(int threadIndex); 
void dropChopsticks(int threadIndex); 
void eat();

pthread_mutex_t* mutexes; 
int forks; 
int main(int argc, char *argv[])
{
	if(argc!= 2)
	{
		printf("how many phils do you want\n"); 
		exit(-1); 
	}
	int nThreads = atointi(argv[1]); 
	numThreads = nThreads; 
	int mutexLocks[nThreads];

	int i =0 ; 
	mutexes = malloc(sizeof(pthread_mutex_t) * nThreads); 
	for(i = 0; i< nThreads; i++)
	{
		pthread_mutex_init(&mutexes[i], NULL); 
	}
	createPhilosophers(nThreads); 
}

