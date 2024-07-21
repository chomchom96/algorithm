const input = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
let inputPointer = 0;

const [N, M] = input[inputPointer++].split(" ").map(Number);
const node = {};
for (let i = 0; i < N - 1; i++) {
    const [start, end, dist] = input[inputPointer++].split(" ").map(Number);
    node[start] ? node[start].push([end, dist]) : (node[start] = [[end, dist]]);
    node[end] ? node[end].push([start, dist]) : (node[end] = [[start, dist]]);
}

const toFind = [];
for (let i = N - 1; i < N + M - 1; i++) {
    toFind.push(input[inputPointer++].split(" ").map(Number));
}

const dfs = (start, end) => {
    const visited = new Array(1001).fill(false);
    const stack = [];
    stack.push([start, 0]);
    visited[start] = true;

    while (stack.length) {
        const [n, d] = stack.pop();

        if (n === end) {
            return d;
        }

        if (node[n]) {
            node[n].forEach(([next, distance]) => {
                if (!visited[next]) {
                    stack.push([next, d + distance]);
                    visited[next] = true;
                }
            });
        }
    }
    return 0;
};

const answer = [];
toFind.forEach(([s, e]) => {
    answer.push(dfs(s, e));
});

console.log(answer.join("\n"));