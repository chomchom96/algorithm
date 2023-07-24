input = input()
ans = 0
temp = 0
flag = True
for i in range(len(input)):
    c = input[i]
    if c != '-' and c != '+':
        temp *= 10
        temp += int(c)
    if c == '+':
        if flag:
            ans += temp
            temp = 0
        else:
            ans -= temp
            temp = 0
    elif c == '-':
        if flag:
            ans += temp
            temp = 0
            flag = False
        else:
            ans -= temp
            temp = 0
    if i == len(input) - 1:
        if flag:
            ans += temp
        else:
            ans -= temp

print(ans)