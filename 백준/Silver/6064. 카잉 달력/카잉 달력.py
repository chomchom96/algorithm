from math import gcd
import sys

T = int(input())

for _ in range(T):
    M, N, x, y = map(int, input().split())
    ans = -1
    while x <= M * N // gcd(M, N):
        if (x - y) % N == 0:
            ans = x
            break
        x += M
    print(ans)