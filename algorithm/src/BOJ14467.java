/**
 * @author nakhoonchoi
 * @date 2024/07/12
 * @see https://www.acmicpc.net/problem/14467
 * @mem 11,592kb
 * @time 68ms
 * @caution
 * [고려사항]
 * Map을 이용해서 위치를 저장해두고, 몇 번 길을 건넜는 지 체크했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '소가 길을 건너간 이유 1'
public class BOJ14467 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, Integer> pointMap = new HashMap<>();
        int count = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            if(!pointMap.containsKey(number)){
                pointMap.put(number, point);
            }else{
                int curPoint = pointMap.get(number);

                if(curPoint != point){
                    count++;
                    pointMap.put(number, point);
                }
            }
        }

        System.out.println(count);
    }
}