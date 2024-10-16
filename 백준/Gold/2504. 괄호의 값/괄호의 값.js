const input = require("fs").readFileSync("/dev/stdin").toString().trim();

function solution() {
  let stack = [];

  for (let i = 0; i < input.length; i++) {
    let paren = input.charAt(i);

    if ((paren === '(' && input.charAt(i + 1) === ')') || (paren === '[' && input.charAt(i + 1) === ']')) {
      stack.push(paren === '(' ? 2 : 3);
      i++;
      continue;
    }

    if (paren === "(" || paren === "[") {
      stack.push(paren);
    } else if (paren === ")" || paren === "]") {
      let temp = 0;
      const num = paren === ")" ? 2 : 3;

      while (typeof stack.at(-1) === "number") {
        temp += stack.pop();
        if (stack.length === 0) return 0
      }

      if ((paren === ")" && stack.at(-1) === "(") || (paren === "]" && stack.at(-1) === "[")) {
        stack.pop();
        stack.push(temp === 0 ? num : temp * num);
      } else {
        return 0;
      }
    }
  }

  for (let item of stack) {
    if (typeof item === "string") return 0;
  }

  let answer = stack.reduce((acc, cur) => acc + cur, 0);
  return answer;
}

console.log(solution());