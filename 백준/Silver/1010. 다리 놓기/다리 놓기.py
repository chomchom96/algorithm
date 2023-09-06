from math import comb
import sys

input = sys.stdin.readline
T = int(input())

for _ in range(T):
    n, r = map(int, input().split())
    print(comb(r, n))