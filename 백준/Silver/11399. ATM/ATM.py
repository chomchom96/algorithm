n = int(input())
li = list(map(int, input().split()))
li.sort()
sum = 0
for i in range(len(li)):
    sum += li[i]*(len(li)-i)
print(sum)