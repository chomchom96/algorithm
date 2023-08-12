N, K = map(int, input().split())
if N >= K:
    print(0)
    exit()

elecs = list(map(int, input().split()))

plug = set()
ans = 0

def latest(i): # 뒤에서부터 찾기
    last = {p: elecs[i:].index(p) if p in elecs[i:] else K for p in plug}
    pull = max(last, key=last.get)
    return pull

for idx, elec in enumerate(elecs):
    plug.add(elec)
    if len(plug) > N:
        ans += 1
        to_pull = latest(idx)  # 플러그에 꽂혀 있는 전자기기 중 가장 늦게 사용할 기구 뽑기
        plug.discard(to_pull)

print(ans)


