n = int(input())
li = []
for _ in range(n):
    li.append(int(input()))

li.sort(reverse=True)

for i in range(n-2):
    if li[i] < li[i+1] + li[i+2]:
        print(li[i] + li[i+1] + li[i+2])
        exit()
print(-1)