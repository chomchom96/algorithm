import sys
input = sys.stdin.readline

N, M = map(str,input().split())

while True:
    if len(N) != len(M):
        print(0)
        break
    else:
        ans = 0
        for i in range(len(N)):
            if N == M:
                print(N.count('8'))
                exit()
            if N[i] == M[i]:
                ans += 1
            else:
                print(N[:i].count('8'))
                exit()