/**
 * @author choi
 * @date Oct 23, 2020
 * @see https://www.acmicpc.net/problem/14226
 * @mem 17,496kb
 * @time 112ms
 * @caution
 * [고려사항]
 * dp 배열을 2차원 배열로 선언했어야했다. 가장 먼저 S와 같은 값이 큐에서 나오면 그 depth는 정답이므로 break하고 출력.
 * 이모티콘의 길이와 clipboard에 들어간 저장 크기에 따른 2차원 dp 배열이 필요했다. 
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <BFS/DP> '이모티콘'
public class BOJ14226 {
    static int S, length,answer;
    static boolean [][] visited = new boolean[1001][1001];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Emoticon> q = new LinkedList<Emoticon>();

        q.offer(new Emoticon(1, 0, 0));

        while(!q.isEmpty()) {
            Emoticon temp = q.poll();

            if(temp.length == S) {
                answer = temp.depth;
                break;
            }

            //기존 값 복사
            q.offer(new Emoticon(temp.length, temp.depth+1, temp.length));

            //붙여넣기
            if(temp.clip != 0 && isIn(temp.length+temp.clip) && !visited[temp.length + temp.clip][temp.clip]) {
                visited[temp.length + temp.clip][temp.clip] = true;
                q.offer(new Emoticon(temp.length + temp.clip, temp.depth+1, temp.clip));
            }

            //이모티콘 한개 줄이기
            if(isIn(temp.length-1) && !visited[temp.length-1][temp.clip]) {
                visited[temp.length-1][temp.clip] = true;
                q.offer(new Emoticon(temp.length-1, temp.depth+1, temp.clip));
            }
        }
    }

    static class Emoticon{
        int length;
        int depth;
        int clip;
        Emoticon(int length, int depth, int clip) {
            this.length = length;
            this.depth = depth;
            this.clip = clip;
        }
    }

    public static boolean isIn(int x) {
        return x>=0 && x<1001;
    }
}