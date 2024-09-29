function solution(numbers) {
    var answer = 0;
    answer = 45 - numbers.reduce((a, b) => a+b, 0);
    return answer;
}