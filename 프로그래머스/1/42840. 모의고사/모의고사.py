def solution(answers):
    answer = []
    a1 = [1,2,3,4,5]
    a2 = [2,1,2,3,2,4,2,5]
    a3 = [3,3,1,1,2,2,4,4,5,5]
    cnt1, cnt2, cnt3 = 0, 0, 0
    for i, ans in enumerate(answers):
        if a1[i % len(a1)] == ans:
             cnt1 += 1
        if a2[i % len(a2)] == ans:
            cnt2 += 1
        if a3[i % len(a3)] == ans:
            cnt3 += 1
                    
    max_count = max(cnt1, cnt2, cnt3)
    for i, cnt in enumerate([cnt1, cnt2, cnt3], start=1):
        if cnt == max_count:
            answer.append(i)
    return answer