def solution(sizes):
    max_w = 0
    max_h = 0
    
    for size in sizes:
        size.sort()
        for i in range(len(size)):
            if max_w < size[0]:
                max_w = size[0]
            if max_h < size[1]:
                max_h = size[1]
        answer = max_w * max_h
    return answer