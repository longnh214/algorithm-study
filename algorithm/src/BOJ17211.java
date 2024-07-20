/**
 * @author nakhoonchoi
 * @date 2024/07/20
 * @see https://www.acmicpc.net/problem/17211
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 문제 예시에서 보였듯이, '1 - 좋은 날일 확률 = 싫은 날일 확률' 이기 때문에
 * N일 뒤에 좋은 날일 확률을 구하면, 그 뒤에 '1 - N일 뒤에 좋은 날일 확률 = N일 뒤에 싫은 날일 확률'이 된다.
 * '좋은 날일 확률 * 다음 날도 좋은 날일 확률 + 싫은 날일 확률 * 다음 날도 좋은 날일 확률'
 * 점화식을 이용해서 확률을 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <확률> '좋은 날 싫은 날'

public class BOJ17211 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double curState = Integer.parseInt(st.nextToken());
        double [][] stateRate = new double[2][2];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                stateRate[i][j] = Double.parseDouble(st.nextToken());
            }
        }
        curState = (1 - curState) * 1000;

        for(int i=0;i<N;i++){
            curState = curState * stateRate[0][0] + (1000 - curState) * stateRate[1][0];
        }

        System.out.println(String.format("%.0f", curState));
        System.out.println(String.format("%.0f", 1000 - curState));
    }
}