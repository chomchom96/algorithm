const input = require('fs').readFileSync('/dev/stdin').toString().split('\n');
let inputPointer = 0;
const N = input[inputPointer++];
let map = [];
let dotCount = 0;
for (let rowIdx = 0; rowIdx < 2; rowIdx++) {
  let row = input[inputPointer++].split("");
  for (let colIdx = 0; colIdx < N; colIdx++) {
    if (row[colIdx] === ".") dotCount++;
  }
  map.push(row);
}

const queue = [];

for (let rowIdx = 0; rowIdx < 2; rowIdx++) {
  if (map[rowIdx][0] === ".") queue.push([rowIdx, 0, 0]);
}

const dr = [-1, 0, 1];
const dc = [0, 1, 0];

let ans = 10000;
const visited = Array.from({ length: 2 }, () => Array.from({ length: N }, () => false));

while (queue.length > 0) {
  let [cr, cc, cLength] = queue.shift();
  visited[cr][cc] = true;
  if (cc === N - 1) {
    ans = Math.min(ans, cLength);
  }
  for (let i = 0; i < 3; i++) {
    let nr = cr + dr[i];
    let nc = cc + dc[i];
    if (nr < 0 || nr >= 2) continue;
    if (visited[nr][nc]) continue;
    if (map[nr][nc] === ".") queue.push([nr, nc, cLength+1]);
  }
}

console.log(dotCount - ans - 1);