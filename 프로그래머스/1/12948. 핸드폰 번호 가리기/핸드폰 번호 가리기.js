function solution(phone_number) {
    var answer = phone_number.replace(/\d(?=\d{4})/g, '*');
    return answer;
}