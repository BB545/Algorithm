function solution(s){
    var answer = true;
    let S = s.toUpperCase().split("");
    let p = 0;
    let y = 0;
    
    for (const i of S) {
        if (i === 'P') p++;
        if (i === 'Y') y++;
    }
    
    if (p !== y) answer = false;

    return answer;
}