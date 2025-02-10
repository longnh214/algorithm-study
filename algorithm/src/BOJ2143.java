/**
 * @author nakhoonchoi
 * @date 2025/02/10
 * @see https://boj.ma/2143
 * @mem 101,496kb
 * @time 492ms
 * @caution
 * [고려사항]
 * 주의할 점은 부 배열이 연속된 인덱스의 합만 부 배열의 합으로 인정된다는 것이다.
 * 그래서 입력받은 배열을 정렬하면 안됐다.
 * 먼저 2중 for문으로 A와 B에 대한 부 배열의 합을 구해서 해시맵에 count를 저장해주었다.
 * 여기에서 또 주의할 점은 수의 count가 int형을 벗어날 수 있다는 점이었다.
 * 이 점을 고려해서 map의 값 자료형을 Long으로, answer의 자료형도 Long으로 하면 문제가 해결된다.
 *
 * 이 부분을 계산하기 어려웠던 것 같다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <해시맵> '두 배열의 합'

public class BOJ2143 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Map<Integer, Long> aCountMap = new HashMap<>();
        Map<Integer, Long> bCountMap = new HashMap<>();
        long answer = 0;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int [] A = new int[n];

        for(int i=0;i<n;i++){
            A[i] = Integer.parseInt(st.nextToken());
            aCountMap.put(A[i], aCountMap.getOrDefault(A[i], 0L) + 1);
        }

        for(int i=0;i<n-1;i++){
            int sum = A[i];
            for(int j=i+1;j<n;j++){
                sum += A[j];
                aCountMap.put(sum, aCountMap.getOrDefault(sum, 0L) + 1);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] B = new int[m];

        for(int i=0;i<m;i++){
            B[i] = Integer.parseInt(st.nextToken());
            bCountMap.put(B[i], bCountMap.getOrDefault(B[i], 0L) + 1);
        }

        for(int i=0;i<m-1;i++){
            int sum = B[i];
            for(int j=i+1;j<m;j++){
                sum += B[j];
                bCountMap.put(sum, bCountMap.getOrDefault(sum, 0L) + 1);
            }
        }

        for(int aKey : aCountMap.keySet()){
            answer += aCountMap.get(aKey) * bCountMap.getOrDefault(T - aKey, 0L);
        }

        System.out.println(answer);
    }
}