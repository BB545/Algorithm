import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int len = 1;
            int number = 1 % n;

            while (number != 0) {
                len++;
                number = (number * 10 + 1) % n;
            }

            System.out.println(len);
        }
        sc.close();
    }
}
