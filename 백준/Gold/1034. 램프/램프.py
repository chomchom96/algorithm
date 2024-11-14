N, M = map(int, input().split())
lamps = [input() for _ in range(N)]
K = int(input())

answer = 0
for i in range(N):
    off = lamps[i].count('0')
    if off <= K and off % 2 == K % 2:
        answer = max(answer, lamps.count(lamps[i]))

print(answer)