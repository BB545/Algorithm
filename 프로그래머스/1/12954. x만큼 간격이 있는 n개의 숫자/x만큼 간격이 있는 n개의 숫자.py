def solution(x, n):
    answer = []
    l=0
    for i in range(0, n):
        l=l+x
        answer.append(l)
    return answer