import sys
sys.setrecursionlimit(100000)

def dfs(cnt, L, N, v, visited, ans):
    if cnt == L:
        flag = True
        for i in range(L):
            for j in range(i + 1, L):
                flag &= (ans[i][j] == ans[j][i])
        
        if flag:
            for row in ans:
                print(''.join(row))
            exit(0)
        return
    
    for i in range(N):
        if visited[i]:
            continue
        visited[i] = True
        ans[cnt] = v[i]
        dfs(cnt + 1, L, N, v, visited, ans)
        visited[i] = False

def solve():
    L, N = map(int, input().split())
    
    v = []
    for _ in range(N):
        v.append(input().strip())
    
    v.sort()
    
    visited = [False] * N
    ans = [''] * L
    
    dfs(0, L, N, v, visited, ans)
    
    print("NONE")

if __name__ == "__main__":
    solve()