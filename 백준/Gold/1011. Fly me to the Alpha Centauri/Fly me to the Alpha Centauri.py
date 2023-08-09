import sys
from math import ceil, sqrt
T = int(sys.stdin.readline())
for _ in range(T):
    a,b = map(int, sys.stdin.readline().split())
    n = b-a
    print(2*int(sqrt(n))-1+ceil((n - int(sqrt(n))**2)/int(sqrt(n))))