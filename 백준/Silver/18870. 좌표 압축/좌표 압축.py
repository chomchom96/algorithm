import sys
input = sys.stdin.readline

n = int(input())
num_list = list(map(int, input().split()))
num_set = sorted(set(num_list))
dict = {i:index for index, i in enumerate(num_set)}

ans = []
for i in range(len(num_list)):
    ans.append(dict[num_list[i]])

print(*ans)