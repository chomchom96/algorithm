def fact(n):
    x = 1
    for i in range(1, n+1):
        x *= i
    return x

n, m = map(int, input().split())
print(fact(n)//(fact(n-m)*fact(m)))