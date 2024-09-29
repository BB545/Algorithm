function solution(a, b) {
    var answer = a.reduce((sum, _, i) => sum + a[i] * b[i], 0);

    return answer;
}