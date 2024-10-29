class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            if (count(i) % 2 == 0) answer += i;
            else answer -= i;
        }
        return answer;
    }
    
    public static int count(int number) {
        int cnt = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) cnt++;
            else if (number % i == 0) cnt += 2;
        }
        return cnt;
    }
}