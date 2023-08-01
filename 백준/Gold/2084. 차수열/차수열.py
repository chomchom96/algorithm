n = int(input())
v = list(map(int, input().split()))

if sum(v) % 2 == 1: # 홀수면 불가능
    print(-1)
else:
    a = [[0 for _ in range(n)] for _ in range(n)]
    coords = []

    for idx, val in enumerate(v):
        coords.append((val, idx))

    coords.sort(reverse=True)

    while True:
        coords.sort(reverse=True)
        if coords[0][0] == 0:
            break

        cnt = coords[0][0]
        coords[0] = (0, coords[0][1])

        i = 1
        
        while cnt:
            if i == n: # 모든 노드를 방문했지만 더 이상 연결할 수 있는 노드가 없으면
                print(-1)
                exit(0)

            if a[coords[0][1]][coords[i][1]]: # if 1 ( 간선을 만들었다면 ) 다음 index 처리
                i += 1
                continue

            a[coords[0][1]][coords[i][1]] = a[coords[i][1]][coords[0][1]] = 1 # 간선
            coords[i] = (coords[i][0] - 1, coords[i][1]) # edge 수 -1
            i += 1
            cnt -= 1

    for i in range(n):
        for j in range(n):
            print(a[i][j], end=' ')
        print()
