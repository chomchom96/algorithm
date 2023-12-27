li = []
for _ in range(8):
    li.append([_, int(input())])

li.sort(key=lambda x:-x[1])
ans = []
sum = 0
for i in range(5):
    sum += li[i][1]
    ans.append(li[i][0] + 1)

print(sum)
print(*sorted(ans))