from bisect import bisect_left

def generate_lis(array):
    n = len(array)
    lis = [array[0]]

    for i in range(1, n):
        if array[i] > lis[-1]:
            lis.append(array[i])
        else:
            position = bisect_left(lis, array[i])
            lis[position] = array[i]

    return lis

n = int(input())
li = list(map(int, input().split()))
print(len(generate_lis(li)))