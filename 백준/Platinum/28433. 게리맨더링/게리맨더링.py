def divide() :
    global area, cnt
    if area > 0 :
        cnt += 1
    elif area < 0 :
        cnt -= 1
    area = 0
    
if __name__ == "__main__" :
    for _ in range(int(input())) :
        _ = input()
        A = [*map(int, input().split())]
        cnt, area = 0, 0
        for a in A :
            if (a > 0) + (area > 0) + (a + area <= 0) >= 2 :
                divide()
            area += a
        divide()
        print(["NO", "YES"][cnt > 0])