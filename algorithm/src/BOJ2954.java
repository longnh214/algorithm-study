/**
 * @author choi
 * @date Aug 10, 2020
 * @see https://www.acmicpc.net/problem/2954
 * @mem 12,812kb
 * @time 76ms
 * @caution
 * [고려사항] 모음을 만날 때마다 문자를 두 칸 건너 뛰면 해결할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <구현> - '창영이의 일기장'
public class BOJ2954{
    public static void main(String[] args) throws IOException{
        //입력 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력 받을 문자열 처리.
        String str = br.readLine();
        //출력하기 위한 StringBuilder
        StringBuilder sb = new StringBuilder();for(int i=0;i<str.length();i++) {
            //문자 한개가 모음(a,e,i,o,u)이라면.
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                //sb객체에 append한다.
                sb.append(str.charAt(i));
                //문자 두개를 건너 뛴다.(암호를 위한 문자들이므로.)
                i+=2;
            }else {
                //위 모음에 해당이 안된다면 sb객체에 append하고 끝.
                sb.append(str.charAt(i));
            }
        }

        //결과값 출력.
        System.out.println(sb);
    }
}