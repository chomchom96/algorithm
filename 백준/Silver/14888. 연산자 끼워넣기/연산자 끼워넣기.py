from itertools import permutations
n = int(input())
num = list(map(int, input().split()))
p, m, x, d = map(int, input().split());
max_val = - 10**9
min_val = 10**9

def dfs(p, m, x, d, cur, idx):
    global max_val, min_val
    if idx == n:
        max_val = max(max_val, cur)
        min_val = min(min_val, cur)
        return
    if p:
        dfs(p-1, m, x, d, cur + num[idx], idx + 1)
    if m:
        dfs(p, m-1, x, d, cur - num[idx], idx + 1)
    if x:
        dfs(p, m, x-1, d, cur * num[idx], idx + 1)
    if d:
        dfs(p, m, x, d-1, int(cur / num[idx]), idx + 1)
        
dfs(p, m, x, d, num[0], 1)

print(max_val)
print(min_val)