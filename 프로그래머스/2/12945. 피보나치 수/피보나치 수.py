def solution(n):
    F=[]
    a,b=0,1
    for i in range(n+1):
        F.append(a)
        a,b=b,a+b
    print(F[i]%1234567)
    return F[i]%1234567