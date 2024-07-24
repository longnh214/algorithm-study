/**
 * @author nakhoonchoi
 * @date 2024/07/24
 * @see https://www.acmicpc.net/problem/5568
 * @mem 13,092kb
 * @time 112ms
 * @caution
 * [고려사항]
 * 순서가 고려되지 않아도 되는 집합이었고, 나 자신이 아닌 다른 숫자를 순서에 상관없이 앞 뒤에 붙일 수 있었다.
 * visited 배열을 통해 방문 했는 지 안했는 지를 고려해야했던 문제.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <조합> '카드 놓기'

public class BOJ5568 {
    static int N, M;
    static int [] temp;
    static int [] arr;
    static boolean [] visited;

    static Set<Long> set;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        set = new HashSet<>();

        arr = new int[N];
        temp = new int[M];
        visited = new boolean[N];

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        comb(0);

        System.out.println(set.size());
    }

    public static void comb(int count){
        if(count == M){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<M;i++){
                sb.append(temp[i]);
            }
            set.add(Long.parseLong(sb.toString()));
            return;
        }

        for(int i=0;i<N;i++){
            if(!visited[i]) {
                visited[i] = true;
                temp[count] = arr[i];
                comb(count + 1);
                visited[i] = false;
            }
        }
    }
}