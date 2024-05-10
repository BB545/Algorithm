def solution(array, commands):
    answer = []
    for c in range(len(commands)):
        arr = array[commands[c][0]-1:commands[c][1]]
        arr.sort()
        answer.append(arr[commands[c][2]-1])
    return answer