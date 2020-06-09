import java.util.*;
import java.io.*;
//백준 2003번 <투포인터> - '수 들의 합 2'
public class BOJ2003 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;
        while(true){

            if(sum >= M)
                sum -= arr[start++];
            else if(end == N)
                break;
            else
                sum += arr[end++];
            if(sum == M)
                count++;
        }
        System.out.println(count);
    }
}