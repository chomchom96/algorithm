import sys, math

n, m = map(int, sys.stdin.readline().split())
DP = [[0] * 21 for _ in range(21)]

DP[1][1] = 1

for i in range(2, n + 1):
    for j in range(1, i + 1):
        DP[i][j] = DP[i - 1][j - 1] + (i - 1) * DP[i - 1][j]

bomb = 0
for i in range(1, m + 1):
    bomb += DP[n][i]

total = 1
for i in range(1, n + 1):
    total *= i

print('%d/%d' % (bomb // math.gcd(bomb, total), total // math.gcd(bomb, total)))