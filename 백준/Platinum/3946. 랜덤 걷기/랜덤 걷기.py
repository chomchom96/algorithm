def DP(toss, tail, head):
    DP = [[0] * (toss + 1) for _ in range(toss + 1)]
    DP[1][0] = head
    for i in range(1, toss + 1): DP[1][i] = i
    for i in range(2, toss + 1):
        for j in range(0, toss - i + 1):
            DP[i][j] = (1 - tail - head) * DP[i-1][j]  + tail * (DP[i-1][j+1] - 1) + head * (DP[i-1][max(j-1, 0)] + 1)
    
    print(f'{DP[toss][0]:.4f}')



T = int(input())
for _ in range(T):
    toss, tail, head = map(float, input().split())
    toss = int(toss)
    DP(toss, tail, head)