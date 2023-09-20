dp = []

for i in range(500000):
    dp.append(2*i-1)

def find_square(m, n):
    ans = 0
    len = min(m, n)
    for i in range(1, len + 1, 2):
        ans += (m - i + 1) * (n - i + 1) * dp[i//2 + 1]
    print(ans)

while True:
    m, n = map(int, input().split())
    if (m == 0 and n == 0): exit()
    find_square(m, n)