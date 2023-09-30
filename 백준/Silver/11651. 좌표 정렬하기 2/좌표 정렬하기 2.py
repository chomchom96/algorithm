import sys
input = sys.stdin.readline

N = int(input())

points = []
for _ in range(N):
    x, y = map(int, input().split())
    points.append([y, x])

points = sorted(points)

for _ in points:
    print(_[1], _[0])