/**
 * @author choi
 * @date Oct 14, 2020
 * @see https://www.acmicpc.net/problem/17779
 * @mem 20,408kb
 * @time 428ms
 * @caution
 * [고려사항]
 * 배열의 인덱스를 잘 고려해서 풀어야 하는 문제였다. 부등호까지 친절하게 나와있어서 문제를 천천히 보고 풀면 풀 수 있는 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//백준 <구현/삼성기출> '게리맨더링 2'
public class BOJ17779 {
    static int [][] arr;
    static int [][] team;
    static int [] teamSum;
    static int N,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        teamSum = new int[6];
        team = new int[N+1][N+1];
        answer = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int x=1;x<=N;x++) {
            for(int y=1;y<=N;y++) {
                for(int d1=1;d1<=N;d1++) {
                    for(int d2=1;d2<=N;d2++) {
                        if(isIn(x+d1, y-d1) && isIn(x+d2, y+d2) && isIn(x+d1+d2, y-d1+d2) && isIn(x+d2+d1, y+d2-d1)) {
                            divide(x, y, d1, d2);
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void divide(int x, int y, int d1, int d2) {
        init();
        for(int i=0;i<=d1;i++) {
            team[x+i][y-i] = 5;
        }
        for(int i=0;i<=d2;i++) {
            team[x+i][y+i] = 5;
        }
        for(int i=0;i<=d2;i++) {
            team[x+d1+i][y-d1+i] = 5;
        }
        for(int i=0;i<=d1;i++) {
            team[x+d2+i][y+d2-i] = 5;
        }

        for(int r=1;r<x+d1;r++) {
            for(int c=1;c<=y;c++) {
                if(team[r][c] == 5)
                    break;
                team[r][c] = 1;
            }
        }

        for(int r=x+d2;r>=1;r--) {
            for(int c=N;c>y;c--) {
                if(team[r][c] == 5)
                    break;
                team[r][c] = 2;
            }
        }

        for(int r=x+d1;r<=N;r++) {
            for(int c=1;c<y-d1+d2;c++) {
                if(team[r][c] == 5)
                    break;
                team[r][c] = 3;
            }
        }

        for(int r=N;r>x+d2;r--) {
            for(int c=N;c>=y-d1+d2;c--) {
                if(team[r][c] == 5)
                    break;
                team[r][c] = 4;
            }
        }

        for(int r=1;r<=N;r++) {
            for(int c=1;c<=N;c++) {
                if(team[r][c] == 0)
                    team[r][c] = 5;
                teamSum[team[r][c]] += arr[r][c];
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<6;i++) {
            if(teamSum[i] == 0) return;
            max = Math.max(max, teamSum[i]);
            min = Math.min(min, teamSum[i]);
        }

        answer = Math.min(answer, max-min);
    }

    public static void init() {
        for(int i=1;i<=N;i++) {
            Arrays.fill(team[i], 0);
        }

        Arrays.fill(teamSum, 0);
    }

    public static boolean isIn(int x, int y) {
        return x>=1 && x<=N && y>=1 && y<=N;
    }
}