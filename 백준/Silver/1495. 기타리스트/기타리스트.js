const input = require('fs').readFileSync('/dev/stdin').toString().split('\n').map(v => v.split(' ').map(Number));
let inputPointer = 0;
const [N, S, M] = input[inputPointer++];
const V = input[inputPointer++];
let currentVolumes = new Set([S]);

for (let i = 0; i < N; i++) {
  const curVolume = V[i];
  const nextVolumes = new Set();
  
  currentVolumes.forEach(v => {
    if (v + curVolume <= M) {
      nextVolumes.add(v + curVolume);
    }
    if (v - curVolume >= 0) {
      nextVolumes.add(v - curVolume);
    }
  });
  
  if (nextVolumes.size === 0) {
    console.log(-1);
    return;
  }
  
  currentVolumes = nextVolumes;
}

let ans = -1;
currentVolumes.forEach(v => {
  ans = Math.max(v, ans);
});

console.log(ans);