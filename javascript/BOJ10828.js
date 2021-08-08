/**
 * @author nakhoon
 * @date Aug 8, 2021
 * @see https://www.acmicpc.net/problem/10828
 * @mem 13,788kb
 * @time 224ms
 * @caution
 * [고려사항]
 * 자바스크립트로 문제 입력받기 너무 어렵다...
 * [입력사항]
 * [출력사항]
 */
const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

let count;
let i = 0;
let stack = [];
let answer = "";

rl.on("line", (input) => {
    if (!count) count = +input;
    else {
        if (i == count - 1) {
            stackProcess(input);
            console.log(answer.substring(0, answer.length - 1));
            rl.close();
        } else {
            stackProcess(input);
            i++;
        }
    }
}).on("close", () => {
    process.exit();
});

const stackProcess = (input) => {
    let command = input.split(" ")[0];
    let num;
    switch (command) {
        case "push":
            num = input.split(" ")[1];
            stack.push(parseInt(num));
            break;
        case "top":
            answer += (stack.length == 0 ? -1 : stack[stack.length - 1]) + "\n";
            break;
        case "size":
            answer += stack.length + "\n";
            break;
        case "empty":
            answer += (stack.length == 0 ? 1 : 0) + "\n";
            break;
        case "pop":
            num = stack[stack.length - 1];
            stack = stack.filter((num, i) => i != stack.length - 1);
            if (!num) num = -1;
            answer += num + "\n";
            break;
    }
};
