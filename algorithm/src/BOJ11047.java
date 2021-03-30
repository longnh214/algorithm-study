import java.io.*;
import java.util.*;
//백준 11047번 <그리디 알고리즘> - '동전 0'
public class BOJ11047 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCount = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int [] coinUnit = new int[N];
        for(int i=0;i<N;i++)
            coinUnit[i] = Integer.parseInt(br.readLine());
        for(int i=N-1;i>=0;i--){
            if(K >= coinUnit[i]){
                int count = (K / coinUnit[i]);
                totalCount += count;
                K -= (count * coinUnit[i]);
            }
        }

        System.out.println(totalCount);
    }
}