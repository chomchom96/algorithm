function find(a) {
  if (parent[a] != a) return parent[a] = find(parent[a]);
  return a;
}

function union(a,b) {
  a = find(a);
  b = find(b);
  parent[a] = b;
}

const input = require('fs').readFileSync("/dev/stdin").toString().split("\n");
// const input = require("fs").readFileSync("input.txt").toString().split("\n");

let inputPointer = 0;

const n = parseInt(input[inputPointer++]);
let parent = Array.from({length: n + 1}, (_, i) => i);

for (let i = 0; i < n - 2; i++) {
  const [start, end] = input[inputPointer++].split(" ");
  union(parseInt(start), parseInt(end));
}

const first = find(1);
for (let i = 2; i <= n; i++) {
  if (find(i) !== first) {
    console.log("1 " + i);
    break;
  }
}