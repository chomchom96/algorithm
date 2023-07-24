n = int(input())
DP = []
for i in range(n):
  DP.append(list(map(int, input().split())))

for i in range(1, n):
  for j in range(len(DP[i])):
    if j == 0:
      DP[i][j] = DP[i][j] + DP[i-1][j]
    elif j == (len(DP[i])-1): 
      DP[i][j] = DP[i][j] + DP[i-1][j-1]
    else:
      DP[i][j] = max(DP[i-1][j-1], DP[i-1][j]) + DP[i][j]

print(max(DP[n-1]))