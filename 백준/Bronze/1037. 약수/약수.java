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
        
        if (cnt % 2 == 0) {
            System.out.println(numbers[(cnt/2) - 1] * numbers[(cnt/2)]);
        } else {
            System.out.println(numbers[((cnt - 1)/2)] * numbers[((cnt - 1)/2)]);
        }
    }
}