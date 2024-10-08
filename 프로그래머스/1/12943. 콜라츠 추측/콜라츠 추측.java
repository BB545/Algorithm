class Solution {
    public long solution(long num) {
        long answer = 0;
        while(num != 1) {
            num = (num % 2 == 0) ? (
                num = num / 2
            ) : (
                num = num * 3 + 1
            );
            answer += 1;
            
            if (answer >= 500) {
                answer = -1;
                break;
            }
        }
        return answer;
    }
}