import sys
input = sys.stdin.readline

N, M = map(str,input().split())

if len(N) != len(M):
    print(0)
    exit()
elif N == M:
    print(N.count('8'))
    exit()
else:
    for i in range(len(N)):
        if N[i] != M[i]:
            print(N[:i].count('8'))
            exit()