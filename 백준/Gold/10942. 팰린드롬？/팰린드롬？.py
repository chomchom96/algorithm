import sys
input = sys.stdin.readline

n = int(input())
li = list(map(int, input().split()))
m = int(input())

dp = [[0] * n for _ in range(n)]

for i in range(n):
    for p in range(n - i):
        q = p + i
        if i == 0:
            dp[p][q] = 1
        elif li[p] == li[q]:
            if i == 1: 
                dp[p][q] = 1
            elif dp[p+1][q-1] == 1: dp[p][q] = 1
            
for _ in range(m):
    n, m = map(int, input().split())
    print(dp[n-1][m-1])