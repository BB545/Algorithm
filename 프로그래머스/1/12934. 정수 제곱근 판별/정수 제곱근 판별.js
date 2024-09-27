function solution(n) {
    var answer = -1;
    for (let x = 1; x <= Math.sqrt(n); x++) {
        if (x * x === n) {
            answer = (x + 1) * (x + 1);
            break;
        }
    }
    return answer;
}