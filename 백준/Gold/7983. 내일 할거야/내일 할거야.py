import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))

arr.sort(key=lambda x: x[1], reverse=True)

now = arr[0][1] - arr[0][0]

for i in range(1, n):
    d, t = arr[i]
    if now >= t:
        now = t - d
    else:
        now = now - d

print(now)