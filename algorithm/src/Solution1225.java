/**
 * @author choi
 * @date Jul 30, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14uWl6AF0CFAYD
 * @mem 27,312 kb
 * @time 178 ms
 * @caution
 * [고려사항] 큐에 넣어줄 수를 0으로 초기화한다는 점. 큐의 contains 함수를 이용해서 0이 포함되면 반복문을 끝나게 할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//SW expert <D3> '암호 생성기'
public class Solution1225 {
    static Queue<Integer> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        String line = null;
        while((line = br.readLine() )!= null) {
            int count = 1;
            int T = Integer.parseInt(line);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<8;i++)
                q.offer(Integer.parseInt(st.nextToken()));
            while(!q.contains(0)) {
                int temp = q.poll() - count;
                //count를 뺀 값이 음수가 되면 넣을 값을 0으로 만들어준다.
                if(temp < 0) temp = 0;
                q.offer(temp);
                count++;
                //한 사이클을 돌았다.
                if(count > 5) count = 1;
            }
            System.out.printf("#%d ",T);
            while(!q.isEmpty()) {
                System.out.printf("%d ",q.poll());
            }
            System.out.println();
        }
    }
}