//please for god's sake, cancel out the comments, edit the input.txt file and delete contents from output.txt file if you get this program
// and also change the menu options
import java.io.*;
public class Third {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String sourceFile = null;
            String destFile = null;
            String text = null;
            int choice;
            do {
                System.out.println("Select an option:");
                System.out.println("1. Read the source and destination file names");
                System.out.println("2. Read user-defined text to be written to the source file");
                System.out.println("3. Write every alternate byte from the source to the destination file");
                System.out.println("4. Compare the properties of the file");
                System.out.println("5. Exit");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter the source file name:");
                        sourceFile = reader.readLine(); //specify input file as ./input.bin creating a folder containing all the files in one place
                        System.out.println("Enter the destination file name:");
                        destFile = reader.readLine(); //specify output file as ./output.bin creating a folder containing all the files in one place
                        break;
                    case 2:
                        System.out.println("Enter the text to be written to the source file:");
                        text = reader.readLine();
                        break;
                    case 3:
                        writeAlternateBytes(sourceFile, destFile);
                        break;
                    case 4:
                        compareProperties(sourceFile, destFile);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } while (choice != 5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeAlternateBytes(String sourceFile, String destFile) {
        try {
            FileInputStream inputStream = new FileInputStream(sourceFile);
            FileOutputStream outputStream = new FileOutputStream(destFile);
            int b;
            int count = 0;
            while ((b = inputStream.read()) != -1) {
                if (count % 2 == 0) {
                    outputStream.write(b);
                }
                count++;
            }
            System.out.println("Every alternate byte has been written to the destination file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void compareProperties(String sourceFile, String destFile) {
        try {
            File file1 = new File(sourceFile);
            File file2 = new File(destFile);
            System.out.println("Properties of " + sourceFile + ":");
            System.out.println("Name: " + file1.getName());
            System.out.println("Path: " + file1.getAbsolutePath());
            System.out.println("Size: " + file1.length() + " bytes");
            System.out.println("Properties of " + destFile + ":");
            System.out.println("Name: " + file2.getName());
            System.out.println("Path: " + file2.getAbsolutePath());
            System.out.println("Size: " + file2.length() + " bytes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}