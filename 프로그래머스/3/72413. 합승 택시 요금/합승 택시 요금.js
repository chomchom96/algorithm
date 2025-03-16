function solution(n, s, a, b, fares) {
    // 그래프 초기화 (인접 행렬)
    const graph = Array.from({ length: n + 1 }, () => 
        Array.from({ length: n + 1 }, () => Infinity)
    );
    
    // 자기 자신으로 가는 비용은 0
    for (let i = 1; i <= n; i++) {
        graph[i][i] = 0;
    }
    
    // 주어진 택시요금 정보로 그래프 구성
    for (const [c, d, f] of fares) {
        graph[c][d] = f;
        graph[d][c] = f; // 양방향 그래프
    }
    
    // 플로이드-워셜 알고리즘으로 모든 지점 간 최단 거리 계산
    for (let k = 1; k <= n; k++) {
        for (let i = 1; i <= n; i++) {
            for (let j = 1; j <= n; j++) {
                if (graph[i][k] + graph[k][j] < graph[i][j]) {
                    graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }
    
    // 최소 택시요금 계산
    let minFare = Infinity;
    
    // 모든 지점을 경유지로 고려
    for (let i = 1; i <= n; i++) {
        // s -> i -> a, s -> i -> b 경로의 최소 비용 계산
        // i는 합승을 종료하는 지점
        const fare = graph[s][i] + graph[i][a] + graph[i][b];
        minFare = Math.min(minFare, fare);
    }
    
    return minFare;
}