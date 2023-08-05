n = int(input())
li = list(map(int, input().split())) + [0,0]
ans = 0

for i in range(n): #세 개씩 비교
    if li[i + 1] > li[i + 2]: #가운데가 크면
        a = min(li[i], li[i + 1] - li[i + 2])  # 2번째, 3번째가 같도록 2개씩 사기
        ans += 5 * a
        li[i] -= a
        li[i + 1] -= a

        b = min(li[i], li[i + 1], li[i + 2])  # 3개씩 사기
        ans += 7 * b
        li[i] -= b
        li[i + 1] -= b
        li[i + 2] -= b


    else: #3개 최대한 사고 2개 최대한 사기
        b = min(li[i], li[i + 1], li[i + 2]) 
        ans += 7 * b
        li[i] -= b
        li[i + 1] -= b
        li[i + 2] -= b

        a = min(li[i], li[i + 1])
        ans += 5 * a
        li[i] -= a
        li[i + 1] -= a

    ans += 3 * li[i]
print(ans)
