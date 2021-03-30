/**
 * @author choi
 * @date Aug 28, 2020
 * @see https://www.acmicpc.net/problem/2531
 * @mem 19,164kb
 * @time 172ms
 * @caution
 * [고려사항]
 * 선형으로 문제를 해결하기 위해 슬라이드 윈도우(투 포인터) 알고리즘을
 * 구글링을 통해 참고하여 문제를 해결했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <투 포인터> '회전 초밥'
public class BOJ2531 {
    static int N,d,k,c,answer;
    static int [] sushi;
    static int [] visited;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        sushi = new int[N];
        visited = new int[d+1];
        q = new LinkedList<Integer>();
        for(int i=0;i<N;i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        solve();
        System.out.println(answer);
    }

    public static void solve() {
        int count = 0;
        int temp;
        for(int i=0;i<k;i++) {
            if(visited[sushi[i]] == 0) {
                count++;
            }
            visited[sushi[i]]++;
            q.offer(sushi[i]);
        }
        //혹시 모를 쿠폰 체크
        if(visited[c] == 0) {
            answer = count + 1;
        }else {
            answer = count;
        }
        for(int i=k;i<N+k;i++) {
            //위 부분이나 전 for문에서 연산된 count를 가지고 연산.
            int tempCount = count;
            //큐 맨 앞 값을 확인해서 visited--;
            visited[q.peek()]--;
            //빠지고 없다면 count를 줄인다.
            if(visited[q.peek()] == 0)
                tempCount--;
            q.poll();

            //큐에 다음 값을 넣어줄 때
            //배열의 크기가 오버할 수 있으므로 인덱스에 i%N을 넣는다.
            temp = sushi[i%N];
            q.offer(temp);
            //큐에 넣은 값이 기존 윈도우에 없는 값일 경우 tempCount++
            if(visited[temp]==0)
                tempCount++;
            //개수도 ++
            visited[temp]++;
            //쿠폰을 사용할 수 있다면 tempCount+1의 값으로 비교.
            if(visited[c] == 0) {
                answer = Math.max(tempCount+1, answer);
            }else {
                answer = Math.max(tempCount, answer);
            }
            //다음 for문에서 큐의 내용이 바로 바뀌는 것이 아니므로
            //tempCount도 변하지 않기 때문에 다음 for문에 전달해주어야 한다.
            count = tempCount;
        }
    }
}