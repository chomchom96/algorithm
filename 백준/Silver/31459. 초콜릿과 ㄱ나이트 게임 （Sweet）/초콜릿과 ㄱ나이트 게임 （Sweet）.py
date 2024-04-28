import sys
input = sys.stdin.readline

def main():
    T = int(input())
    
    results = []
    for _ in range(T):
        X, Y, x, y = map(int, input().split())
        
        map_grid = [[0] * (Y + 1) for _ in range(X + 1)]
        cnt = 0
        
        for i in range(1, X + 1):
            for j in range(1, Y + 1):
                if i - x >= 1 and j - y >= 1 and map_grid[i - x][j - y] == 1:
                    continue
                map_grid[i][j] = 1
                cnt += 1
        
        results.append(cnt)
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
