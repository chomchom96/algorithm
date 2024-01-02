t = int(input())

for _ in range(t):
    cnt = 0
    x1, y1, x2, y2 = map(int, input().split())
    N = int(input())
    for i in range(N):
        x, y, r = map(int, input().split())
        d1 = (x1 - x) ** 2 + (y1 - y) ** 2
        d2 = (x2 - x) ** 2 + (y2 - y) ** 2
        if (d1 < r**2 and d2 > r**2) or ( d1 > r**2 and d2 < r**2):
            cnt += 1
    print(cnt)