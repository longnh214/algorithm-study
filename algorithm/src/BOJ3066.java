/**
 * @author nakhoonchoi
 * @date 2025/06/30
 * @see https://boj.ma/3066
 * @mem 28,928kb
 * @time 244ms
 * @caution
 * [고려사항]
 * 일반적인 LIS (O(NlogN)) 기반 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <LIS(O(NlogN))> '브리징 시그널'

public class BOJ3066 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            int [] arr = new int[N];

            for(int i=0;i<N;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }

            int [] lastMinValueArr = new int[N];
            int lisLength = 0;

            for(int num : arr){
                int index = Arrays.binarySearch(lastMinValueArr, 0, lisLength, num);

                if(index < 0){
                    index = (index + 1) * -1;
                }

                lastMinValueArr[index] = num;

                if(index == lisLength){
                    lisLength++;
                }
            }

            sb.append(lisLength).append('\n');
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }
}