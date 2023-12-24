n, m = map(int, input().split())
package = 1001
single = 1001

for _ in range(m):
    a, b = map(int, input().split())
    package = min(package, a)
    single = min(single, b)

min_package = min(package, single * 6)

ans = 0

while True:
    if n >= 6:
        ans += min_package * (n // 6)
        n %= 6
    else:
        ans += min(single * n, min_package)
        break

print(ans)