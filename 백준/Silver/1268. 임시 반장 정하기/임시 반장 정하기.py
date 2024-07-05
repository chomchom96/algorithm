n = int(input())

classHistory = []
arr = [0]*n

for i in range(n):
    classHistory.append(list(map(int, input().split())))
    arr[i] = [0] * n



for i in range(5):
    for j in range(n):
        for k in range(j+1, n):
            if classHistory[j][i] == classHistory[k][i]:
                arr[k][j] = 1
                arr[j][k] = 1

cnt = []
for s in arr:
    cnt.append(s.count(1))

print(cnt.index(max(cnt))+1)