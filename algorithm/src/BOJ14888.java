/**
 * @author choi
 * @date Aug 30, 2020
 * @see https://www.acmicpc.net/problem/14888
 * @mem 14,632kb
 * @time 552ms
 * @caution
 * [고려사항]
 * 연산자 우선 순위를 적용하지 않고 문제를 풀 수 있으므로 생각보다 어려운 문제는 아니였다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <브루트포스> '연산자 끼워넣기'
public class BOJ14888 {
    //연산자
    static int [] operator;
    //피연산자.
    static int [] operand;
    static int N,max,min;
    static int [] temp;
    static boolean [] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        operand = new int[N];
        operator = new int[N-1];
        temp = new int[N-1];
        visited = new boolean[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            operand[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        int k=0;
        for(int i=0;i<4;i++) {
            int cnt = Integer.parseInt(st.nextToken());
            for(int j=0;j<cnt;j++) {
                operator[k++] = i;
            }
        }

        permutation(0);
        //System.out.println(Arrays.toString(operator));
        System.out.println(max);
        System.out.println(min);
    }

    public static void permutation(int cnt) {
        if(cnt == N-1) {
            int result = operand[0];
            for(int i=0;i<N-1;i++) {
                switch(temp[i]) {
                    case 0 :
                        result += operand[i+1];
                        break;
                    case 1 :
                        result -= operand[i+1];
                        break;
                    case 2 :
                        result *= operand[i+1];
                        break;
                    case 3 :
                        result /= operand[i+1];
                        break;
                }
            }
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for(int i=0;i<N-1;i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp[cnt] = operator[i];
                permutation(cnt+1);
                visited[i]=false;
            }
        }
    }
}