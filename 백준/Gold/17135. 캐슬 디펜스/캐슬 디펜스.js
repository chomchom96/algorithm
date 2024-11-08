const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
function solution() {
  let inputPointer = 0;
  let [N, M, D] = input[inputPointer++].split(" ").map(a => parseInt(a));
  let n = N;
  let monsters = [];
  for (let i = 0; i < N; i++) {
    let arr = input[inputPointer++].split(" ").map(a => parseInt(a));
    for (let j = 0; j < M; j++) {
      if (arr[j] === 1) monsters.push([i, j]);
    }
  };
  let archer = [0, 0, 0];
  let ans = 0;

  function getDist(a, b) {
    return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
  }

  function attackMonster() {
    let cnt = 0;
    let queue = [...monsters];
    let round = n;
    
    while (round > 0) {
      const targets = new Set();
      
      for (let i = 0; i < 3; i++) {
        let minDist = Infinity;
        let target = null;
        
        for (let j = 0; j < queue.length; j++) {
          const monster = queue[j];
          const archerPos = [round, archer[i]];
          const dist = getDist(monster, archerPos);
          
          if (dist <= D && dist < minDist && monster[0] < round) {
            minDist = dist;
            target = j;
          } else if (dist <= D && dist === minDist && monster[0] < round) {
            if (queue[j][1] < queue[target][1]) {
              target = j;
            }
          }
        }
        
        if (target !== null) {
          targets.add(target);
        }
      }
      
      const targeted = Array.from(targets).sort((a, b) => b - a);
      cnt += targeted.length;
      for (const idx of targeted) {
        queue.splice(idx, 1);
      }
      queue = queue.filter(monster => monster[0] < round - 1);
      round--;
    }
    
    ans = Math.max(ans, cnt);
  }

  function locateArcher(idx, start) {
    if (idx === 3) {
      attackMonster();
      return;
    }
    
    for (let i = start; i < M; i++) {
      archer[idx] = i;
      locateArcher(idx + 1, i + 1);
    }
  }

  locateArcher(0, 0);
  console.log(ans);
};

solution();