/**
 * @author nakhoonchoi
 * @date 2025/05/21
 * @see https://boj.ma/1097
 * @mem 176,276kb
 * @time 684ms
 * @caution
 * [고려사항]
 * 문제 자체가 처음에는 이해되지 않았다.
 * N개의 문자열 각각 LPS를 해서 K와 count를 비교해야하는 문제인 줄 헷갈렸다.
 * 
 * 중복 없는 조합을 이용해서 N개의 문자열을 순서대로 합친 T를 만들고 그 뒤에 순환 문자열을 기반으로 마법의 문자열인지 구해야했다.
 *
 * 요약하면 LPS를 이용해서 문제를 해결할 수 있었다.
 * BOJ 12104번 문제 때의 힌트를 얻어 문자열 T를 연속으로 이어붙여서(T+T) 순환 문자열을 만들고, T+T에 대한 LPS를 구했다.
 * T+T 순환 문자열의 LPS len이 K와 같아지는 시점의 count만 세면 되는 간단한 문제인 줄 알았는데
 * 문자열 T의 주기가 고려되어야 했다.
 *
 * 그래서 T 자체가 반복되는 문자열인지 판별해서 순환의 길이를 구하고, T의 길이가 n이고, 주기가 A고, T+T의 길이가 2*n이라고 했을 때
 * LPS len이 if(len >= n && (len - n) % A == 0)으로 len이 n보다 길면서, 
 * len에서 n을 뺐을 때 A에 대한 나머지가 0이라면 (= 주기만큼 한 번 더 연장되어서 T와 접미사 길이가 같아지는 경우)
 * strCount를 추가해주었다.
 * 
 * 조합의 결과 문자열 T에 대한 strCount가 K와 정확히 같은 마법의 문자열이라면 static count(A.K.A answer)를 1씩 더해주어
 * 최종으로 count를 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <KMP> '마법의 문자열'

public class BOJ1097 {
    static int [] temp;
    static int N, count, K;
    static String [] arr;
    static boolean [] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = 0;

        arr = new String[N];
        temp = new int[N];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            arr[i] = br.readLine();
        }

        K = Integer.parseInt(br.readLine());

        comb(0);

        System.out.println(count);
    }

    static void comb(int index){
        if(index == N){
            if(isMagicString()){
                count++;
            }
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]) {
                visited[i] = true;
                temp[index] = i;
                comb(index + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isMagicString(){
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<N;i++){
            sb.append(arr[temp[i]]);
        }

        int originLength = sb.length();
        int period = getPeriod(sb.toString());

        sb.append(sb);

        int strCount = getCount(sb.toString(), originLength, period);

        return K == strCount;
    }

    static int getPeriod(String str){
        int [] pi = getPi(str);
        int n = str.length();

        if(n % (n - pi[n-1]) == 0){
            return n - pi[n-1];
        }
        return n;
    }

    static int [] getPi(String str){
        int n = str.length();
        int [] pi = new int[n];
        int len = 0;
        int strCount = 0;

        for(int i=1;i<n;i++){
            while(len > 0 && str.charAt(len) != str.charAt(i)){
                len = pi[len - 1];
            }

            if(str.charAt(len) == str.charAt(i)){
                len++;
                pi[i] = len;
            }
        }

        return pi;
    }

    static int getCount(String str, int originLength, int period){
        int n = str.length();
        int [] pi = new int[n];
        int len = 0;
        int strCount = 0;

        for(int i=1;i<n;i++){
            while(len > 0 && str.charAt(len) != str.charAt(i)){
                len = pi[len - 1];
            }

            if(str.charAt(len) == str.charAt(i)){
                len++;
                pi[i] = len;
                if(len >= originLength && (len - originLength) % period == 0){
                    strCount++;
                }
            }
        }

        return strCount;
    }
}