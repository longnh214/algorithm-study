/**
 * @author nakhoonchoi
 * @date 2024/09/26
 * @see https://www.acmicpc.net/problem/17140
 * @mem 23,120kb
 * @time 304ms
 * @caution
 * [고려사항]
 * 정렬하는 기준을 위해 외부에 count를 계산하는 CountMap을 선언하였고,
 * treeMap을 새로 선언해서 countMap을 기준으로 key들을 정렬해서 값을 옮겨주었는데,
 * treeMap이 아니라 list를 이용해서 countMap의 key들을 정렬하고 키와 값을 순차적으로 배열에 입력시켜주었다.
 *
 * 주의 사항은 배열을 0으로 초기화하는 타이밍과 행, 열의 크기 갱신 시점을 정확하게 지정해줘야한다는 점이다.
 *
 * 정렬 시에 람다식으로 변경했을 때 소요 시간이 살짝 증가하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '이차원 배열과 연산'

public class BOJ17140 {
    static int [][] map = new int[101][101];
    static int rLen, cLen;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int T = 0;
        rLen = 3;
        cLen = 3;
        while(T < 101){
            if(map[r-1][c-1] == k){
                System.out.println(T);
                return;
            }

            if(rLen >= cLen){
                //R연산
                rCommand();
            }else {
                //C연산
                cCommand();
            }
            T++;
        }

        System.out.println(-1);
    }

    public static void rCommand(){
        int maxLen = 3;
        for(int i=0;i<rLen;i++){
            HashMap<Integer, Integer> countMap = new HashMap<>();
            TreeMap<Integer, Integer> orderedCountMap = new TreeMap<>((o1, o2) -> {
                int value1 = countMap.get(o1);
                int value2 = countMap.get(o2);
                if(value1 == value2) {
                    return Integer.compare(o1, o2);
                }else{
                    return Integer.compare(value1, value2);
                }
            });
            for(int j=0;j<cLen;j++){
                if(map[i][j] == 0) continue;
                countMap.put(map[i][j], countMap.getOrDefault(map[i][j], 0) + 1);
            }

            for(int key : countMap.keySet()){
                orderedCountMap.put(key, countMap.get(key));
            }

            Arrays.fill(map[i], 0);
            int j = 0;
            for(int key : orderedCountMap.keySet()){
                map[i][j++] = key;
                if(j >= 100) break;
                map[i][j++] = orderedCountMap.get(key);
                if(j >= 100) break;
            }
            maxLen = Math.max(maxLen, j);
        }
        cLen = maxLen;
    }

    public static void cCommand(){
        int maxLen = 3;
        for(int i=0;i<cLen;i++){
            HashMap<Integer, Integer> countMap = new HashMap<>();
            TreeMap<Integer, Integer> orderedCountMap = new TreeMap<>((o1, o2) -> {
                int value1 = countMap.get(o1);
                int value2 = countMap.get(o2);
                if(value1 == value2) {
                    return Integer.compare(o1, o2);
                }else{
                    return Integer.compare(value1, value2);
                }
            });
            for(int j=0;j<rLen;j++){
                if(map[j][i] == 0) continue;
                countMap.put(map[j][i], countMap.getOrDefault(map[j][i], 0) + 1);
            }

            for(int key : countMap.keySet()){
                orderedCountMap.put(key, countMap.get(key));
            }

            for(int j=0;j<100;j++){
                map[j][i] = 0;
            }
            int j = 0;
            for(int key : orderedCountMap.keySet()){
                map[j++][i] = key;
                if(j >= 100) break;
                map[j++][i] = orderedCountMap.get(key);
                if(j >= 100) break;
            }
            maxLen = Math.max(maxLen, j);
        }
        rLen = maxLen;
    }
}