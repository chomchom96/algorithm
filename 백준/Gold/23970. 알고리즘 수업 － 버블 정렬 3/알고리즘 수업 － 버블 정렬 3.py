def bubble_sort(A, B, n):
    if A == B:
        return 1
    
    last = n - 1
    last2 = 0
    while True:
        if last == 0:
            break
        
        check = 0
        for j in range(last):
            if A[j] > A[j + 1]:
                A[j], A[j + 1] = A[j + 1], A[j]
                check += 1
                last2 = j

                if A[j] == B[j]:
                    if A == B:
                        return 1
        last = last2
        
        if check == 0:
            break
    
    return 0

n = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

print(bubble_sort(A, B, n))
