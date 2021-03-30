/**
 * @author choi
 * @date Nov 5, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu
 * @mem 32,040kb
 * @time 175ms
 * @caution
 * [고려사항]
 * 조합을 두번 돌려서 답을 구할 수 있었던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <SW역량테스트> '벌꿀채집'
public class Solution2115 {
    static int N,M,C,answer,max;
    static int [][] map;
    static boolean [][] visited;
    static int [][] temp;
    static int [] temp2;
    static int [] temp3;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        for(int t=1;t<=T;t++) {
            answer = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            temp = new int[2][2];
            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            comb(0,0,0);

            System.out.println("#" + t + " " + answer);
        }

    }

    public static void comb(int cnt, int x, int y) {
        if(cnt == 2) {
            int sum = 0;
            max = Integer.MIN_VALUE;
            temp2 = new int[M];
            for(int i=0;i<M;i++) {
                temp2[i] = map[temp[0][0]][temp[0][1] + i];
            }
            Arrays.sort(temp2);
            for(int i=1;i<=M;i++) {
                temp3 = new int[i];
                comb2(0,0,i);
            }
            sum += max;

            max = Integer.MIN_VALUE;
            temp2 = new int[M];
            for(int i=0;i<M;i++) {
                temp2[i] = map[temp[1][0]][temp[1][1] + i];
            }
            Arrays.sort(temp2);
            for(int i=1;i<=M;i++) {
                temp3 = new int[i];
                comb2(0,0,i);
            }
            sum += max;

            answer = Math.max(answer, sum);
            return;
        }

        for(int i=x;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(isOk(i,j)) {
                    for(int k=0;k<M;k++) {
                        visited[i][j+k] = true;
                    }
                    temp[cnt][0] = i;
                    temp[cnt][1] = j;
                    comb(cnt+1,i,j);
                    for(int k=0;k<M;k++) {
                        visited[i][j+k] = false;
                    }
                }
            }
        }
    }

    public static void comb2(int cnt, int start, int maxLen) {
        if(cnt == maxLen) {
            int sum = 0;
            for(int i=0;i<temp3.length;i++) {
                sum += temp3[i];
            }
            if(sum > C) return;

            sum = 0;
            for(int i=0;i<temp3.length;i++) {
                sum += (temp3[i] * temp3[i]);
            }
            max = Math.max(max, sum);
            return;
        }

        for(int i=start;i<temp2.length;i++) {
            temp3[cnt] = temp2[i];
            comb2(cnt+1, i+1, maxLen);
        }
    }

    public static boolean isOk(int x, int y) {
        for(int i=0;i<M;i++) {
            if(!isIn(x,y+i) || visited[x][y+i]) return false;
        }
        return true;
    }

    public static boolean isIn(int x, int y) {
        return x>=0 && x<N && y>=0 && y<N;
    }
}