/**
 * @author nakhoonchoi
 * @date 2024/07/15
 * @see https://www.acmicpc.net/problem/1212
 * @mem 31,668kb
 * @time 208ms
 * @caution
 * [고려사항]
 * 입력 문자열의 길이가 30만이 넘어가므로, 숫자 자료형으로 변환할 수가 없다.
 * 8진수는 2진수 세자리로 표현될 수 있기 때문에, 각 8진수의 값을 2진수로 바꿔준 뒤에
 * 맨 앞의 0을 제거하고 출력하면 AC를 받을 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
//백준 <수학> '8진수 2진수'

public class BOJ1212 {
    static String[] binaryArr = { "000", "001", "010", "011", "100", "101", "110", "111" };

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<input.length();i++){
            sb.append(binaryArr[input.charAt(i) - '0']);
        }

        if(input.equals("0")) {
            System.out.println(input);
        }else{
            while(sb.charAt(0) == '0') {
                sb = new StringBuilder(sb.substring(1));
            }
            System.out.println(sb);
        }
    }
}