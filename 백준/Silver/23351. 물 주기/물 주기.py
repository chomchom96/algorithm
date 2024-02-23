def watering(n, k, a, b):
    arr = [k] * n

    day = 0
    while 0 not in arr:

        for i in range(a):
            arr[i] += b

        for i in range(len(arr)):
            arr[i] -= 1

        arr.sort()
        day += 1

    return day


n, k, a, b = map(int, input().split())
print(watering(n, k, a, b))