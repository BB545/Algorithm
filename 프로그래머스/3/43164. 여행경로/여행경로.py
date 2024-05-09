from collections import deque

def solution(tickets):
    answer = []
    q = deque()
    q.append(("ICN", ["ICN"], []))
    
    while q:
        air, path, visited = q.popleft()
        if len(visited) == len(tickets):
            answer.append(path)
            
        for idx, t in enumerate(tickets):
            if t[0] == air and not idx in visited:
                q.append((t[1], path + [t[1]], visited + [idx]))
        
    answer.sort()
        
    return answer[0]