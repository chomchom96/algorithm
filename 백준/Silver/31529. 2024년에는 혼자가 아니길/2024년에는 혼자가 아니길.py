from math import sqrt

y,x = map(int, input().split())

if (x > 2*y):
    print(-1)
else:
    print(int(((2*y-x)/4) * 2024))