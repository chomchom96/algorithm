import sys
input = sys.stdin.readline

T = int(input())

def my_round(val):
    return int(val) + 1 if val - int(val) >= 0.5 else int(val)

a = my_round(T * 0.15)
li = []


for _ in range(T):
    li.append(int(input()))
li.sort()
if li:
    print(my_round(sum(li[a:T - a]) / (T - 2 * a)))
else:
    print(0)