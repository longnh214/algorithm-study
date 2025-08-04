/**
 * @author nakhoonchoi
 * @date 2025/08/04
 * @see https://boj.ma/20440
 * @mem 387,776kb
 * @time 1,796ms
 * @caution
 * [고려사항]
 * 이전에 풀었던 이모스 법 문제에 좌표 압축 기법을 더한 문제이다.
 * 좌표 압축은 TreeMap과 index를 관리하는 배열 한 개로 해결했다.
 * TreeMap에는 압축할 인덱스와 이모스 법에 이용할 수, indexArr에는 TreeMap의 keySet의 순서대로 key 값을 담아주었다.
 *
 * 이전 모기의 수와 같은 값이 계속 연장된다면 end 값을 갱신해주어야하는데,
 * 이 end 값을 갱신하는 과정에서 모기의 수가 줄었다가 max 값과 같아지더라도 갱신하는 반례가 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <누적합> '🎵니가 싫어 싫어 너무 싫어 싫어 오지 마 내게 찝쩍대지마🎵 - 1'

public class BOJ20440 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, Integer> treeMap = new TreeMap<>();


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            treeMap.put(s, treeMap.getOrDefault(s, 0) + 1);
            treeMap.put(e, treeMap.getOrDefault(e, 0) - 1);
        }

        int [] indexArr = new int[treeMap.size()];
        int [] dp = new int[treeMap.size()];

        int start = 0;
        int end = 0;
        int mosquito = 0;
        int beforeMosquito = 0;

        int keySize = treeMap.size();

        int i = 0;
        for(int key : treeMap.keySet()){
            indexArr[i] = key;
            dp[i] = treeMap.get(key);
            i++;
        }

        for(i=1;i<keySize;i++){
            dp[i] += dp[i-1];
        }

        for(i=0;i<keySize-1;i++){
            if(dp[i] > mosquito){
                mosquito = dp[i];
                start = indexArr[i];
                end = indexArr[i+1];
            }else if(dp[i] == mosquito && mosquito == beforeMosquito){
                end = indexArr[i+1];
            }
            beforeMosquito = dp[i];
        }

        System.out.println(mosquito);
        System.out.println(start + " " + end);
    }
}