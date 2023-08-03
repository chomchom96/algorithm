dp = [1,1,1,2,2] + [0] * 1000
for i in range(5, 100):
    dp[i] = dp[i-1] + dp[i-5]
n = int(input())
for _ in range(n):
    print(dp[int(input())-1])