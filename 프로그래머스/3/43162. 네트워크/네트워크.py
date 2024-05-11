def solution(n, computers):
    answer = 0
    visited = [False]*n
    
    def dfs(pc):
        visited[pc] = True
        for idx in range(n):
            if not visited[idx] and computers[pc][idx] == 1:
                dfs(idx)
    for node in range(n):
        if not visited[node]:
            dfs(node)
            answer += 1
    return answer