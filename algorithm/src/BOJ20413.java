/**
 * @author nakhoonchoi
 * @date 2024/07/17
 * @see https://www.acmicpc.net/problem/20413
 * @mem 11,588kb
 * @time 68ms
 * @caution
 * [고려사항]
 * 현재 과금 액과 지난 달 과금액의 합이 등급 기준보다 -1이 되도록 최대를 맞춰서 계산해주었다.
 * 한 번 달성한 등급은 떨어지지 않으므로, 다음 등급으로 올라가기 위한 마지노선 (다음 등급 기준 - 1)을 맞춰주었고,
 * 마지막 D등급 기준이 한 달 최대 과금액이므로 D등급일 때에는 무조건 한 달 최대 과금액을 결제했다고 가정해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <그리디> 'MVP 다이아몬드 (Easy)'

public class BOJ20413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N+1];
        int [] mvpLevelStandard = new int[5];
        char [] mvpLevel;

        Map<Character, Integer> mvpLevelMap = new HashMap<>();
        mvpLevelMap.put('B', 0);
        mvpLevelMap.put('S', 1);
        mvpLevelMap.put('G', 2);
        mvpLevelMap.put('P', 3);
        mvpLevelMap.put('D', 4);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<4;i++){
            int standard = Integer.parseInt(st.nextToken());
            mvpLevelStandard[i] = standard - 1;
            mvpLevelStandard[i+1] = standard;
        }

        mvpLevel = br.readLine().toCharArray();
        for(int i=0;i<N;i++){
            char level = mvpLevel[i];

            if(level == 'D'){
                arr[i+1] = mvpLevelStandard[mvpLevelMap.get(level)];
            }else{
                arr[i+1] = mvpLevelStandard[mvpLevelMap.get(level)] - arr[i];
            }
        }

        int sum = 0;
        for(int i=1;i<=N;i++){
            sum += arr[i];
        }
        System.out.println(sum);
    }
}