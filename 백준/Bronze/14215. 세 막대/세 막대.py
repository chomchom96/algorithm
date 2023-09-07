li = list(map(int, input().split()))
li.sort()

while (li[2] >= li[0] + li[1]): 
    li[2] -= 1
    li.sort()

print(sum(li))    