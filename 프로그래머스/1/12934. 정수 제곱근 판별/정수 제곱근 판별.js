function solution(n) {
    var answer = -1;
    answer = Math.sqrt(n)%1 === 0 ? (Math.sqrt(n)+1) * (Math.sqrt(n)+1) : -1;
    return answer;
}