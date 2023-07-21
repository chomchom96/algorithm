import sys
input = sys.stdin.readline

T = int(input())

coord = []
for _ in range(T):
    x, y = map(int, input().split())
    coord.append((x, y))

coord.sort(key=lambda x: (x[0], x[1]))

for i in coord:
    print(i[0], i[1])