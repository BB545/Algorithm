function solution(n) {
    var answer = 0;
    
    var dp = [0, 1, 2];
    
    for (let i = 3; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
    }
    
    answer = dp[n];
    return answer;
}