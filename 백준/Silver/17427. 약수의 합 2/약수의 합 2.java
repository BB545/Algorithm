import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        long[] f = new long[N + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j += i) {
                f[j] += i;
            }
        }
        
        long g = 0;
        for (int i = 1; i <= N; i++) {
            g += f[i];
        }
        
        System.out.println(g);
    }
}