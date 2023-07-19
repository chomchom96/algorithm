import sys
input = sys.stdin.readline


n = int(input())
stair = [int(input()) for _ in range(n)]
DP = [0]*n

if n <= 2:
    print(sum(stair))

else:
    DP[0] = stair[0]
    DP[1] = stair[0] + stair[1]
    for i in range(2,n):
        DP[i]=max(DP[i-3]+stair[i-1]+stair[i], DP[i-2]+stair[i])
    print(DP[-1])