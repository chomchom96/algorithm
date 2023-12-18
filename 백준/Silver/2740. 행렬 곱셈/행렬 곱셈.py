n, m = map(int, input().split())
A = [[0 for i in range(m)] for j in range(n)]
for i in range(n):
    A[i] = list(map(int, input().split()))

m, k = map(int, input().split())
B = [[0 for i in range(k)] for j in range(m)]
for i in range(m):
    B[i] = list(map(int, input().split()))

for i in range(n):
    for j in range(k):
        sum = 0
        for len in range(m):
            sum += A[i][len]*B[len][j]
        if (j != k - 1):
            print(sum, end = " ")
        else:
            print(sum, end = "\n")
    