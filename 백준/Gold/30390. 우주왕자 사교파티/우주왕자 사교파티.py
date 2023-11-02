import sys, math
input = sys.stdin.readline

a, b, k = map(int, input().split())

range_ = a + b

if (min(a,b) <= k):
    print(range_)
    exit(0)

ans = 0
for i in range(1, int(math.sqrt(range_)) + 1):
    if range_ % i == 0:
        if (a % i <= k or a % i >= i - k) and (b % i <= k or b % i >= i - k):
            ans = max(ans, i)
    i = range_ // i
    if range_ % i == 0:
        if (a % i <= k or a % i >= i - k) and (b % i <= k or b % i >= i - k):
            ans = max(ans, i)
print(ans)