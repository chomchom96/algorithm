answer = 0
str1, str2 = input(), input()

dp=[[0] * 4001 for _ in range(4001)]

for i in range(1, len(str1)+1):
    for j in range(1, len(str2)+1):
        if (str1[i-1] == str2[j-1]):
            dp[i][j] = dp[i-1][j-1] + 1
            answer = max(dp[i][j], answer)

print(answer)