//b) Write a C / C++ program to emulate the unix ln command
//Source Code:
#include<stdio.h>
#include<unistd.h>
int main(int argc,char *argv[]){
	if(argc!=3){
		printf("Usage: %s <src_file><dest_file>\n",argv[0]);
		return 0;
	}
	if(link(argv[1],argv[2])==-1){
		printf("Link Error\n");
		return 1;
	}
	else
		printf("Hard link created successfully.\n"); //link success
	return 0;
}
