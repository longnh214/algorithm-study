/**
 * @author choi
 * @date Aug 4, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15B1cKAKwCFAYD&categoryId=AV15B1cKAKwCFAYD&categoryType=CODE
 * @mem 20,836 kb
 * @time 109 ms
 * @caution
 * [고려사항] 노드를 방문할 때 visited 하느냐, 방문하고 빠져 나올 때 visited 하느냐에 따라 
 * 		결과값이 다르게 나올 수 있다는 것을 알았고, bfs를 이용해 최단 거리를 구하는 방법을 알 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//SW expert <D4> - 'Contact'
public class Solution1238 {
    static int answer, count, max, length = 100;
    static boolean [][] contact;
    static boolean [] visited;
    static int [] output;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t=1;t<=10;t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            //length = Integer.parseInt(st.nextToken());
            //버리는 숫자.
            st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            contact = new boolean[length+1][length+1];
            visited = new boolean[length+1];
            output = new int[length+1];
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                contact[first][second] = true;
            }
            max = Integer.MIN_VALUE;
            answer = -1;
            bfs(start);

            for(int i=length;i>=1;i--) {
                if(output[i] == max) {
                    answer = i;
                    break;
                }
            }

            System.out.println("#" + t + " " + answer);

        }
    }

    private static void bfs(int index) {
        Queue<Integer>  queue = new LinkedList<Integer>();

        queue.offer(index);
        visited[index] = true; 	// 방법2 : 들어갈때 방문 처리

        int size, level = 0;

        while(!queue.isEmpty()) {
            size = queue.size();
            while(--size >= 0) {
                int current = queue.poll();
                //visited[current] = true; 	// 방법1 : 나올 때 방문 처리
                output[current] = level;
                if(output[current] > max) {
                    max = output[current];
                }
                for(int i=0; i<length; ++i) {
                    if(contact[current][i]
                            && !visited[i]) {
                        queue.offer(i);
                        visited[i] = true; 	// 방법2 : 들어갈때 방문 처리
                    }
                }
            }
            level++;
        }
    }
}