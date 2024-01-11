from sys import stdin

n, c =  map(int, stdin.readline().split())
m = int(stdin.readline())
taekbae = []

for _ in range(m):
    start, end, num = map(int, stdin.readline().split())
    taekbae.append((start, end, num))

taekbae.sort(key=lambda x:x[1])

li = [c]*n
total = 0

for start, end, num in taekbae:
    temp = c
    for i in range(start, end):
        if temp > min(li[i], num) :
            temp = min(li[i], num)
    for i in range(start, end):
        li[i] -= temp
    total += temp
    
print(total)