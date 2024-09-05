/**
 * @author nakhoonchoi
 * @date 2024/09/05
 * @see https://www.acmicpc.net/problem/32200
 * @mem 18,004kb
 * @time 152ms
 * @caution
 * [고려사항]
 * 끼니의 최대값에서 힌트를 얻어 문제를 해결하였다.
 * X로 나눈 몫과 나머지, 그리고 Y-X를 이용해서 버리는 양을 구하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <수학> '항해'

public class BOJ32200 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int throwNum = 0;
        int count = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int sandwich = Integer.parseInt(st.nextToken());

            if(sandwich < X){
                throwNum += sandwich;
            }else{
                int gap = Y - X;
                int quotient = sandwich / X;
                int remainder = sandwich % X;

                count += quotient;

                if((remainder - (gap * quotient) > 0)){
                    throwNum += (remainder - (gap * quotient));
                }
            }
        }

        System.out.println(count);
        System.out.println(throwNum);
    }
}