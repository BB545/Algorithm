import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] numbers = new int[cnt];
        
        for (int i = 0; i < cnt; i++) {
            numbers[i] = sc.nextInt();
        };
        
        Arrays.sort(numbers);
        
        System.out.println(numbers[0] * numbers[cnt - 1]);
    }
}