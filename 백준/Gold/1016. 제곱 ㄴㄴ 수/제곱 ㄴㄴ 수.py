m, M = map(int, input().split())
l = [1] * (M - m + 1)
n = int(M ** 0.5)
for i in range(2, n + 1):
    s = i ** 2
    sn = s - (m % s) if m % s != 0 else 0
    for j in range(sn, len(l), s):
        l[j] = 0
print(sum(l))
