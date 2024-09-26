function solution(arr) {
    var answer = 0;
    for (const i in arr) {
        answer += arr[i];
    }
    answer = answer / arr.length;
    return answer;
}