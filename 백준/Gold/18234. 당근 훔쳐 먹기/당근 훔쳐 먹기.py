import sys
input = sys.stdin.readline

N, T = map(int, input().split())

li = []
for _ in range(N):
    a, b = map(int, input().split())
    li.append((a,b))

li.sort(key=lambda x: (x[1], x[0]))
sum = 0
day = T - N
for i in li:
    sum += i[0] + i[1] * day
    day += 1

print(sum)