/**
 * @author nakhoonchoi
 * @date 2024/08/04
 * @see https://www.acmicpc.net/problem/13701
 * @mem 356,128kb
 * @time 1,136ms
 * @caution
 * [고려사항]
 * 타 기업 코딩 테스트를 통해 BitSet으로
 * 비트 계산을 할 수 있는 방법을 찾아서 많은 양의 데이터 존재 유무를 저장할 때
 * 비트를 이용하는 방법을 테스트 하였다. Set 대신 BitSet,,, 기억해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <비트마스킹> '중복 제거'

public class BOJ13701 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BitSet bitSet = new BitSet();

        while(st.hasMoreTokens()){
            int target = Integer.parseInt(st.nextToken());
            if(!bitSet.get(target)){
                bitSet.set(target);
                bw.write(target + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}