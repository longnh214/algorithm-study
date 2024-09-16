/**
 * @author nakhoonchoi
 * @date 2024/09/16
 * @see https://www.acmicpc.net/problem/7662
 * @mem 440,468kb
 * @time 2,480ms
 * @caution
 * [고려사항]
 * TreeMap의 firstKey, lastKey를 이용해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <자료구조> '이중 우선순위 큐'

public class BOJ7662_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            int N = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(command.equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else{
                    if(map.isEmpty()){
                        continue;
                    }

                    int key = num == 1 ? map.lastKey() : map.firstKey();
                    map.put(key, map.get(key) - 1);

                    if(map.get(key) == 0){
                        map.remove(key);
                    }
                }
            }

            System.out.println(map.isEmpty() ? "EMPTY" : map.lastKey() + " " + map.firstKey());
        }
    }
}