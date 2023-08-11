from collections import Counter

def assemble(seq, R):
    cnt = Counter(seq) - Counter(R)
    ans = [] 
    idx = 0
    
    while cnt:
        for i in range(9, -1, -1):  # 큰 수부터 체크
            num = str(i)  
            if cnt[num] < 1:
                continue
            t = seq.find(num, idx) # 가능하면 : 가장 앞자리 인덱스를 찾음
            check = cnt - Counter(seq[t:]) 
            
            if not check: #가능하면 앞에서부터 큰 숫자를 하나씩 assemble
                ans.append(num)
                idx = t + 1
                cnt[num] -= 1
                if cnt[num] == 0:
                    del cnt[num]
                break
    return ''.join(ans)

seq = input()
remove = input()

print(assemble(seq, remove))