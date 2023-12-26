import sys
import heapq

N, K = map(int, sys.stdin.readline().split())
jewel = []
for _ in range(N):
    heapq.heappush(jewel, list(map(int, sys.stdin.readline().split())))
bags = []
for _ in range(K):
    bags.append(int(sys.stdin.readline()))
bags.sort()

answer = 0
h_jewel = []
for bag in bags:
    while jewel and bag >= jewel[0][0]:
        heapq.heappush(h_jewel, -heapq.heappop(jewel)[1])
    if h_jewel:
        answer -= heapq.heappop(h_jewel)
    elif not jewel:
        break
print(answer)