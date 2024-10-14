/**
 * @author nakhoonchoi
 * @date 2024/10/14
 * @see https://www.acmicpc.net/problem/20159
 * @mem 23,016kb
 * @time 200ms
 * @caution
 * [고려사항]
 * 문제를 맨 처음에 보았을 때에는 각 경우의 수에 따라 완전 탐색을 해야하나...? 생각했는데
 * 누적합을 이용해서 문제를 해결할 수 있었다.
 *
 * 홀수/짝수 끼리의 누적합을 턴 별로 구해놓은 뒤,
 * 각 턴 별로 odd(정훈이가 지금까지 쌓아온 합) 과 even(밑장빼기를 한 뒤에 상대방의 합)을 해서 최대값을 갱신하고,
 * 상대 턴에 상대에게 밑장을 빼서 줄 수도 있는 경우의 수도 있기 때문에, 그렇게 되면
 * 밑장의 카드는 상대한테 갈 것이고, 그 이전의 짝수 합만 정훈이가 가져가게 된다.
 *
 * https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-20159-%EC%9E%90%EB%B0%94-%EB%8F%99%EC%9E%91-%EA%B7%B8%EB%A7%8C-%EB%B0%91%EC%9E%A5-%EB%B9%BC%EA%B8%B0%EB%83%90-BOJ-20159-JAVA
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
//백준 <누적 합> '동작 그만. 밑장 빼기냐?'

public class BOJ20159 {
    private static int N;
    private static int [] oddPrefixSum;
    private static int [] evenPrefixSum;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        oddPrefixSum = new int[N/2+1];
        evenPrefixSum = new int[N/2+1];

        for(int i=1;i<=N/2;i++){
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            oddPrefixSum[i] = oddPrefixSum[i-1] + first;
            evenPrefixSum[i] = evenPrefixSum[i-1] + second;
        }

        int answer = 0;
        int lastEvenCard = getEvenPrefixSumFrom(N/2 - 1);
        for(int i=0;i<=N/2;i++){
            int odd = oddPrefixSum[i];
            int even = getEvenPrefixSumFrom(i);
            if(i != 0){
                even = Math.max(even, getEvenPrefixSumFrom(i-1) - lastEvenCard);
            }

            int sum = odd + even;
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }

    public static int getEvenPrefixSumFrom(int from){
        return evenPrefixSum[N/2] - evenPrefixSum[from];
    }
}