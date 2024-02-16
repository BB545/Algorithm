def solution(A,B):
    A=sorted(A)
    B=sorted(B)
    B=B[::-1]
    sum=0
    for i in range(0,len(A)):
        sum=sum+A[i]*B[i]
    print(sum)
    return sum