const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");

const [n, m, r] = input[0].split(" ").map(Number);
const value = input[1].split(" ").map(Number);
const map = Array.from({ length: n + 1 }, () => []);

for (let i = 2; i <= r + 1; i++) {
    let [start, end, len] = input[i].split(" ").map(Number);
    map[start].push({ n: end, d: len }); 
    map[end].push({ n: start, d: len }); 
}

function dijkstra(start, n, range, value, map) {
    const dist = new Array(n + 1).fill(-1);
    dist[start] = 0;
    
    const queue = [{ n: start, d: 0 }];
    
    while (queue.length > 0) {
        queue.sort((a, b) => a.d - b.d);
        const cur = queue.shift();
        
        if (dist[cur.n] === -1 || dist[cur.n] < cur.d) continue;
        
        for (const next of map[cur.n]) {
            if (dist[next.n] === -1 || dist[next.n] > dist[cur.n] + next.d) {
                dist[next.n] = dist[cur.n] + next.d;
                queue.push({ n: next.n, d: dist[next.n] });
            }
        }
    }

    return Array.from({ length: n }, (_, i) => i + 1).reduce(
        (sum, i) => (dist[i] !== -1 && dist[i] <= range ? sum + value[i-1] : sum),  // Changed: value[i-1] since value array is 0-based
        0
    );
}

function findMaxValue(n, range, value, map) {
    return Math.max(...Array.from({ length: n }, (_, i) => i + 1)
        .map(i => dijkstra(i, n, range, value, map)));
}

console.log(findMaxValue(n, m, value, map));