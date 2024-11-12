const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
let inputPointer = 0;
let N = parseInt(input[inputPointer++]);
let leftList = input[inputPointer++].split(" ").map(_ => parseInt(_));
let rightList = input[inputPointer++].split(" ").map(_ => parseInt(_));

function solution() {
  if (Math.max(...leftList) > Math.max(...rightList)) {
      console.log(rightList.reduce((a, b) => a + b, 0));
      return;
  }
  
  const dp = Array(N + 1).fill().map(() => Array(N + 1).fill(-1));
  dp[0][0] = 0;
  
  for (let i = 0; i < N; i++) {
      for (let j = 0; j < N; j++) {
          if (dp[i][j] > -1) {
              dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j]);
              dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
              if (leftList[i] > rightList[j]) dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i][j] + rightList[j]);
          }
      }
  }
  
  const maxLastRow = Math.max(...dp[N]);
  const maxLastCol = Math.max(...dp.map(row => row[N]));
  
  console.log(Math.max(maxLastRow, maxLastCol));
};

solution();