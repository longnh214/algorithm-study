/**
 * @author nakhoonchoi
 * @date 2025/07/14
 * @see https://boj.m1/3078
 * @mem 42,152kb
 * @time 304ms
 * @caution
 * [고려사항]
 * 어떤 알고리즘을 써서 문제를 해결했다기 보다는 '큐'라는 자료구조를 이용해서 문제를 해결했다.
 *
 * 일단 좋은 친구란 같은 길이의 이름이면서, 두 친구의 성적 등수 차이가 K 이하 여야 한다.
 *
 * 각 문자열의 길이 별로 인덱스를 담을 큐를 만들고, 큐가 비어있다면 현재 인덱스를 큐에 담았다.
 * 큐에 값이 이미 있다면 큐의 맨 앞 값이 성적 등수 차이에 유효한 값인지 확인 뒤에 유효한 값이 되도록 pop을 하고
 * answer에 큐의 현재 크기 만큼 더해주었다.
 *
 * ⚠️ N이 최대 30만이기 때문에 쌍의 갯수가 int 형을 벗어날 수 있다는 점이 주의할 점이었다.
 *
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <큐> '좋은 친구'

public class BOJ3078 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> [] lengthQueue = new Queue[21];

        for(int i=0;i<lengthQueue.length;i++){
            lengthQueue[i] = new ArrayDeque<>();
        }

        long answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            int len = br.readLine().length();

            while(!lengthQueue[len].isEmpty() && lengthQueue[len].peek() < i-K){
                lengthQueue[len].poll();
            }
            answer += lengthQueue[len].size();

            lengthQueue[len].offer(i);
        }

        System.out.println(answer);
    }
}