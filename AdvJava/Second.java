//please for god's sake, cancel out the comments, edit the input.txt file and delete contents from output.txt file if you get this program
// and also change the menu options
import java.io.*;

public class Second {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the destination file name:");
            String destFile = reader.readLine(); //specify output file as ./output.txt creating a folder containing all the files in one place
            int choice;
            do {
                System.out.println("Select an option:");
                System.out.println("1. Transfer contents using ByteArrayInputStream");
                System.out.println("2. Transfer contents using ByteArrayOutputStream");
                System.out.println("3. Display contents of destination file");
                System.out.println("4. Exit");
                choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        transferWithByteArrayInputStream(destFile);
                        break;
                    case 2:
                        transferWithByteArrayOutputStream(destFile);
                        break;
                    case 3:
                        displayDestinationFile(destFile);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } while (choice != 4);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transferWithByteArrayInputStream(String destFile) {
        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] data = outputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("Transfer successful using ByteArrayInputStream.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void transferWithByteArrayOutputStream(String destFile) {
        try {
            FileInputStream inputStream = new FileInputStream("input.txt");
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            byte[] data = outputStream.toByteArray();
            FileOutputStream fileOutputStream = new FileOutputStream(destFile);
            fileOutputStream.write(data);
            System.out.println("Transfer successful using ByteArrayOutputStream.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayDestinationFile(String destFile) {
        try {
            FileInputStream inputStream = new FileInputStream(destFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            System.out.println("Contents of destination file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}