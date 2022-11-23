#define _POSIX_C_SOURCE 199309L
#include<iostream>
#include<unistd.h>
#include<limits.h>
using namespace std;
int main(){
	int choice,res=0;
	while(1){
		cout<<"1. Compile Time Values\n2. Run Time Values\n3.Exit\nEnter your choice:";
		cin>>choice;
		switch(choice){
		case 1: cout<<"Compile Time Values.\n";
			#ifdef _POSIX_CLK_TCK
				cout<<"No. of Clock Ticks per second is: "<<_POSIX_CLK_TCK<<endl;
			#else
				cout<<"_POSIX_CLK_TCK not defined\n";
			#endif
			#ifdef _POSIX_CHILD_MAX
				cout<<"Max number of child processes at any time is: "<<_POSIX_CHILD_MAX<<endl;
			#else
				cout<<"_POSIX_CHILD_MAX not defined\n";
			#endif
			#ifdef _POSIX_PATH_MAX
				cout<<"Max path name is: "<<_POSIX_PATH_MAX<<endl;
			#else 
				cout<<"_POSIX_PATH_MAX not defined\n";
			#endif
			#ifdef _POSIX_NAME_MAX
				cout<<"Max no. of characters in file name: "<<_POSIX_NAME_MAX<<endl;
			#else
				cout<<"_POSIX_NAME_MAX not defined\n";
			#endif
			#ifdef _POSIX_OPEN_MAX
				cout<<"Max no. of files simultaneously opened is: "<<_POSIX_OPEN_MAX<<endl;
			#else
				cout<<"_POSIX_OPEN_MAX not defined\n";
			#endif
			break;
		case 2: cout<<"Run Time Values.\n";
			if((res=sysconf(_SC_CLK_TCK))==-1)
				perror("sysconf");
			else
				cout<<"No. of Clock Ticks per second is: "<<res<<endl;
			if((res=sysconf(_SC_CHILD_MAX))==-1)
				perror("sysconf");
			else
				cout<<"Max number of child processes at any time is: "<<res<<endl;
			if((res=pathconf("/",_PC_PATH_MAX))==-1)
				perror("pathconf");
			else
				cout<<"Max path name is: "<<res<<endl;
			if((res=pathconf("/",_PC_NAME_MAX))==-1)
				perror("pathconf");
			else
				cout<<"Max no. of characters in file name: "<<res<<endl;
			if((res=sysconf(_SC_OPEN_MAX))==-1)
				perror("sysconf");
			else
				cout<<"Max no. of files simultaneously opened is:"<<res<<endl;
			break;
		case 3: exit(0);
		default : cout<<"Invalid Choice.\n";
		}
	}
	return 0;
}
