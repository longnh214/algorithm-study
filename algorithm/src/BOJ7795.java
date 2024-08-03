/**
 * @author nakhoonchoi
 * @date 2024/08/03
 * @see https://www.acmicpc.net/problem/7795
 * @mem 39,488kb
 * @time 364ms
 * @caution
 * [고려사항]
 * 투 포인터를 이용해서 조건에 맞는 경우 result에 경우의 수를 더해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <투 포인터> '먹을 것인가 먹힐 것인가'

public class BOJ7795 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int A, B;
        int [] arrA, arrB;
        while(T-->0){
            int result = 0;
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            arrA = new int[A];
            arrB = new int[B];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<A;i++){
                arrA[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<B;i++){
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int indexA = 0;
            int indexB = 0;
            while(true){
                if(indexA == A || indexB == B) break;
                if(arrA[indexA] > arrB[indexB]){
                    result += (A - indexA);
                    indexB++;
                }else{
                    indexA++;
                }
            }
            System.out.println(result);
        }
    }
}