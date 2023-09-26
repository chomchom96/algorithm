import sys
input = sys.stdin.readline

mod = 1000000007

n = int(input())
li = list(map(int, input().split()))

li.sort()

pow = [1] + [0] * n
for i in range(n):
    pow[i + 1] = pow[i] * 2 % mod

ans = 0

for i in range(n - 1): 
    for j in range(i, n): 
        ans += (li[j] - li[i]) * pow[j - i - 1] % mod
        
print(ans % mod)