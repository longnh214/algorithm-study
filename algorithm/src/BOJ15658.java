/**
 * @author nakhoonchoi
 * @date 2024/06/21
 * @see https://www.acmicpc.net/problem/15658
 * @mem 18,980kb
 * @time 196ms
 * @caution
 * [고려사항]
 * 백트래킹 문제를 오랜만에 풀어보았다.
 * 모든 조합을 생각해보려했지만, 연산자의 조합을 구한 뒤 숫자와 결합해서 값을 구하면 중복된 계산을 최대한 피할 수 있었다.
 * 백트래킹 문제를 많이 풀어봐야겠다...
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <백트래킹> '연산자 끼워넣기(2)'
public class BOJ15658 {
    static char [] opers = {'+', '-', '*', '/'};
    static int [] operCountArr;

    static char [] temp;

    static int max, min, N;

    static int [] arr;

    static boolean [] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        temp = new char[N-1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        operCountArr = new int[opers.length];
        for(int i=0;i<opers.length;i++){
            operCountArr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int count){
        if(count == N-1){
            int sum = arr[0];
            for(int i=1;i<arr.length;i++){
                switch(temp[i-1]){
                    case '+':
                        sum += arr[i];
                        break;
                    case '-':
                        sum -= arr[i];
                        break;
                    case '*':
                        sum *= arr[i];
                        break;
                    case '/':
                        sum /= arr[i];
                        break;
                }
            }

            min = Math.min(min, sum);
            max = Math.max(max, sum);

            return;
        }

        if(operCountArr[0] > 0){
            operCountArr[0]--;
            temp[count] = opers[0];
            dfs(count+1);
            operCountArr[0]++;
        }

        if(operCountArr[1] > 0){
            operCountArr[1]--;
            temp[count] = opers[1];
            dfs(count+1);
            operCountArr[1]++;
        }

        if(operCountArr[2] > 0){
            operCountArr[2]--;
            temp[count] = opers[2];
            dfs(count+1);
            operCountArr[2]++;
        }

        if(operCountArr[3] > 0){
            operCountArr[3]--;
            temp[count] = opers[3];
            dfs(count+1);
            operCountArr[3]++;
        }
    }
}