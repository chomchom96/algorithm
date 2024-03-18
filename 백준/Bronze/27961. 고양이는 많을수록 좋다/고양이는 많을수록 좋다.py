def binary(decimal_num):
    binary_str = format(int(decimal_num), 'b')
    return binary_str

n = binary(int(input()))

if (n=='0'): 
    print(0) 
    exit()

ans = 0

ans += len(n)
flag = False

for i in range(1, len(n)):
    if (n[i] == '1'): 
        flag=True
        break

if (flag): print(ans + 1)
else: print(ans)