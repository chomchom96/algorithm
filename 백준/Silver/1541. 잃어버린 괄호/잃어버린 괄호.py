expression = input()
ans, temp, flag = 0, 0, True

for i, c in enumerate(expression):
    if c.isdigit():
        temp = temp * 10 + int(c)
    if c in ('+', '-'):
        ans = ans + temp if flag else ans - temp
        temp = 0
        if c == '-': flag= False
    if i == len(expression) - 1:
        ans = ans + temp if flag else ans - temp

print(ans)
