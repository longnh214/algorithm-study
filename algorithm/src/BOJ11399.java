import java.util.*;
import java.io.*;
//백준 11399번 <그리디 알고리즘> - 'ATM'
public class BOJ11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] person = new int[N];
        int [] time = new int[N];
        int totalTime = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)
            person[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(person);
        for(int i=0;i<N;i++){
            int temp = 0;
            for(int j=0;j<=i;j++){
                temp += person[j];
            }
            time[i] = temp;
        }
        for(int i : time)
            totalTime += i;
        System.out.println(totalTime);
    }
}