/**
 * @author nakhoonchoi
 * @date 2025/07/18
 * @see https://boj.ma/1106
 * @mem 11,692kb
 * @time 68ms
 * @caution
 * [고려사항]
 * 오랜만에 풀었던 냅색 + DP 기반 문제였는데 다른 냅색 문제와 다른 점이 많아서 헷갈렸던 문제이다.
 *
 * 일반적인 냅색 문제는 정해진 무게 안에서 최대한의 가치를 뽑아내는 로직의 문제였다.
 *
 * 하지만 이 문제는 반대로 가치 제한 안에서 최소한으로 뽑아내야하는 무게(가치가 아니라 무게를 구해야하는 문제였다.)의 제한이 있었고,
 * 0-1 냅색과 다르게 물건을 여러 번 사용할 수 있다는 점이 달랐다.
 * 그리고 조건을 만족하는 최솟값의 무게를 반환해야하는 점도 차이가 있었다.
 * 그래서 문제에서 주어진 개념을 냅색의 개념으로 변환했을 때 아래와 같이 생각했다.
 * 아래에도 냅색 개념대로 표현할 것이다.
 *
 * 도시의 개수 = 배낭에 넣을 수 있는 물건의 종류
 * 홍보 = 배낭에 물건을 넣는 행위
 * 홍보할 때 내는 비용 = 배낭에 넣을 수 있는 제한 무게
 * 홍보를 통해서 유치한 고객 = 물건을 넣음으로써 얻는 가치
 *
 * 그래서 기본적으로 풀었던 냅색 문제처럼
 * dp 배열을 2차원 배열로 선언하고, dp[고려한 물건의 개수][가치] 라고 고려했다.
 *
 * 물건의 가치를 적어도 100 늘려야하면서 넣은 물건들의 무게의 최솟값을 구해야하므로 입력받은 C보다 100을 늘려서 배열의 범위를 정했다.
 * dp = new int[N+1][C+101]
 *
 * 그리고 최솟값을 구하는 것이기 때문에 dp[i][0]을 제외한 각 배열의 값은 모두 적당히 큰 수(987654321)로 초기화했다.
 * (⚠️ Integer.MAX_VALUE 근처로 초기화하면 최솟값의 가치를 더하는 과정에서 오버플로우가 발생하는 듯 했다.)
 *
 * 각 물건의 정보를 고려한 무게의 최솟값을 갱신하면서
 * 2중 for문에서 j가 현재 물건의 가치보다 낮다면 dp[i-1][j]를 그대로 가져오면 끝이고,
 * 같거나 크다면 Math.min(dp[i][j], dp[i][j - value[i - 1]] + weight[i - 1]);
 * 로 이전 가치의 최적값에서 현재 무게를 더한 값이 기존 최적값보다 작다면 갱신해주었다.
 *
 * 그리고 마지막으로 dp 배열 최적화를 끝내고 마지막 행에 대해
 * j가 C부터 C+100까지 가장 낮은 무게로 늘린 경우를 찾기 위해 min 연산을 따로 진행해주었다.
 *
 * 위에서도 말했지만 다른 냅색문제와 방향이 다르게 무게로 가치를 판단하는 것이 아니라
 * 가치로 무게를 판단해서 최솟값을 구해야하는 점이 헷갈렸고 어려웠던 것 같다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DP> '호텔'

public class BOJ1106 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int [][] dp = new int[N+1][C+101];
        int [] weight = new int[N];
        int [] value = new int[N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());

            Arrays.fill(dp[i], 987654321);
            dp[i][0] = 0;
        }

        for(int i=1;i<=N;i++){
            for(int j=0;j<=C+100;j++){
                dp[i][j] = dp[i-1][j];
                if(j >= value[i-1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - value[i-1]] + weight[i-1]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=C;i<=C+100;i++){
            result = Math.min(result, dp[N][i]);
        }

        System.out.println(result);
    }
}