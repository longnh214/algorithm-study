/**
 * @author nakhoon
 * @date Aug 9, 2021
 * @see https://www.acmicpc.net/problem/1214
 * @mem 8.092kb
 * @time 148ms
 * @caution
 * [고려사항]
 * 자바스크립트의 parseInt는 문자열을 출력한다...
 * 정수를 리턴하려면 Math.floor 함수를 사용하자.
 * [입력사항]
 * [출력사항]
 */

const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

const solution = (D, P, Q) => {
    if (D % P === 0 || D % Q === 0) return D;

    let max = Math.max(P, Q);
    let min = Math.min(P, Q);

    let answer = max * (Math.floor(D / max) + 1);

    let temp;
    for (let i = Math.floor(D / max); i >= 0; i--) {
        let div = Math.floor((D - i * max) / min);
        let mod = (D - i * max) % min;

        if (mod === 0) {
            return D;
        }

        temp = i * max + (div + 1) * min;

        if (temp === answer) break;
        answer = Math.min(answer, temp);
    }

    return answer;
};

rl.on("line", (str) => {
    let arr = str.split(" ");
    console.log(solution(arr[0], arr[1], arr[2]) + "");
    rl.close();
}).on("close", () => {
    process.exit();
});
