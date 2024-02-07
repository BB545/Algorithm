def solution(n):
    answer = 0
    N=str(n)
    l=len(N)
    for i in range(0,l):
        answer=answer+int(N[i])
    return answer