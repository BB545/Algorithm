import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        };
        
        if (prevPermutation(arr)) {
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            };
        } else {
            System.out.println(-1);
        };
        
        sc.close();
    }
    
    public static boolean prevPermutation(int[] arr) {
        int i = arr.length - 1;
        
        while (i > 0 && arr[i] >= arr[i - 1]) {
            i--;
        };
        
        if (i <= 0) {
            return false;
        };
        
        int j = arr.length - 1;
        while (arr[j] >= arr[i - 1]) {
            j--;
        };
        
        swap(arr, i - 1, j);
        
        reverse(arr, i, arr.length - 1);
        
        return true;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        };
    }
}