N = int(input())
ori = []
vert_x = []
vert_y = []

for i in range(N):
    u, v, w = map(int, input().split())
    ori.append((u, v, w, i))
    vert_x.append((u, v, w, i))
    vert_y.append((u, v, w, i))

vert_x.sort(key=lambda x: (x[0], x[1]))
vert_y.sort(key=lambda x: (x[1], x[0]))

visit = [0] * 41
perm = []
minv = 1e8

for xi in range(N):
    for xj in range(xi, N):
        for yi in range(N):
            for yj in range(yi, N):
                visit = [0] * 41
                perm = []

                minx = min(vert_x[xi][0], vert_x[xj][0], vert_y[yi][0], vert_y[yj][0])
                maxx = max(vert_x[xi][0], vert_x[xj][0], vert_y[yi][0], vert_y[yj][0])
                miny = min(vert_x[xi][1], vert_x[xj][1], vert_y[yi][1], vert_y[yj][1])
                maxy = max(vert_x[xi][1], vert_x[xj][1], vert_y[yi][1], vert_y[yj][1])
                
                dist = (maxx - minx) * 2 + (maxy - miny) * 2
                wood = 0
                cnt = 0

                for i in range(N):
                    curx, cury, curw, _ = ori[i]

                    if minx <= curx <= maxx and miny <= cury <= maxy:
                        perm.append(curw)
                    else:
                        wood += curw
                        cnt += 1

                perm.sort()
                
                while dist > wood and perm:
                    wood += perm.pop()
                    cnt += 1

                if dist <= wood:
                    minv = min(minv, cnt)

print(minv)