/**
 * @author choi
 * @date Nov 8, 2020
 * @see https://www.acmicpc.net/problem/12100
 * @mem 19,992kb
 * @time 268ms
 * @caution
 * [고려사항]
 * SW Expert의 '추억의 2048게임'과 조합을 이용하여 문제를 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
// 백준 <구현> '2048(easy)
public class BOJ12100 {
    static int N,answer;
    static int [][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;

        map = new int[N][N];

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(answer);
    }

    public static void dfs(int cnt) {

        int[][] tempMap = new int[N + 1][N + 1];
        copy(tempMap, map);

        if (cnt == 5) {
            findMaxNumber();
            return;
        }
        for (int i = 0; i < 4; i++) {
            function(i);
            dfs(cnt + 1);
            copy(map, tempMap);
        }
    }

    public static void findMaxNumber() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, map[i][j]);
            }
        }
    }

    public static void copy(int[][] arr, int[][] arr2) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
    }

    public static void function(int command) {
        int index;
        switch (command) {
            case 0:
                for(int i=0; i<N; i++) {
                    for(int j=0; j<N-1; j++) {
                        if(map[i][j] != 0) {
                            for(int k=j+1; k<N; k++) {
                                if(map[i][k] != 0) {
                                    if(map[i][j] == map[i][k]) {
                                        map[i][j] *= 2;
                                        map[i][k] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int i=0; i<N; i++) {
                    for(int j=1; j<N; j++) {
                        if(map[i][j] != 0) {
                            index = -1;
                            for(int k=j-1; k>=0; k--) {
                                if(map[i][k] != 0) {
                                    break;
                                }
                                index = k;
                            }
                            if(index != -1) {
                                map[i][index] = map[i][j];
                                map[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i=0; i<N; i++) {
                    for(int j=N-1; j>0; j--) {
                        if(map[i][j] != 0) {
                            for(int k=j-1; k>=0; k--) {
                                if(map[i][k] != 0) {
                                    if(map[i][j] == map[i][k]) {
                                        map[i][j] *= 2;
                                        map[i][k] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int i=0; i<N; i++) {
                    for(int j=N-1; j>=0; j--) {
                        if(map[i][j] != 0) {
                            index = -1;
                            for(int k=j+1; k<N; k++) {
                                if(map[i][k] != 0) {
                                    break;
                                }
                                index = k;
                            }
                            if(index != -1) {
                                map[i][index] = map[i][j];
                                map[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int j=0; j<N; j++) {
                    for(int i=0; i<N-1; i++) {
                        if(map[i][j] != 0) {
                            for(int k=i+1; k<N; k++) {
                                if(map[k][j] != 0) {
                                    if(map[i][j] == map[k][j]) {
                                        map[i][j] *= 2;
                                        map[k][j] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int j=0; j<N; j++) {
                    for(int i=1; i<N; i++) {
                        if(map[i][j] != 0) {
                            index = -1;
                            for(int k=i-1; k>=0; k--) {
                                if(map[k][j] != 0) {
                                    break;
                                }
                                index = k;
                            }
                            if(index != -1) {
                                map[index][j] = map[i][j];
                                map[i][j] = 0;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int j=0; j<N; j++) {
                    for(int i=N-1; i>0; i--) {
                        if(map[i][j] != 0) {
                            for(int k=i-1; k>=0; k--) {
                                if(map[k][j] != 0) {
                                    if(map[i][j] == map[k][j]) {
                                        map[i][j] *= 2;
                                        map[k][j] = 0;
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                for(int j=0; j<N; j++) {
                    for(int i=N-2; i>=0; i--) {
                        if(map[i][j] != 0) {
                            index = -1;
                            for(int k=i+1; k<N; k++) {
                                if(map[k][j] != 0) {
                                    break;
                                }
                                index = k;
                            }
                            if(index != -1) {
                                map[index][j] = map[i][j];
                                map[i][j] = 0;
                            }
                        }
                    }
                }
        }
    }

    public static void print() {
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.substring(0, sb.length() - 1);
            System.out.println(sb.toString());
        }
    }
}