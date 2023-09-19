n = int(input())

times = []
for _ in range(n):
    times.append(tuple(map(int, input().split())))

times.sort(key=lambda x : (x[1], x[0]))

max_count = 0
current_end = -1

for start, end in times:
    if start >= current_end:
        max_count += 1
        current_end = end

print(max_count)