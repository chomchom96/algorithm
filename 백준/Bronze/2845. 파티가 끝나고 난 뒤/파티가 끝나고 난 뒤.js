let fs = require("fs");
let input = fs.readFileSync("/dev/stdin")
	.toString()
	.split("\n")
	.map((el) => el.split(" ").map((el) => Number(el)));
let count = input[0][0] * input[0][1];
let result = [];

for (let i = 0; i < input[1].length; i++) {
	result.push(input[1][i] - count);
}

console.log(result.join(" "));