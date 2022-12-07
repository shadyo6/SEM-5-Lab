#include<stdio.h>
#include<unistd.h>
#include<sys/stat.h>
#include<fcntl.h>
#include<string.h>
#define FIFO11 "fifo11"
#define FIFO22 "fifo22"
#define PERMS 0666
char fname[256];

int main(){
int readfd,writefd,fd;
ssize_t n;
char buff[512];
if(mkfifo(FIFO11,PERMS)<0)
printf("Can't create FIFO files\n");
if(mkfifo(FIFO22,PERMS)<0)
printf("Can't create FIFO files\n");
printf("Waiting for connection request........\n");
readfd = open(FIFO11, O_RDONLY,0);
writefd = open(FIFO22, O_WRONLY,0);
printf("Connection established...\n");
read(readfd,fname,255);
printf("Client has requested file %s\n", fname);
if((fd= open(fname,O_RDWR))<0){
strcpy(buff,"File does not exist!\n");
write(writefd,buff,strlen(buff));
}
else{
while(n=read(fd,buff,512)>0)
write(writefd,buff,n);
}
close(readfd); unlink(FIFO11);
close(writefd); unlink(FIFO22);

}
