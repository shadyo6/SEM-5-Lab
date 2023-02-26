// please make some legit changes and dont get caught if two or more programs are same
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Five {
    public static void main(String[] args) {
        Map<String, String> credentials = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add a key-value pair");
            System.out.println("2. Retrieve the value for a given key");
            System.out.println("3. Retrieve all the keys");
            System.out.println("4. Retrieve all the values");
            System.out.println("5. Retrieve all the key-value pairs");
            System.out.println("6. Change the value associated with a key");
            System.out.println("7. Remove an element given the key");
            System.out.println("8. Remove an entry with Key and Value");
            System.out.println("9. Check if a given value exists in the HashMap");
            System.out.println("10. Display the HashMap");
            System.out.println("0. Exit");

            System.out.print("Choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the key: ");
                    String key = scanner.nextLine();
                    System.out.print("Enter the value: ");
                    String value = scanner.nextLine();
                    if (credentials.containsKey(key)) {
                        System.out.println("Error: Key already exists.");
                    } else {
                        credentials.put(key, value);
                        System.out.println("Key-value pair added successfully.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the key: ");
                    key = scanner.nextLine();
                    if (credentials.containsKey(key)) {
                        System.out.println("Value: " + credentials.get(key));
                    } else {
                        System.out.println("Error: Key not found.");
                    }
                    break;
                case 3:
                    System.out.println("Keys: " + credentials.keySet());
                    break;
                case 4:
                    System.out.println("Values: " + credentials.values());
                    break;
                case 5:
                    System.out.println("Key-value pairs: " + credentials);
                    break;
                case 6:
                    System.out.print("Enter the key: ");
                    key = scanner.nextLine();
                    if (credentials.containsKey(key)) {
                        System.out.print("Enter the new value: ");
                        value = scanner.nextLine();
                        credentials.put(key, value);
                        System.out.println("Value updated successfully.");
                    } else {
                        System.out.println("Error: Key not found.");
                    }
                    break;
                case 7:
                    System.out.print("Enter the key: ");
                    key = scanner.nextLine();
                    if (credentials.containsKey(key)) {
                        credentials.remove(key);
                        System.out.println("Key-value pair removed successfully.");
                    } else {
                        System.out.println("Error: Key not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter the key: ");
                    key = scanner.nextLine();
                    System.out.print("Enter the value: ");
                    value = scanner.nextLine();
                    if (credentials.containsKey(key) && credentials.get(key).equals(value)) {
                        credentials.remove(key);
                        System.out.println("Key-value pair removed successfully.");
                    } else {
                        System.out.println("Error: Key-value pair not found.");
                    }
                    break;
                case 9:
                    System.out.print("Enter the value: ");
                    value = scanner.nextLine();
                    if (credentials.containsValue(value)) {
                        System.out.println("Value exists in the HashMap.");
                    } else {
                        System.out.println("Error: Value not found.");
                    }
                    break;
                case 10:
                    System.out.println("HashMap: " + credentials);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }
}