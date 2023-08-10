n = int(input())
s = input()
ans = 0
point = 0
while point < len(s):
      if s[point] == "S":
            ans += 1
            point += 1
      else:
            ans += 1
            point += 2  
print(min(ans+1, n))