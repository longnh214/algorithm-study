/**
 * @author choi
 * @date Jul 30, 2020
 * @see https://www.acmicpc.net/problem/2493
 * @mem 167,384kb
 * @time 740ms
 * @caution
 * [고려사항]탑의 높이가 1억까지 값이 들어갈 수 있기 때문에 int 타입보다 long 타입을 써주어야했다.
 * 			출력할 때 메모리 초과가 나는 것 같아 system.out.println을 쓰지 않고 StringBuilder를 이용했더니
 * 			메모리 초과가 나지 않았다. StringBuilder에 더 익숙해져야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 2493번 <스택> - '탑'
public class BOJ2493 {

    public static void main(String[] args) throws IOException {
        Stack<Tower> stack = new Stack<Tower>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        long height;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < count; i++) {
            height = Long.parseLong(st.nextToken());

            //answer 배열 값을 저장했나 안했나.
            while (!stack.isEmpty()) {
                if (stack.peek().height > height) {
                    sb.append(stack.peek().index + " ");
                    break;
                }else {
                    stack.pop();
                }
            }
            if(stack.isEmpty()) sb.append("0 ");
            stack.push(new Tower(i + 1, height));
        }

        System.out.println(sb.toString());
    }

    static class Tower {
        int index;
        long height;

        Tower(int index, long height) {
            this.index = index;
            this.height = height;
        }
    }
}