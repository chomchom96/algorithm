const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().split('\n');

let inputPointer = 0;

const [n, m] = input[inputPointer++].split(' ').map(Number);
const parent = new Array(n + 1).fill(0).map((_, i) => i);
const jinsil = new Array(n + 1).fill(false);

const jinsilData = input[inputPointer++].split(' ').map(Number);
const jNum = jinsilData[0];
for (let i = 1; i <= jNum; i++) jinsil[jinsilData[i]] = true;

const parties = [];

for (let i = 0; i < m; i++) {
  const partyData = input[inputPointer++].split(' ').map(Number);
  parties.push(partyData.slice(1));
}

const find = (x) => {
  if (parent[x] !== x) {
    parent[x] = find(parent[x]);
  }
  return parent[x];
};

const union = (a, b) => {
  const rootA = find(a);
  const rootB = find(b);
  if (rootA !== rootB) {
    if (rootA > rootB) parent[rootA] = rootB;
    else parent[rootB] = rootA;
  }
};

for (const party of parties) {
  const init = party[0];
  for (const p of party) {
    union(init, p);
  }
}

for (let i = 1; i <= n; i++) {
  if (jinsil[i]) jinsil[find(i)] = true;
  if (jinsil[find(i)]) jinsil[i] = true;
}

let ans = 0;

for (const party of parties) {
  const init = party[0];
  if (!jinsil[find(init)]) ans++;
}

console.log(ans);
