//a) Write a C/C++ program that outputs the contents of its Environment list
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
int main(int argc,char *argv[]){
	int i;
	char **ptr;extern char **environ;
	for(ptr=environ;*ptr;ptr++)
		printf("%s\n",*ptr);
	exit(0);
}

