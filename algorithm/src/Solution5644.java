/**
 * @author choi
 * @date Nov 2, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWXRDL1aeugDFAUo
 * @mem 21,120kb
 * @time 125ms
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SWEA <SW 역량테스트> '무선 충전'
public class Solution5644 {
    static int [] dx = {0,-1,0,1,0};
    static int [] dy = {0,0,1,0,-1};
    static int [] cmdA;
    static int [] cmdB;
    static int [] charge;
    static AP [] apArr;
    static int answer, M, A, userAX, userAY, userBX, userBY, curA, curB;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            cmdA = new int[M+1];
            cmdB = new int[M+1];
            charge = new int[M+1];
            st = new StringTokenizer(br.readLine());
            cmdA[0] = 0;
            for(int i=1;i<=M;i++) {
                cmdA[i] = Integer.parseInt(st.nextToken());
            }
            cmdB[0] = 0;
            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=M;i++) {
                cmdB[i] = Integer.parseInt(st.nextToken());
            }
            apArr = new AP[A+1];
            for(int i=1;i<=A;i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                apArr[i] = new AP(x, y, c, p);
            }
            answer = move();

            System.out.println("#" + t +" " + answer);
        }

    }

    static int move() {
        int x1 = 1;
        int y1 = 1;
        int x2 = 10;
        int y2 = 10;

        //0초일때의 합
        int sum = getMax(x1,y1,x2,y2);

        //시간별로 이동하면서 그때마다의 최대값을 합해준다.
        for(int time=1; time<=M; time++) {
            x1 += dx[cmdA[time]];
            y1 += dy[cmdA[time]];
            x2 += dx[cmdB[time]];
            y2 += dy[cmdB[time]];
            sum += getMax(x1,y1,x2,y2);
        }

        return sum;
    }


    static int getMax(int x1, int y1, int x2, int y2) {
        int[][] amount = new int[2][A+1];
        //2차원 배열에 사용자A(0)와 사용자B(1)의 BC별로 충전가능한 값을 저장해준다.

        //사용자A의 충전 가능한 BC의 p값
        for(int j=1; j<=A; j++) {
            amount[0][j] = check(x1,y1,j);
        }

        //사용자B의 충전 가능한 BC의 p값
        for(int j=1; j<=A; j++) {
            amount[1][j] = check(x2,y2,j);

        }

        //사용자 A와 사용자 B의 충전량의 합중 최댓값을 구해준다.
        int max = 0;
        for(int i=1; i<=A; i++) {
            for(int j=1; j<=A; j++) {
                int sum = amount[0][i]+amount[1][j];

                // 같은 BC를 이용하는 경우 값을 반으로 나눠줘야한다.
                // 주의할 점은 한 쪽은 아예 값이 0일수도 있으므로(해당 BC를 이용할 수 없는 위치) 정확히 둘다 같이 이용하고 있는 경우에만 나누어주어야한다.
                if(i == j && amount[0][i] == amount[1][j])
                    sum /= 2;
                if(sum > max) max = sum;
            }
        }

        return max;
    }

    static int check(int x, int y, int apnum) {
        AP temp = apArr[apnum];
        int a = Math.abs(x-temp.x);
        int b = Math.abs(y-temp.y);
        int dist = a+b;

        //해당 BC에 포함되는 경우에 p값을 리턴
        if(dist <= temp.c)
            return temp.p;
        else
            return 0;
    }

    public static boolean isIn(int x, int y) {
        return x>=1 && x<=10 && y>=1 && y<=10;
    }

    static class AP{
        int x;
        int y;
        int c;
        int p;
        public AP(int x, int y, int c, int p) {
            super();
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}