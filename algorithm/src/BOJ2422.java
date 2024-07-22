/**
 * @author nakhoonchoi
 * @date 2024/07/22
 * @see https://www.acmicpc.net/problem/2422
 * @mem 50,904kb
 * @time 560ms
 * @caution
 * [고려사항]
 * 해시맵에 섞이면 안되는 조합을 저장하고,
 * 조합을 구현해서 문제를 해결하였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <조합> '한윤정이 이탈리아에 가서 아이스크림을 사먹는데'

public class BOJ2422 {
    static int answer, N, M;
    static int [] temp = new int[3];
    static Map<Integer, List<Integer>> notMixMap = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int min = Math.min(a, b);
            int max = Math.max(a, b);

            List<Integer> list = notMixMap.getOrDefault(min, new ArrayList<>());
            list.add(max);

            notMixMap.put(min, list);
        }

        comb(0, 0);

        System.out.println(answer);
    }

    public static void comb(int start, int count){
        if(count == 3){
            for(int i=0;i<2;i++){
                for(int j=i+1;j<3;j++){
                    if(notMixMap.containsKey(temp[i]) && notMixMap.get(temp[i]).contains(temp[j])){
                        return;
                    }
                }
            }
            answer++;
            return;
        }

        for(int i=start+1;i<=N;i++){
            temp[count] = i;
            comb(i, count+1);
        }
    }
}