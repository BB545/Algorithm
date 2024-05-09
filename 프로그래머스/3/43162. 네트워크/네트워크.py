def solution(n, computers):
    answer = 0
    visited = [False]*n #초기 리스트 : 하나도 방문하지 않은
    def dfs(pc): #활용할 dfs함수 정의
        visited[pc]=True
        for idx in range(n): #인접노드
            if not visited[idx] and computers[pc][idx]: #방문하지 않았고, 인접할때
                dfs(idx) #해당 노드 기준으로 다시 dfs탐색 진행
    for node in range(n):
        if not visited[node]:
            dfs(node)
            answer += 1
    print(visited)
    return answer