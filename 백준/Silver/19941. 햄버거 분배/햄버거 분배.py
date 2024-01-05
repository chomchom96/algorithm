N, K = map(int, input().split())
li = list(input())
ans = 0

for i in range(N):
    if li[i] == 'P':
        for j in range(max(i-K, 0), min(i+K+1, N)):
            if li[j] == 'H':
                li[j] = 0
                ans += 1
                break

print(ans)