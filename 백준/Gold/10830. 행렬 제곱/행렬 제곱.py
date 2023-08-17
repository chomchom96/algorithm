import sys
input = sys.stdin.readline

N, B = map(int, input().split())
A = [[*map(int, input().split())] for _ in range(N)]

def mul(U, V):
    n = len(U)
    Z = [[0]*n for _ in range(n)]
    
    for row in range(n):
        for col in range(n):
            e = 0
            for i in range(n):
                e += U[row][i] * V[i][col]
                e %= 1000
            Z[row][col] = e

    return Z

def square(A, B):
    n = len(A)
    if B == 1:
        for x in range(n):
            for y in range(n):
                A[x][y] %= 1000
        return A
    
    result = [[0] * n for _ in range(n)]
    for x in range(n):
        result[x][x] = 1

    while B > 0:
        if B % 2:
            result = mul(result, A)
        A = mul(A, A)
        B //= 2

    return result

result = square(A, B)
for r in result:
    print(*r)