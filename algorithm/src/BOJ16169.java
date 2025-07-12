/**
 * @author nakhoonchoi
 * @date 2025/07/12
 * @see https://boj.ma/16169
 * @mem 11,872kb
 * @time 68ms
 * @caution
 * [고려사항]
 * 문제가 한 번에 이해가 되진 않았던 문제다.
 * 뭔가 위상 정렬 문제 같기도 했지만 Map과 DP를 이용해서 문제를 해결했다.
 *
 * 위상 정렬 문제처럼 컴퓨터마다 레벨이 있고, 동작 시간이 있어서 먼저 각 컴퓨터에 대한 정보를 입력 받았다.
 * 각 레벨 별 컴퓨터의 인덱스를 Map<Integer, List<Integer>>에 (level, level에 해당하는 인덱스 리스트) 형태로 담아주었다.
 *
 * 컴퓨터의 동작 흐름을 설명해보면,
 * 예를 들어 2레벨의 컴퓨터는 1레벨(이전 레벨)의 컴퓨터가 모두 동작이 완료된 뒤에 동작될 수 있다.
 * 전송 속도라는 개념이 있어서 i번 컴퓨터에서 j번 컴퓨터로 전송할 때에는 동작 속도 외에 별도로 (i-j)^2 만큼 소요된다고 한다.
 * 그리고 같은 레벨의 컴퓨터는 동기적으로 동작하는 게 아니라 동시에, 병렬로(⚠️) 동작하는 것이 주의할 점이다.
 *
 * 예제
 * 9
 * 1 1
 * 3 9
 * 3 1
 * 4 2
 * 4 2
 * 2 5
 * 1 30
 * 4 2
 * 5 3
 *
 * 동시에 병렬로 동작하는 점을 조금 더 자세히 설명하면,
 * 1레벨의 컴퓨터가 예제처럼 1,7번 컴퓨터, 2레벨의 컴퓨터가 예제처럼 6번 컴퓨터이고 속도도 예제와 똑같다면
 * 1 -> 6 = (1-6)^2 + 1 = (1부터 6 컴퓨터까지 가는 전송 속도 + 이전 레벨 1번 컴퓨터의 동작 시간) = 26
 * 7 -> 6 = (7-6)^2 + 30 = (7부터 6 컴퓨터까지 가는 전송 속도 + 이전 레벨 7번 컴퓨터의 동작 시간) = 31
 * 1레벨 컴퓨터들은 전부 동시, 병렬로 동작하기 때문에 1번과 7번 컴퓨터의 전송 속도와 동작 시간 합 중 최댓값인 31이 2레벨에 도달하기까지의 시간이다.
 *
 * 이 최댓값을 레벨 기준 dp에 메모이제이션 했어도 됐고, index 기반 dp에 메모이제이션 했어도 됐을 것 같다고 생각하는데,
 * 필자는 index 기반으로 dp를 설정해서 마지막 레벨에서 종료 시점까지 점화식을 한 번 더 계산해주는 방식으로 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <DP> '수행 시간'

public class BOJ16169{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] dp = new int[N];
        int [] speed = new int[N];

        Map<Integer, List<Integer>> levelMap = new TreeMap<>();
        StringTokenizer st;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());

            levelMap.putIfAbsent(level, new ArrayList<>());
            levelMap.get(level).add(i);

            speed[i] = Integer.parseInt(st.nextToken());
        }

        int maxLevel = 0;

        for(int level : levelMap.keySet()){
            maxLevel = Math.max(level, maxLevel);
            if(level == 1){
                continue;
            }
            for(int index : levelMap.get(level)){
                int dpMax = 0;
                for(int beforeIndex : levelMap.get(level - 1)) {
                    dpMax = Integer.max(dpMax, speed[beforeIndex] + (index - beforeIndex) * (index - beforeIndex) + dp[beforeIndex]);
                }
                dp[index] = dpMax;
            }
        }

        int answer = 0;

        for(int index : levelMap.get(maxLevel)){
            answer = Integer.max(answer, speed[index] + dp[index]);
        }

        System.out.println(answer);
    }
}