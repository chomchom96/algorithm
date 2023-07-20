N = int(input())
M = int(input())
str = input()

ans = 0

target = 'I' + 'OI' * N # len(target) = 2*N+1

for i in range(0, M - 2*N):
    if str[i] == 'O':
        continue
    elif str[i : i + 2 * N + 1] == target:
        ans += 1

print(ans)