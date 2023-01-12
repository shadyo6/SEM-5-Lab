#define POSIX_SOURCE
#define POSIX_C_SOURCE 199309L

#include<stdlib.h>
#include<stdio.h>
#include<unistd.h>
static void charatatime(char *);
int main(){
	int pid,i;
	for(i=0;i<10;i++){
		if((pid=fork())<0)
			printf("fork error.\n");
		else if(pid==0)
				charatatime("output from child\n");
		else
			charatatime("output from parent\n");
	}
	return 0;
}

static void charatatime(char *str){
	char *ptr;
	int c;
	setbuf(stdout,NULL);
	for(ptr=str;(c=*ptr++)!=0;)
		putc(c,stdout);
}
