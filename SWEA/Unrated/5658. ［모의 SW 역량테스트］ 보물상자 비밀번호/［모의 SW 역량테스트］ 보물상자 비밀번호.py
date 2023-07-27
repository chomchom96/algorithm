dict = {}
for i in range(10):
    dict[str(i)] = i
dict['A'] = 10
dict['B'] = 11
dict['C'] = 12
dict['D'] = 13
dict['E'] = 14
dict['F'] = 15

T = int(input())
for test_case in range(1, T + 1):
    n,k = map(int, input().split())
    wordset = set()
    word = input()
    n = len(word) 
    for i in range(n//4):
        word += word[0]
        word = word[1:]
        for j in range(4):
            wordset.add(word[j*n//4 : j*n//4+ n//4])
    wordset = list(wordset)
    wordset.sort()
    num = wordset[-k]
    ans = 0
    for i in range(len(num)):
        ans += 16 ** i * dict[num[len(num)- i - 1]]
    print("#%d"%test_case, ans)