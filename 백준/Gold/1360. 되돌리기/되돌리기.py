import sys

def solve():
    N = int(input())
    ops = [] 
    text = '' 
    
    for _ in range(N):
        cmd, ch, t = map(str, sys.stdin.readline().split())
        t = int(t)
        
        if cmd == 'type':
            text += ch
            ops.append((t, text))
        else:
            ch = int(ch)
            flag = False
            
            for i in range(len(ops) - 1, -1, -1):
                if ops[i][0] >= t - ch:
                    continue
                flag = True
                text = ops[i][1]
                ops.append((t, text))
                break
            
            if not flag:
                text = ''
                ops.append((t, text))
    
    print(ops[-1][1] if ops else '')

solve()