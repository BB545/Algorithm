function solution(n)
{
    var answer = 0;
// n + "" -> 문자열 변환
    while(n != 0) {
        answer += (n % 10);
        n = parseInt(n / 10);
    }

    return answer;
}