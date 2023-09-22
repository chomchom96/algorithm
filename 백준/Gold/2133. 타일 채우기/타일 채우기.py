n = int(input())

if (n % 2 == 1): 
   print(0)
   exit()

dp=[0] * (n//2 + 1)
dp[1] = 3
for i in range(2, n//2 + 1): 
  dp[i] = dp[i-1] * 3
  for j in range(2 , i):
    dp[i] += dp[i-j]*2
  dp[i] += 2
print(dp[n//2])