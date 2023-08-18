tc = int(input())
for _ in range(tc):
    n,m,k = map(int, input().split())
    if (k > m/2): print("Yuto")
    else:
        if (n*m%2 == 0): print("Platina")
        else: print("Yuto")