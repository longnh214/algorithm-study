/**
 * @author nakhoonchoi
 * @date 2025/05/15
 * @see https://boj.ma/11585
 * @mem 135,172kb
 * @time 524ms
 * @caution
 * [고려사항]
 * 해당 문제는 문자열 s 중 반복되는 부분 문자열 중 가장 긴 길이를 찾은 뒤에
 * 1/n을 출력하면 되는 문제였다.
 *
 * 복잡하게 생각해서 최대공약수 로직(GCD)이 필요한 줄 알았으나 필요가 없었다.
 *
 * ⚠️ 94%에서 WA를 받아서 문제 게시판을 참고해서 반례를 알 수 있었다.
 * 16
 * A B A B C A B C A B C A B C A B
 * A B C A B C A B C A B C A B A B
 *
 * ANSWER : 1/16
 *
 * WA : 1/14
 *
 * 💡 prefix == suffix 최장 문자열이 반복되는 문자열인지 확인할 필요가 있었다.
 * 분기처리해서 반복되지 않는다면 1/(문자열의 총 길이)를 출력했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <KMP> '속타는 저녁 메뉴'

public class BOJ11585 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char [] strArr = new char[N];
        char [] circle = new char[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            strArr[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            circle[i] = st.nextToken().charAt(0);
        }

        int [] pi = new int[N];
        int len = 0;

        for(int i=1;i<N;i++){
            while(len > 0 && strArr[i] != strArr[len]){
                len = pi[len - 1];
            }
            if(strArr[i] == strArr[len]){
                len++;
                pi[i] = len;
            }
        }

        if(N % (N - pi[N-1]) == 0) {
            System.out.println(1 + "/" + (N - pi[N - 1]));
        }else{
            System.out.println(1 + "/" + N);
        }
    }
}