#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
int main(){
	int pid=fork();
	if (pid==0){
		//first child
		pid=fork();//creates second child or grandchild
	if(pid==0){
		//second child
		sleep(1);
		printf("Second child: My Parent PID is %d\n",getppid());
	}
	}
	else{
		//Parent process
		wait(NULL);//will block parent process until any of its children has finished
		sleep(2);
		system("ps -o pid,ppid,state,tty,command");
	}
	return 0;
}
