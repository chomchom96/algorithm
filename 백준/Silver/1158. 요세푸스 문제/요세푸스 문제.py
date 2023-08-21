from collections import deque

n, k = map(int, input().split())

num = deque(range(1, n + 1))
ans = []

while num:
    for _ in range(k - 1):
        num.append(num.popleft())
    ans.append(num.popleft())

output = '<' + ', '.join(map(str, ans)) + '>'
print(output)