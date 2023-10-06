n = int(input())
li = list(map(int ,input().split()))
li.sort()

sum = 0
ans = 1

for i in range(n):
    sum += li[i]
    if sum < i * (i + 1) // 2: ans = -1
if sum != n * (n - 1) // 2 : ans = -1
print(ans)