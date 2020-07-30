/**
 * @author choi
 * @date 2020. 7. 29
 * @see https://www.acmicpc.net/problem/2309
 * @mem 13,000kb
 * @time 80ms
 * @caution
 * [고려사항] 이미 한번 출력 됐으면 끝내는 boolean 변수 하나도 생각했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 2309번 <브루트포스> - '일곱 난장이'
public class BOJ2309 {
    static int [] little;
    static int [] arr;
    //출력이 되었는지.
    static boolean check;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        little = new int[9];
        arr = new int[7];
        for(int i=0;i<little.length;i++) {
            little[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(little);

        comb(0,0);

//        for(int i=0;i<little.length;i++) {
//            System.out.println(little[i]);
//        }
    }

    public static void comb(int start, int cnt) {
        if(check) return;
        else if(cnt == 7) {
            int sum = 0;
            for(int i=0;i<arr.length;i++) {
                sum+=little[arr[i]];
            }
            if(sum == 100) {
                check = true;
                for(int i : arr)
                    System.out.println(little[i]);
            }
            return;
        }
        for(int i=start;i<9;i++) {
            arr[cnt] = i;
            comb(i+1,cnt+1);
        }
    }
}