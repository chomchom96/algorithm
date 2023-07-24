test_case = int(input())
DP = [1,2,4,7] + [0] * 11
for i in range(4, 12):
    DP[i] = DP[i-1] + DP[i-2] + DP[i-3]

for _ in range(test_case):
    n = int(input())
    print(DP[n-1])