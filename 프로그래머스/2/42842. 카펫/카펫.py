def solution(brown, yellow):
    width = brown + yellow
    for height in range(1,width+1):
        if width%height==0:
            length = width/height
        if (height-2)*(length-2)==yellow:
            print([int(length), height])
            return [int(length), height]