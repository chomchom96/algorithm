def solution(N):
    if N == 0:
        return 0
    N += 1

    dp = [[0] * 10 for _ in range(11)]
    
    for i in range(10):
        dp[1][i] = 1
        
    for i in range(2, 11):
        for j in range(10):
            for k in range(j):
                dp[i][j] += dp[i-1][k]
                
    cnt = 0
    num = []
    
    total = sum(sum(row) for row in dp)
    if N > total:
        return -1
        
    digits = 1
    s = sum(dp[1])
    while cnt + s < N:
        cnt += s
        digits += 1
        s = sum(dp[digits])
    
    remain = N - cnt
    first_digit = 0
    while remain > dp[digits][first_digit]:
        remain -= dp[digits][first_digit]
        first_digit += 1
    num.append(first_digit)
    
    for i in range(digits-1, 0, -1):
        next_digit = 0
        while next_digit < num[-1] and remain > dp[i][next_digit]:
            remain -= dp[i][next_digit]
            next_digit += 1
        num.append(next_digit)
    
    result = 0
    for n in num:
        result = result * 10 + n
        
    return result

N = int(input())
print(solution(N))