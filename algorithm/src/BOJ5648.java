/**
 * @author nakhoonchoi
 * @date 2024/07/21
 * @see https://www.acmicpc.net/problem/5648
 * @mem 18,268kb
 * @time 368ms
 * @caution
 * [고려사항]
 * 입력 방식이 특이했던 문제이다.
 * 줄마다 숫자가 몇 개 씩 들어올 지 모르기 때문에 StringTokenizer의 hasMoreTokens()를 이용해서
 * 숫자를 읽어와야했고, StringBuilder의 reverse 함수를 통해 간편히 문자열을 역순해서 숫자를 정렬할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <정렬> '역원소 정렬'

public class BOJ5648 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String str;

        int N = Integer.parseInt(st.nextToken());
        long [] arr = new long[N];
        while(N > 0){
            while(st.hasMoreTokens()){
                str = st.nextToken();
                StringBuilder sb = new StringBuilder(str);
                arr[--N] = Long.parseLong(sb.reverse().toString());
            }
            if(N > 0) {
                st = new StringTokenizer(br.readLine());
            }
        }
        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}