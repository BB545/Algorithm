def solution(n):
    for x in range(1,n+1):
        if n==x*x:
            return (x+1)*(x+1)
    return -1