from collections import deque

n, ans = map(int, input().split())
visited = [0 for i in range(100001)]

def bfs(n):
    queue = deque([n])
    while queue:
        n = queue.popleft()
        if n == ans:
            return visited[n]
        for i in (n - 1, n + 1, 2 * n):
            if 0 <= i <= 100000 and not visited[i]:
                visited[i] = visited[n] + 1
                queue.append(i)
                
print(bfs(n))