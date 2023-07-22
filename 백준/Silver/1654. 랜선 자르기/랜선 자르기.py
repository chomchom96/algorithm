import sys
input = sys.stdin.readline

def count_cables(cables, length):
    count = 0
    for cable in cables:
        count += cable // length
    return count

def find_max(cables, required):
    start = 1
    end = max(cables)

    while start <= end:
        mid = (start + end) // 2
        count = count_cables(cables, mid)

        if count >= required:
            start = mid + 1
        else:
            end = mid - 1

    return end

K, N = map(int, input().split())
cables = []
for _ in range(K):
    cable = int(input())
    cables.append(cable)

max_length = find_max(cables, N)

print(max_length)