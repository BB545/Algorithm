function solution(n) {
    var answer = [];
    let nl = (n + "").split("");
    for (let i = nl.length - 1; i >= 0; i--) {
        answer.push(parseInt(nl[i]));
    }
    return answer;
}