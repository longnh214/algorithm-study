/**
 * @author nakhoon
 * @date 2022, 4월 16일
 * @see https://www.acmicpc.net/problem/1105
 * @mem 11,516kb
 * @time 80ms
 * @caution
 * [고려사항]
 * L과 R의 자리가 다르다면 무조건 0을 출력해야한다. (3 200) 이라고 했을 때 8이 안들어갈 수가 무조건 있기 때문에
 * 같다면 그 사이 모든 수의 8의 개수를 찾을 필요는 없고 가장 높은 자리 수 부터 다른 숫자가 나올 때까지 8의 개수가 몇 개 있는 지로 판별하면 되는 문제이다.
 * 모든 숫자의 8의 개수 중 최소를 찾으려다가 시간 초과가 발생했던 문제이다.
 * [입력사항]
 * [출력사항]
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 <그리디> '팔'
public class BOJ1105 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();
        int count = 0;
        if(L.length() == R.length()) {
            for(int i = 0; i < L.length(); i++) {
                if(L.charAt(i) == R.charAt(i) && R.charAt(i) == '8') {
                    count++;
                }
                else if(L.charAt(i) != R.charAt(i)) {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}