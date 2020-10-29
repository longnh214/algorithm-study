/**
 * @author choi
 * @date Oct 29, 2020
 * @see https://www.acmicpc.net/problem/14890
 * @mem 12,892kb
 * @time 112ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현> '경사로'
public class BOJ14890 {
    static int answer, N, X;
    //x,y축 대칭인 배열을 하나 더 만들어서 4 방향 중 한 방향으로만 탐색하도록 한다.
    static int[][] map1, map2;
    static int[] dx = { 1, 0 };
    static int[] dy = { 0, 1 };
    static boolean[][] visited;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        answer = 0;
        map1 = new int[N][N];
        map2 = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map1[i][j] = Integer.parseInt(st.nextToken());
                map2[j][i] = map1[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            if (calc(map1, i)) {
                answer++;
            }
            if (calc(map2, i)) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    // 배열을 x,y 대칭인 두 배열을 넘기므로 한 방향으로만 탐색해도 된다.원래는 총 4번 탐색해야했다.
    private static boolean calc(int[][] map, int idx) {
        int count = 1;
        int height = map[idx][0];

        for (int i = 1; i < N; i++) {
            // 전에 탐색했던 height와 새로 볼 height를 비교해서 같으면.
            if (height == map[idx][i]) {
                // 길이를 더한다.
                count++;
            }
            // 달라졌으며, 오르막이다.
            else if (map[idx][i] - height == 1) {
                // X길이보다 길이가 짧았다면 false.
                if (count < X) {
                    return false;
                }
                // 오르내리막이 달라졌으므로 count를 초기화하고, height도 갱신한다.
                else {
                    count = 1;
                    height = map[idx][i];
                }
                // 달라졌으며, 내리막이다.
            } else if (height - map[idx][i] == 1) {
                // 기준 길이 X + 반복문 변수 i가 N보다 크다면 범위 밖이므로 불가능.
                if (N < X + i) {
                    return false;
                }
                // 바로 다음에 나올 인덱스들이 다시 오르막이 된다면 불가능.
                for (int j = 1; j < X; j++) {
                    if (height - map[idx][++i] != 1) {
                        return false;
                    }
                }

                // 오르막에서 내리막으로 바뀌었으므로 count를 0으로 초기화하고,
                // height 갱신.
                height = map[idx][i];
                count = 0;
            }
            // 이외의 경우 전부 false
            else {
                return false;
            }
        }
        // 끝까지 잘 탐색이 되었다면 불가능한 경우 검수를 다 했으므로 true리턴.
        return true;
    }
}