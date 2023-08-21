import sys
input = sys.stdin.readline

def generate_lis(array):
    n = len(array)
    lis = [1] * n

    for i in range(1, n):
        for j in range(i):
            if array[i] > array[j] and lis[i] < lis[j] + 1:
                lis[i] = lis[j] + 1
    
    array.reverse()
    r_lis = [1] * n

    for i in range(1, n):
        for j in range(i):
            if array[i] > array[j] and r_lis[i] < r_lis[j] + 1:
                r_lis[i] = r_lis[j] + 1
    ans = 0

    for i in range(n):
        ans = max(ans, lis[i] + r_lis[n - i - 1])
    print(ans - 1)

n = int(input())
li = list(map(int, input().split()))

generate_lis(li)