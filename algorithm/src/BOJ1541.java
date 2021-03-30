/**
 * @author choi
 * @date 2020. 8. 7
 * @see https://www.acmicpc.net/problem/1541
 * @mem 13,036kb
 * @time 80ms
 * @caution
 * [고려사항] 큐를 이용해서 숫자를 판별하고 더하거나 빼주었다. 다음에는 더 깔끔하게 짤 수 있도록 생각해야겠다.
 *         맨처음 -부터 전부 -로 바꿔주면 생각보다 쉬운데, 바꿔주고 계산을 따로 하려다보니 코드가 길어졌다.
 *         한번에 할 수 있는 방법도 있다는 것을 알았다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <그리디 알고리즘> - '잃어버린 괄호'
public class BOJ1541 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char [] expression = str.toCharArray();
        Queue<Character> q = new LinkedList<>();
        boolean flag = false;
        for(int i=0;i<expression.length;i++) {
            if(expression[i] >= '0' && expression[i] <= '9') {
                continue;
            }else if(expression[i] == '-') {
                flag = true;
            }else if(flag == true && expression[i] == '+'){
                expression[i] = '-';
            }
        }
        int answer = 0;
        flag = false;
        char temp = '+';
        for(int i=0;i<=expression.length;i++) {
            if(i == expression.length){
                int size = q.size();
                if(temp == '-') {
                    while(!q.isEmpty()) {
                        int num = q.poll() - '0';
                        answer -= Math.pow(10, size-1)*num;
                        size--;
                    }
                }else {
                    while(!q.isEmpty()) {
                        int num = q.poll() - '0';
                        answer += Math.pow(10, size-1)*num;
                        size--;
                    }
                }
                break;
            }


            if(!flag) {
                if(expression[i] >= '0' && expression[i] <= '9') {
                    q.offer(expression[i]);
                }else {
                    flag = true;
                }
            }
            if(flag) {
                if(expression[i] >= '0' && expression[i] <= '9') {
                    q.offer(expression[i]);
                }else if(expression[i] == '+') {
                    if(temp == '+'){
                        int size = q.size();
                        while(!q.isEmpty()) {
                            int num = q.poll() - '0';
                            answer += Math.pow(10, size-1)*num;
                            size--;
                        }
                    }else if(temp == '-'){
                        int size = q.size();
                        while(!q.isEmpty()) {
                            int num = q.poll() - '0';
                            answer -= Math.pow(10, size-1)*num;
                            size--;
                        }
                    }
                    temp = '+';
                }else if(expression[i] == '-'){
                    if(temp == '+'){
                        int size = q.size();
                        while(!q.isEmpty()) {
                            int num = q.poll() - '0';
                            answer += Math.pow(10, size-1)*num;
                            size--;
                        }
                    }else if(temp == '-'){
                        int size = q.size();
                        while(!q.isEmpty()) {
                            int num = q.poll() - '0';
                            answer -= Math.pow(10, size-1)*num;
                            size--;
                        }
                    }
                    temp = '-';
                }
            }
        }
        System.out.println(answer);
    }
}