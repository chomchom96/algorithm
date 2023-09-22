n, m = map(int, input().split())
li = list(map(int, input().split()))
cnt = [0] * m

cnt[li[0] % m] += 1
for i in range(1, n):
    li[i] = (li[i] % m + li[i-1]) % m
    cnt[li[i]]+=1

ans = cnt[0] * (cnt[0] + 1) // 2

for i in range(1, m):
    ans += cnt[i] * (cnt[i] - 1) // 2

print(ans)