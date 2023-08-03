from collections import deque

n, m = map(int, input().split())

graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

sx, sy = 0, 0

for i in range(n):
    for j in range(m):
        if graph[i][j] == 2:
            sx, sy = i, j

graph[sx][sy] = 0

visited = [[False for _ in range(m)] for _ in range(n)]

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y):
    queue = deque([(x, y)])
    visited[x][y] = True

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny]:
                if graph[nx][ny] == 0:
                    continue
                
                visited[nx][ny] = True
                
                graph[nx][ny] = graph[x][y] + 1
                queue.append((nx, ny))

bfs(sx, sy)

for i in range(n):
    for j in range(m):
        if not visited[i][j] and graph[i][j] != 0:
            print(-1, end = ' ')
        else:
            print(graph[i][j], end = ' ')
    print()