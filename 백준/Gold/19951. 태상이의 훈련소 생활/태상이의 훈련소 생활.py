n, m = map(int,input().split())
li = list(map(int,input().split()))
diff = [0] * (n + 1)

for i in range(m):
    a ,b, k = map(int,input().split())
    diff[a - 1] += k
    diff[b] -= k

print(li[0] + diff[0], end = ' ')

for i in range(1, n):
    diff[i] += diff[i - 1]
    print(li[i] + diff[i], end=' ')