//please make some legit changes and dont get caught if two or more programs are same
import java.util.ArrayList;
import java.util.Scanner;
public class Fourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the integer array: ");
        int intLength = sc.nextInt();

        System.out.print("Enter the length of the float array: ");
        int floatLength = sc.nextInt();

        ArrayList<Integer> intList = new ArrayList<Integer>(intLength);
        ArrayList<Float> floatList = new ArrayList<Float>(floatLength);
        int option;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add an element to the integer array");
            System.out.println("2. Add an element to the float array");
            System.out.println("3. Linear search on the integer array");
            System.out.println("4. Linear search on the float array");
            System.out.println("5. Display the integer array");
            System.out.println("6. Display the float array");
            System.out.println("7. Exit");
            System.out.print("Enter your option: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter the integer value to be added: ");
                    int intValue = sc.nextInt();
                    addElement(intList, intValue);
                    break;

                case 2:
                    System.out.print("Enter the float value to be added: ");
                    float floatValue = sc.nextFloat();
                    addElement(floatList, floatValue);
                    break;

                case 3:
                    System.out.print("Enter the integer value to be searched: ");
                    int intKey = sc.nextInt();
                    int intIndexFound = linearSearch(intList, intKey);
                    if (intIndexFound == -1) {
                        System.out.println("The integer value " + intKey + " was not found in the array.");
                    } else {
                        System.out.println("The integer value " + intKey + " was found at index " + intIndexFound);
                    }
                    break;

                case 4:
                    System.out.print("Enter the float value to be searched: ");
                    float floatKey = sc.nextFloat();
                    int floatIndexFound = linearSearch(floatList, floatKey);
                    if (floatIndexFound == -1) {
                        System.out.println("The float value " + floatKey + " was not found in the array.");
                    } else {
                        System.out.println("The float value " + floatKey + " was found at index " + floatIndexFound);
                    }
                    break;

                case 5:
                    System.out.println("The integer array is:");
                    displayArray(intList);
                    break;

                case 6:
                    System.out.println("The float array is:");
                    displayArray(floatList);
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        } while (option != 7);
    }

    // Overloaded method to add an element to an ArrayList of integers
    public static void addElement(ArrayList<Integer> arr, int value) {
        arr.add(value);
    }
    // Overloaded method to add an element to an ArrayList of floats
    public static void addElement(ArrayList<Float> arr, float value) {
        arr.add(value);
    }

    // Overloaded method to perform linear search on an ArrayList of integers
    public static int linearSearch(ArrayList<Integer> arr, int key) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == key) {
                return i;
            }
        }
        return -1;
    }
    // Overloaded method to perform linear search on an ArrayList of floats
    public static int linearSearch(ArrayList<Float> arr, float key) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == key) {
                return i;
            }
        }
        return -1;
    }

    // Method to display an ArrayList of integers or floats
    public static <T> void displayArray(ArrayList<T> arr) {
        for (T element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}