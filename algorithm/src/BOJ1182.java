/**
 * @author nakhoonchoi
 * @date 2024/07/31
 * @see https://www.acmicpc.net/problem/1182
 * @mem 11,916kb
 * @time 168ms
 * @caution
 * [고려사항]
 * 조합을 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <조합> '부분수열의 합'

public class BOJ1182 {
    static int [] arr;
    static int [] temp;
    static int N, S, result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        temp = new int[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<=N;i++){
            comb(0, i, 0);
        }
        System.out.println(result);
    }

    public static void comb(int start, int maxCount, int count){
        if(count == maxCount){
            int sum = 0;
            for(int i=0;i<maxCount;i++){
                sum += temp[i];
            }
            if(sum == S){
                result++;
            }
            return;
        }

        for(int i=start;i<N;i++){
            temp[count] = arr[i];
            comb(i + 1, maxCount, count + 1);
        }
    }
}
