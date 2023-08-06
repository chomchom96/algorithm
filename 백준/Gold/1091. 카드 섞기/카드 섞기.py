import sys
input = sys.stdin.readline

N = int(input())
P = input().split()
S = list(map(int,input().split()))

visited = set()
target = '012' * (N//3)
ans = 0
while True:
    seq = "".join(P)
    if seq == target:
        break
    if seq in visited:
        ans = -1
        break
    visited.add(seq)
    temp = [0] * N
    for i in range(N):
        temp[S[i]] = P[i]
    P = temp
    ans += 1
print(ans)