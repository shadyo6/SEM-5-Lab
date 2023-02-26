//please make some legit changes and dont get caught if two or more programs are same
import java.io.*;
import java.util.*;
public class First{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int flag = 1;
        while(flag == 1){
            System.out.println("1. print characters on console - ");
            System.out.println("2: print the entire file: ");
            System.out.println("3: print contents to another file: ");
            System.out.println("Choice: ");
            int c = s.nextInt();
            switch(c){
                case 1: System.out.println("print characters on the console");
                        try{
                            FileInputStream fip = new FileInputStream("input.txt");
                            int ch = fip.read();
                            //System.out.println(ch);
                            while(ch != -1){
                                System.out.println((char)ch);
                                ch = fip.read();
                            }
                            fip.close();
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        break;
                case 2: System.out.println("print the entire file");
                        try{
                            FileInputStream fip = new FileInputStream("input.txt");
                            int ch = fip.read();
                            //System.out.println(ch);
                            while(ch != -1){
                                System.out.print((char)ch);
                                ch = fip.read();
                            }
                            fip.close();
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        break;
                case 3: System.out.println("print contents onto other file");
                        try{
                            FileInputStream fip = new FileInputStream("input.txt");
                            FileOutputStream fop = new FileOutputStream("output.txt");
                            byte[] buf = new byte[100];
                            fip.read(buf);
                            fop.write(buf);
                            System.out.println("copied to another file: output.txt");
                            fip.close(); 
                            fop.close();
                        }
                        catch(Exception e){
                            System.out.println(e);
                        }
                        break;
            }
            System.out.println("do you wish to continue?(1/0)");
            flag=s.nextInt();
        }
        s.close();
    }
}   