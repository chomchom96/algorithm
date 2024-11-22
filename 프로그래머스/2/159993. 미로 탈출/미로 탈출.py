from collections import deque

def bfs(start, end, maps):
    dr = [0, 1, -1, 0]
    dc = [1, 0, 0, -1]
    
    n = len(maps)
    m = len(maps[0])
    visited = [[False] * m for _ in range(n)]
    queue = deque()
    flag = False
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] == start:      
                queue.append((i, j, 0))    
                visited[i][j] = True
                flag = True;
                break 
        if flag: 
            break
                
    while queue:
        r, c, cost = queue.popleft()
        
        if maps[r][c] == end:
            return cost
        
        for i in range(4):
            ny = r + dr[i]
            nx = c + dc[i]
            
            if 0<= ny <n and 0<= nx <m and maps[ny][nx] !='X':
                if not visited[ny][nx]:
                    queue.append((ny, nx, cost+1))
                    visited[ny][nx] = True
                    
    return -1
            
def solution(maps):
    path1 = bfs('S', 'L', maps)
    path2 = bfs('L', 'E', maps)
    
    if path1 != -1 and path2 != -1:
        return path1 + path2
        
    return -1