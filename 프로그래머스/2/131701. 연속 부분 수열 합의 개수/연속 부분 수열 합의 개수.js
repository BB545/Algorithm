function solution(elements) {
    var answer = 0;
    var sumSet = new Set();
    
    for (let i = 1; i <= elements.length; i++) {
        for (let j = 0; j < elements.length; j++) {
            let sum = 0;
            
            for (let k = j; k < j + i; k++) {
                sum += elements[k%elements.length];
            }
            
            sumSet.add(sum);
        }
    }
    
    answer = sumSet.size;
    return answer;
}