n=int(input())
dp=[1, 2]
if (n!=1):
    for i in range(n-2):
        temp = dp[1]
        dp[1] = (dp[0] + temp) % 15746
        dp[0] = temp
    print(dp[1])
else:
    print(1)