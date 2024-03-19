x,y = map(int, input().split())

if (x > y):
    print(-1)
elif (y > 2*x):
    print(-1)
else:
    print(int(((2*x-y)/4) * 2024))