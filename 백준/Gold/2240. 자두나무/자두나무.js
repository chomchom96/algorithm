const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
let inputPointer = 0;

let [T, W] = input[inputPointer++].split(" ");
T = parseInt(T);
W = parseInt(W);
let DP = Array.from({length: T + 1}, () => Array(W + 1).fill(0));
for (let time = 1; time <= T; time++) {
    const curPos = parseInt(input[inputPointer++]);
    for (let moveSum = 0; moveSum <= Math.min(time, W); moveSum++) {
        if (curPos % 2 === moveSum % 2) DP[time][moveSum] = moveSum > 0 ? Math.max(DP[time-1][moveSum], DP[time-1][moveSum-1] + 1): DP[time-1][moveSum];
        else DP[time][moveSum] = moveSum > 0? Math.max(DP[time-1][moveSum], DP[time-1][moveSum-1]) + 1 : DP[time-1][moveSum] + 1;
    }
}
let ans = 0;
for (let i = 0; i <= W; i++) ans = Math.max(DP[T][i]);
console.log(ans);