import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();
        
        int[] lengths = new int[K];
        for (int i = 0; i < K; i++) {
            lengths[i] = sc.nextInt();
        }
        
        Arrays.sort(lengths);
        
        long low = 1;
        long high = lengths[lengths.length - 1];
        long maxLength = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;
            
            for (int i = 0; i < K; i++) {
                cnt += lengths[i] / mid;
            }
            
            if (cnt >= N) {
                low = mid + 1;
                maxLength = mid;
            } else {
                high = mid - 1;
            }
        }
        
        System.out.println(maxLength);
    }
}