n = int(input())
graph = []

for _ in range(n):
    graph.append(list(map(int, input().split())))

dp = [[[0] * n for _ in range(n)] for _ in range(3)]

dp[0][0][1] = 1

for i in range(2, n):
    if graph[0][i] == 0:
        dp[0][0][i] = dp[0][0][i-1]

# 가로, 세로, 대각선
for y in range(1, n):
    for x in range(1, n):
        if graph[y][x] == 0 and graph[y][x-1] == 0 and graph[y-1][x] == 0:
            dp[2][y][x] = dp[0][y-1][x-1] + dp[1][y-1][x-1] + dp[2][y-1][x-1]

        if graph[y][x] == 0:
            dp[0][y][x] = dp[0][y][x-1] + dp[2][y][x-1]
            dp[1][y][x] = dp[1][y-1][x] + dp[2][y-1][x]

print(sum(dp[i][n - 1][n - 1] for i in range(3)))