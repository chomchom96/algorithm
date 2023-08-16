import math

num =  1000000007

def find_inverse(n, pow):
    if pow == 1: return n
    else:
        if pow % 2 == 1: return ((find_inverse(n, pow//2) % num) ** 2 % num) * n % num
        else: return (find_inverse(n, pow//2) % num) ** 2 % num

tc = int(input())
N = 1
S = 0
for _ in range(tc):
    n, s = map(int, input().split())
    S = s * N + S * n
    N *= n
    S %= num
    N %= num

g = math.gcd(N,S)
N //= g
S //= g


if S % N == 0: print(S//N)
else: print(find_inverse(N, num - 2) * S % num)