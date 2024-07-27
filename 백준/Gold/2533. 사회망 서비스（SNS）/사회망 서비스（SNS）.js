const input = require("fs").readFileSync("/dev/stdin").toString().split("\n");
let inputPointer = 0;

const N = parseInt(input[inputPointer++]);

let DP = Array.from({ length: N + 1 }, () => [0, 0]);

let graph = Array.from({ length: N + 1 }, () => []);

for (let i = 0; i < N - 1; i++) {
    let [start, end] = input[inputPointer++].split(' ');
    start = parseInt(start);
    end = parseInt(end);
    graph[start].push(end);
    graph[end].push(start);
}

function dfs(node, parent) {
    DP[node][0] = 0;
    DP[node][1] = 1; 

    for (let neighbor of graph[node]) {
        if (neighbor === parent) continue;
        dfs(neighbor, node);

        DP[node][0] += DP[neighbor][1];
        DP[node][1] += Math.min(DP[neighbor][0], DP[neighbor][1]);
    }
}

dfs(1, -1);

const result = Math.min(DP[1][0], DP[1][1]);

console.log(result);