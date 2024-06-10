const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

// let input = require('fs').readFileSync('input.txt').toString().split('\n');

let input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");

const inputArr = input.map((v) => v.split(" ").map(Number));

let answer = -1;
let queue = [];
let inputPointer = 0;
const [M, N] = inputArr[inputPointer++];

let graph = Array.from({ length: N }, () => Array(M).fill(0));

for (let i = 0; i < N; i++) {
  graph[i] = inputArr[inputPointer++];
  for (let j = 0; j < M; j++) {
    if (graph[i][j] === 1) {
      queue.push([i, j]);
    }
  }
}

let queuePointer = 0;
while (queuePointer < queue.length) {
  let [cr, cc] = queue[queuePointer++];
  const cur = graph[cr][cc];
  for (let i = 0; i < 4; i++) {
    let nr = cr + dr[i];
    let nc = cc + dc[i];

    if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
      if (graph[nr][nc] === 0) {
        graph[nr][nc] = cur + 1;
        queue.push([nr, nc]);
      }
    }
  }
}

l: for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (graph[i][j] === 0) {
      answer = 0;
      break l;
    }
    answer = Math.max(answer, graph[i][j]);
  }
}

console.log(answer - 1);