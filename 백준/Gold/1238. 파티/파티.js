const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');

let inputPointer = 0;

const [N, M, X] = input[inputPointer++].split(' ').map(Number);
const map = Array.from({ length: N + 1 }, () => []);
const rMap = Array.from({ length: N + 1 }, () => []);

for (let i = 0; i < M; i++) {
  const [start, end, cost] = input[inputPointer++].split(' ').map(Number);
  map[start].push([end, cost]);
  rMap[end].push([start, cost]);
}


let dist = new Array(M+1).fill(-1);
let distReverse = new Array(M+1).fill(-1);
dist[X] = 0;
distReverse[X] = 0;

let ans = -1

let queue = [];
const dijikstra = (map, dist) => {
  queue.push([X, 0]);
  do {
    let [curNode, curDist] = queue.shift();
    if (curDist > dist[curNode]) continue;    
    for (let edge of map[curNode]) {
      let [edgeNode, edgeDist] = edge;
      if (dist[edgeNode] === -1 || dist[edgeNode] > dist[curNode] + edgeDist) {
        dist[edgeNode] = dist[curNode] + edgeDist
        queue.push([edgeNode, dist[edgeNode]])
      }
     }
  } while (queue.length > 0)
}

dijikstra(map, dist);
dijikstra(rMap, distReverse);

for (let i = 1; i <= N; i++) ans = Math.max(ans, dist[i] + distReverse[i]);

console.log(ans);