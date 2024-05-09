def solution(sizes):
    max_w = 0
    max_h = 0

    for size in sizes:
        size.sort()
        w, h = size
        max_w = max(max_w, w)
        max_h = max(max_h, h)
    answer = max_w * max_h
    return answer