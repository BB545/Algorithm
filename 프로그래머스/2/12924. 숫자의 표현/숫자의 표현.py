def solution(n):
    answer = 1
    for i in range(1, n//2+1):
        total=0
        while total < n:
            total=total+i
            i=i+1
        if total==n:
            answer=answer+1
    return answer