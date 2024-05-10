from itertools import permutations

def solution(k, dungeons):
    answer = 0
    dun = len(dungeons)
    for perm in permutations(dungeons, dun):
        cnt = 0
        hp = k #각 순열마다 k초기화
        
        for pm in perm:
            if hp >= pm[0]:
                hp -= pm[1]
                cnt += 1
            if cnt > answer:
                answer = cnt
                
    return answer