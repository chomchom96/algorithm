n = int(input())
li = list(map(int, input().split()))
mod0, mod1, mod2 = [], [], []
for int in li:
    if int % 3 == 0:
        mod0.append(int)
    elif int % 3 == 1:
        mod1.append(int)
    elif int % 3 == 2:
        mod2.append(int)
if n == 1:
    print(*li)
    exit()
elif n == 2:
    if li[0] % 3 == 0 and li[1] % 3 == 0:
        print(-1)
        exit()
    print(*li)
    exit()
if len(mod0) > len(mod1) + len(mod2) + 1:
    print(-1)
    exit()
elif len(mod0) == 0 and (len(mod1) != 0 and len(mod2) != 0):
    print(-1)
    exit()
else:
    ans = []
    if len(mod0) > 1:
        ans.append(mod0.pop())
    ans.extend(mod2)
    if mod0 and mod2:
        ans.append(mod0.pop())
    ans.extend(mod1)
    if mod0 and mod1:
        ans.append(mod0.pop())
    for i in range(1, n - 2):
        if mod0:
            if ans[i] % 3 != 0 and ans[i+1] % 3 != 0:
                ans.insert(i+1, mod0.pop())
print(*ans)