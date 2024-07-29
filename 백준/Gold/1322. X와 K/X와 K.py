x, k = map(int, input().split())

ans = 0
pointer = 0
for i in range(65):
    if (x >> i) & 1 == 1:
        continue
    if (k >> pointer) & 1 == 1:
        ans |= (1 << i)
    pointer += 1

print(ans)


