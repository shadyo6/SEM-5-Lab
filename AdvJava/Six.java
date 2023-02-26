//please make some legit changes and dont get caught if two or more programs are same
import java.util.*;
public class Six extends Thread{
    private int[] nums;
    public Six(int size) {
        nums = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            nums[i] = new Scanner(System.in).nextInt();
        }
    }
    public void sortAscending() {
        Arrays.sort(nums);
        System.out.println("Ascending: " + Arrays.toString(nums));
    }
    public void sortDescending() {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        System.out.println("Descending: " + Arrays.toString(nums));
    }
    public static void main(String[] args) {
        System.out.print("Enter size of array: ");
        int size = new Scanner(System.in).nextInt();
        Six st = new Six(size);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                st.sortAscending();
            }
        });
        thread1.start();
        System.out.println(thread1);
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                st.sortDescending();
            }
        });
        thread2.start();
        System.out.println(thread2);
    }
}