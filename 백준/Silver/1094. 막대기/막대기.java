import java.util.*;

public class Main {
    static int X;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();
        
        int stick = 64;
        int cnt = 0;
        
        while (stick > 0) {
            if (stick > X) {
                stick /= 2;
            } else {
                cnt++;
                X -= stick;
            }
        }
        
        System.out.println(cnt);
    }
}