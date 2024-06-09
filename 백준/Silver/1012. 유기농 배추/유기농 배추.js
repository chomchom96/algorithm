const dr = [-1, 0, 1, 0];
const dc = [0, 1, 0, -1];

const bfs = (r, c, M, N, cabbage, visit) => {
  const queue = [];
  queue.push([r, c]);

  while (queue.length > 0) {
    let [cr, cc] = queue.shift();
    for (let i = 0; i < 4; i++) {
      let nr = cr + dr[i];
      let nc = cc + dc[i];

      if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
        if (!visit[nr][nc] && cabbage[nr][nc] === 1) {
          queue.push([nr, nc]);
          visit[nr][nc] = true;
        }
      }
    }
  }
};

// let input = require('fs').readFileSync('input.txt').toString().split('\n');

const input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const T = +input.shift();
const inputArr = input.map((v) => v.split(" ").map(Number));

for (let tc = 0; tc < T; tc++) {
  let answer = 0;
  const [M, N, K] = inputArr.shift();

  let cabbage = Array.from({ length: N }, () => Array(M).fill(0));
  let visit = Array.from({ length: N }, () => Array(M).fill(false));

  for (let i = 0; i < K; i++) {
    let [c, r] = inputArr.shift();
    cabbage[r][c] = 1;
  }

  for (let i = 0; i < N; i++) {
    for (let j = 0; j < M; j++) {
      if (cabbage[i][j] === 1 && !visit[i][j]) {
        bfs(i, j, M, N, cabbage, visit);
        answer++;
      }
    }
  }

  console.log(answer);

  for (let i = 0; i < visit.length; i++) {
    visit[i].fill(false);
  }
}
