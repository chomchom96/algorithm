const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
let lineCount = 0;
let n, m, l;
let arr = [];
rl.on('line', (line) => {
    if (lineCount === 0) {
        [n, m, l] = line.split(' ').map(Number);
        arr = [0, l];
        if (n === 0) {
            solveProblem();
        }
    } else if (lineCount === 1) {
        if (n > 0) {
            arr = arr.concat(line.split(' ').map(Number));
            solveProblem();
        }
    }
    lineCount++;
});

function solveProblem() {
    arr.sort((a, b) => a - b);
    
    let start = 0;
    let end = l;
    
    while (start + 1 < end) {
        const mid = (start + end) >> 1;
        let count = 0;
        
        for (let i = 0; i < arr.length - 1; i++) {
            const dist = arr[i + 1] - arr[i];
            count += Math.ceil(dist / mid) - 1;
        }
        
        if (count > m) {
            start = mid;
        } else {
            end = mid;
        }
    }
    
    console.log(end);
    rl.close();
}