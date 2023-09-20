def find_square(m, n):
    ans = 0
    for i in range(1, min(m, n) + 1, 2):
        ans += (m - i + 1) * (n - i + 1) * i
    print(ans)

while True:
    m, n = map(int, input().split())
    if (m == 0 and n == 0): exit()
    find_square(m, n)