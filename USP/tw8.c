#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
int main(){
	int pid;
	pid = fork();
	if(pid == 0){
	//first child
		pid = fork();
		if(pid == 0){
			//second child
			sleep(1);
			printf("Second Child: My Parent pid is %d\n",getppid());
		}
	
	}
	else{
		//parent process
		wait(NULL);
		sleep(2);
		system("ps -o pid,ppid,state,tty,command");
	}
	return 0;		
}
