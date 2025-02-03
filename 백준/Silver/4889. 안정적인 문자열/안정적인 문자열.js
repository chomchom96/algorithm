const fs = require('fs');
const input = fs.readFileSync("/dev/stdin").toString().trim().split('\n');

let cnt = 1;

for (const inputString of input) {
    if (inputString.includes('-')) break;
    
    const stack = [];
    let count = 0;

    for (const char of inputString) {
        if (char === '{') {
            stack.push(char);
        } else if (char === '}') {
            if (stack.length > 0) {
                stack.pop();
            } else {
                count++;
                stack.push('{');
            }
        }
    }

    count += Math.floor(stack.length / 2);
    console.log(`${cnt}. ${count}`);
    cnt++;
}
