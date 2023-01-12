#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#define PS "ps -eo pid,ppid,state,tty,command"
int main(){
	pid_t child_pid;
	if((child_pid=fork())<0)
		perror("fork error");
	else if (child_pid==0)
		exit(0); //child
	sleep(4); // parent
	system(PS);
	return 0;
}
