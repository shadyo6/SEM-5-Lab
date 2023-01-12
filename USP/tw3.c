#include<stdio.h>

#include<sys/types.h>

#include<fcntl.h>

#include<unistd.h>


int main(int argc, char *argv[])
{

	char temp[1000];

	setbuff(stdout,temp);

	struct flock fvar;

	int fdesc;

	char buf;

	int rc;

	off_t offset;

	pid_t pid=fork();

	fdesc=open(argv[1],O_RDWR);

	fvar.l_type=F_WRLCK;

	fvar.l_whence=SEEK_END;

	fvar.l_start=-100;

	fvar.l_len=100;
	if(fcntl(fdesc,F_SETLK,&fvar)==-1)
{

		printf("\n..........................\n");

		printf("Unable to getlock as file has been locked by: \n");

		while(fcntl(fdesc,F_GETLK,&fvar)!=-1&&fvar.l_type!=F_UNLCK)

		{

			printf("\n File: %s is locked by the process with pid: %u",argv[1],fvar.l_pid);

			printf("From %ld the byte in the file for %ld", fvar.l_start,fvar.l_len);

			printf("Number of bytes , for %s\n\n",(fvar.l_type==F_WRCLK ? "write":"read"));

			if(!fvar.l_len)break;

			fvar.l_start+=fvar.l_len;

			fvar.l_len=0;

		}

	}
	
	else{

		printf("\n...........................\n");

		printf("\n\n File: %s was not locked and aquiring of Exclusive lock was",argv[1]));

		printf("Successful by process ID: %u \n",getpid());

		offset=lseek(fdesc,-50,SEEK_END);

		printf("\n\n Last 50 bytes of the file: %s\n",argv[1]);

		while((rc=read(fdesc,&buf,1))>0)

			printf("%c",buff);

		fvar.l_type=F_UNLCK;

		fvar.l_whence=SEEK_END;

		fvar.l_start=-100;

		fvar.l_len=100;

		if(fcntl(fdesc,F_SETLKW,&fvar)!=-1)

			printf("\n File unclocked successfully\n\n");

	}

	return 0;

}




