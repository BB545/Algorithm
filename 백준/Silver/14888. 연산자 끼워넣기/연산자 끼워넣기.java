import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators = new int[4]; // + - * /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);  // index 1부터 시작, 첫 값은 numbers[0]
        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int index, int current) {
        if (index == N) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--; // 연산자 사용

                int next = 0;
                switch (i) {
                    case 0: next = current + numbers[index]; break;
                    case 1: next = current - numbers[index]; break;
                    case 2: next = current * numbers[index]; break;
                    case 3: // 나눗셈 처리 (C++14 기준)
                        if (current < 0) {
                            next = - (Math.abs(current) / numbers[index]);
                        } else {
                            next = current / numbers[index];
                        }
                        break;
                }

                dfs(index + 1, next);
                operators[i]++; // 연산자 복원 (백트래킹)
            }
        }
    }
}