N = int(input())
nums = list(map(int, input().split()))
idx = [-1] * (N + 1)
for i, v in enumerate(nums): 
    idx[v] = i
longest = 0
cnt = 1

for num in range(1, N):
    if idx[num] < idx[num + 1]:
        cnt += 1
    else:
        longest = max(longest, cnt)
        cnt = 1

print(N - longest if N != 1 else 0)
