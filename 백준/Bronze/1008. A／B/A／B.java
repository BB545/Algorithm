import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Double A = sc.nextDouble();
        Double B = sc.nextDouble();
        
        System.out.printf("%.9f", A/B);
        sc.close();
    }
}