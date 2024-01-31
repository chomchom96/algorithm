N=int(input())
Honey=list(map(int, input().split()))
prefixSum=[0 for _ in range(N)]
prefixSum[0] = Honey[0]
ans=0

for i in range(1, N):
    prefixSum[i] += Honey[i] + prefixSum[i-1]

for i in range(1, N-1):
    ans = max(ans, 2*prefixSum[-1]-Honey[0]-Honey[i]-prefixSum[i], prefixSum[-1]-Honey[-1]-Honey[i]+prefixSum[i-1], prefixSum[i]-Honey[0] + prefixSum[-1]-prefixSum[i-1]-Honey[-1])

print(ans)