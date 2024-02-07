def solution(n):
    answer = []
    N=str(n)
    N=N[::-1]
    for i in range(0,len(N)):
        answer.append(int(N[i]))
    return answer