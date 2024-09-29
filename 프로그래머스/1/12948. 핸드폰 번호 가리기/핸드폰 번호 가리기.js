function solution(phone_number) {
    var answer = [];
    const phone = phone_number.split("");
    for (let i = 0; i < phone.length; i++) {
        if (i + 3 === phone.length - 1) {
            answer.push(phone[i]);
            answer.push(phone[i + 1]);
            answer.push(phone[i + 2]);
            answer.push(phone[i + 3]);
            break;
        } else {
            answer.push('*');
        }
    }
    return answer.join('');
}