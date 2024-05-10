from itertools import permutations #순열

def prime(x):
    if x < 2:
        return False
    for i in range(2,x):
        if x % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    allNums = set()
    li = list(numbers)
    for i in range(1, len(numbers)+1):
        permLi = permutations(li, i)
        for perm in permLi:
            num = int(''.join(perm))
            allNums.add(num)

    for num in allNums:
        if prime(num):
            answer += 1
    return answer