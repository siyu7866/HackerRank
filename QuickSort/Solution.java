import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] arr = new Integer[n];
        //int numbers = scanner.nextInt();
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        quickSort(arr);
    }

    public static ArrayList<Integer> quickSort(Integer[] arr) {
        int tmp = arr[0];
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if(tmp > arr[i]) {
                left.add(arr[i]);
            }
            else if(tmp < arr[i]) {
                right.add(arr[i]);
            } 
            else {
                equal.add(arr[i]);
            }
        }
        if(left.size() > 1) {
            left = quickSort(left.toArray(new Integer[left.size()]));
        }
        if(right.size() > 1) {
            right = quickSort(right.toArray(new Integer[right.size()]));
        }
        left.addAll(equal);
        left.addAll(right);
        printArray(left);
        return left;
    }

    public static void printArray(ArrayList<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i++) {
            sb.append(arr.get(i));
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}