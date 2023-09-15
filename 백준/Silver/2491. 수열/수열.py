n = int(input())
li = list(map(int, input().split()))

dp1 = [1]
dp2 = [1]

for i in range(1, n):
    if (li[i] >= li[i - 1]):   #증가 수열이면
        dp1.append(dp1[-1] + 1)
    else:
        dp1.append(1)
    
    if (li[i] <= li[i - 1]):   #감소 수열이면
        dp2.append(dp2[-1] + 1)
    else:
        dp2.append(1)

print(max(max(dp1), max(dp2)))