/**
 * @author nakhoonchoi
 * @date 2025/05/16
 * @see https://boj.ma/3779
 * @mem 36,392kb
 * @time 448ms
 * @caution
 * [고려사항]
 * N이 0일때까지 입력을 받을 수 있도록 while문을 작성했고,
 * 각 문자열 별로 pi 배열을 구해서 i를 1부터 N-1까지 순회하면서
 * 현재 문자열의 길이 (i+1) % (i + 1 - pi[i]) == 0이 되면서(접두사가 반복되는 형태인지)
 * (i+1) / (i + 1 - pi[i]) > 1인지(반복되는 횟수가 2번 이상인지) 확인해서 해당된다면
 * 현재 문자열의 길이와 반복 횟수를 개행하면서 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <KMP> '주기'

public class BOJ3779 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        int T = 1;
        StringBuilder sb = new StringBuilder();

        while((N = Integer.parseInt(br.readLine())) != 0){
            String str = br.readLine();
            int [] pi = getPi(str);

            sb.append("Test case #").append(T++).append('\n');

            for(int i=1;i<N;i++){
                if((i+1) % (i + 1 - pi[i]) == 0 && (i+1) / (i + 1 - pi[i]) > 1){
                    sb.append(i+1).append(' ').append((i+1) / (i + 1 - pi[i])).append('\n');
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static int [] getPi(String str){
        int n = str.length();
        int len = 0;
        int [] pi = new int[n];

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
}