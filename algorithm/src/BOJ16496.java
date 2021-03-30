/**
 * @author choi
 * @date Jan 2, 2021
 * @see https://www.acmicpc.net/problem/16496
 * @mem 19,992kb
 * @time 112ms
 * @caution
 * [고려사항]
 * o1+o2와 o2+o1을 비교하여 둘 중 큰 문자열을 앞으로 보내야 하는 문제이다.
 * 문자열을 숫자로 변환해서 비교하면 길이가 너무 길어져버려 Long 타입으로도 cover할 수 없는 길이의 숫자가 나올 수 있기 때문에
 * String의 compareTo 함수를 사용하여 문자열 비교를 해야한다.
 * 0을 제외한 나머지 수는 0으로 시작하지 않으며, 0이 주어지는 경우 0 하나가 주어진다.
 * 0이 정답인 경우 0 하나를 출력해야 한다.
 * 위 두 문장을 읽지 못하고 문제를 제출하여 계속 94%에서 틀렸습니다를 받았다... 문제를 잘 읽어야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <정렬> '큰 수 만들기'
public class BOJ16496 {
    static int N;
    static String [] str;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            str[i] = st.nextToken();
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder sb1 = new StringBuilder(o1+o2);
                StringBuilder sb2 = new StringBuilder(o2+o1);

                return sb1.toString().compareTo(sb2.toString()) * -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : str) {
            sb.append(s);
        }

        if (sb.length() > 1 && sb.charAt(0) == '0') {
            sb = new StringBuilder("0");
        }
        System.out.println(sb.toString());
    }
}