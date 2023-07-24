DP = [1,3] + [0] * 1000
for i in range(2, 1001):
    DP[i] = DP[i-1] + DP[i-2] * 2
n = int(input())
print(DP[n-1] % 10007)