/**
 * @author nakhoonchoi
 * @date 2024/12/01
 * @see https://www.acmicpc.net/problem/5373
 * @mem 193,708kb
 * @time 596ms
 * @caution
 * [고려사항]
 * 디버깅이 너무 어려웠다. 삼성 기출의 주사위만들기의 풀이법에 회전을 더하는 문제였는데,
 * 기준 면의 회전은 쉬웠지만, 옆 면을 회전시키는 것이 고려할 점이 많았다.
 * 인덱스의 방향과 위치를 고려하기 어려웠다.
 * 반례가 없었다면 풀기 힘들었을 문제.
 * [입력사항]
 * [출력사항]
 */

import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '큐빙'

public class BOJ5373 {
    static char[][][] cube = new char[6][3][3];
    //  0
    //4 1 5
    //  2
    //  3
    static char[] initColor = {'o', 'w', 'r', 'y', 'g', 'b'};
    static Map<Character, Integer> directionMap = Map.of('B', 0, 'U', 1, 'F', 2, 'D', 3, 'L', 4, 'R', 5);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            init();

            for (int i = 0; i < N; i++) {
                String str = st.nextToken();

                int area = directionMap.get(str.charAt(0));
                boolean isClockwise = str.charAt(1) == '+';

                //면 회전
                rotateArea(area, isClockwise);
                //옆 회전
                rotateSide(area, isClockwise);
            }
            //print
            print();
        }
    }

    public static void init() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(cube[i][j], initColor[i]);
            }
        }
    }

    public static void rotateArea(int area, boolean isClockwise) {
        char[][] temp = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                temp[i][j] = isClockwise ? cube[area][2 - j][i] : cube[area][j][2 - i];
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cube[area][i][j] = temp[i][j];
            }
        }
    }

    public static void rotateSide(int area, boolean isClockwise) {
        // 각 면의 인접 면 번호 (위, 오른쪽, 아래, 왼쪽)
        int[][] adjacent = {
                {3, 5, 1, 4}, // B
                {0, 5, 2, 4}, // U
                {1, 5, 3, 4}, // F
                {2, 5, 0, 4}, // D
                {0, 1, 2, 3}, // L
                {0, 3, 2, 1}  // R
        };

        // 각 면의 회전 시, 인접 면에서 이동할 데이터의 인덱스
        int[][][][] edgeIndices = {
                //{0,0},{0,1},{0,2} 위
                //{2,0},{2,1},{2,2} 아래
                //{0,0},{1,0},{2,0} 왼쪽
                //{0,2},{1,2},{2,2} 오른쪽
                { // B
                        {
                            {2, 0}, {2, 1}, {2, 2},
                        }, {
                            {0, 2}, {0, 1}, {0, 0},
                        }, {
                            {0, 2}, {0, 1}, {0, 0},
                        }, {
                            {0, 2}, {0, 1}, {0, 0},
                        },
                },
                { // U
                        {
                            {2, 0}, {2, 1}, {2, 2},
                        }, {
                            {0, 0}, {1, 0}, {2, 0},
                        }, {
                            {0, 2}, {0, 1}, {0, 0},
                        }, {
                            {2, 2}, {1, 2}, {0, 2},
                        },
                },
                { // F
                        {
                            {2, 0}, {2, 1}, {2, 2},
                        }, {
                            {2, 0}, {2, 1}, {2, 2},
                        }, {
                            {0, 2}, {0, 1}, {0, 0},
                        }, {
                            {2, 0}, {2, 1}, {2, 2},
                        }
                },
                { // D
                        {
                            {2, 0}, {2, 1}, {2, 2},
                        }, {
                            {2, 2}, {1, 2}, {0, 2},
                        }, {
                            {0, 2}, {0, 1}, {0, 0},
                        }, {
                            {0, 0}, {1, 0}, {2, 0},
                        }
                },
                { // L
                        {
                            {0, 0}, {1, 0}, {2, 0},
                        }, {
                            {0, 0}, {1, 0}, {2, 0},
                        }, {
                            {0, 0}, {1, 0}, {2, 0},
                        }, {
                            {0, 0}, {1, 0}, {2, 0},
                        }
                },
                { // R
                        {
                            {0, 2}, {1, 2}, {2, 2},
                        }, {
                            {0, 2}, {1, 2}, {2, 2},
                        }, {
                            {0, 2}, {1, 2}, {2, 2},
                        }, {
                            {0, 2}, {1, 2}, {2, 2},
                        }
                }
        };

        // 인접 면 회전 처리
        char[][] temp = new char[4][3];
        for (int i = 0; i < 4; i++) {
            int adjArea = adjacent[area][i];
            for (int j = 0; j < 3; j++) {
                temp[i][j] = cube[adjArea][edgeIndices[area][i][j][0]][edgeIndices[area][i][j][1]];
            }
        }

        // 방향에 따라 데이터 이동
        for (int i = 0; i < 4; i++) {
            int from = isClockwise ? (i + 3) % 4 : (i + 1) % 4;
            int adjArea = adjacent[area][i];
            for (int j = 0; j < 3; j++) {
                cube[adjArea][edgeIndices[area][i][j][0]][edgeIndices[area][i][j][1]] = temp[from][j];
            }
        }
    }

    public static void print() {
        for (int i = 0; i < 3; i++) {
            System.out.println(String.copyValueOf(cube[1][i]));
        }
    }
}