// let input = require('fs').readFileSync('input.txt').toString().split('\n');

let input = require("fs")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const inputArr = input.map((v) => v.split(" ").map(Number));
let inputPointer = 0;
let TC = inputArr[inputPointer++];

while (TC-- > 0) {
  let [n, k] = inputArr[inputPointer++];
  let map = new Array(n+1).fill(null).map(() => []);
  let weight = new Array(n + 1).fill(0);
  let weightList = inputArr[inputPointer++];
  for (let i = 0; i < n; i++) weight[i+1] = weightList[i];
  const inDegree = new Array(n+1).fill(0);
  while (k --> 0) {
    let [start, end] = inputArr[inputPointer++]
    map[start].push(end);
    inDegree[end]++;
  }
  const DP = Array(n+1).fill(0);
  const queue = [];
  for (let i = 1; i <= n; i++) {
    if (inDegree[i] === 0) {
      queue.push(i);
      DP[i] = weight[i];
    }
  }
  let queuePointer = 0;
  while (queuePointer < n-1) {
    const cur = queue[queuePointer++];
    for (let next of map[cur]) {
      inDegree[next]--;
      DP[next] = Math.max(DP[next], DP[cur] + weight[next]);
      if (inDegree[next] === 0) queue.push(next);
    }
  }
  const dest = inputArr[inputPointer++];
  console.log(DP[dest])
}