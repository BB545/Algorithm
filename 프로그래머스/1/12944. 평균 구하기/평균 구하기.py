def solution(arr):
    answer = 0
    sum=0
    l=len(arr)
    for i in range(0, l):
        sum=sum+arr[i]
        answer=sum/l
    return answer