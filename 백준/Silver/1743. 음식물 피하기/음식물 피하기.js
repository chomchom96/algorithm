const [[N, M, K], ...input] = require('fs')
  .readFileSync('/dev/stdin')
  .toString()
  .trim()
  .split('\n')
  .map(v => v.split(' ').map(Number));

const corridor = [...Array(N)].map(() => Array(M).fill(false));
input.forEach(([x, y]) => corridor[x - 1][y - 1] = true);
const offset = [[0, 1], [1, 0], [0, -1], [-1, 0]];

const dfs = (x, y, result = 0) => {
  let sum = result + 1;
  corridor[x][y] = false;
  offset.forEach(([dx, dy]) => {
    const nx = x + dx;
    const ny = y + dy;
    if (nx >= 0 && nx < N && ny >= 0 && ny < M && corridor[nx][ny]) {
      sum += dfs(nx, ny);
    }
  });
  return sum;
};

let largest = 0;

for (let i = 0; i < N; i++) {
  for (let j = 0; j < M; j++) {
    if (!corridor[i][j]) {
      continue;
    }
    largest = Math.max(largest, dfs(i, j));
  }
}

console.log(largest);