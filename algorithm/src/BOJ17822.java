/**
 * @author nakhoonchoi
 * @date 2024/10/06
 * @see https://www.acmicpc.net/problem/17822
 * @mem 15,464kb
 * @time 136ms
 * @caution
 * [고려사항]
 * 원판의 회전을 2차원 배열을 이용해서 구하였다.
 * 인접한 곳에 수가 같다면 -1 flag 처리를 해줄 때 같다고 바로 flag를 바꾸면 안돼서 Set에 flag 처리할 곳을 저장해주었다.
 * Set의 크기가 0이라면 인접한 곳에 같은 수가 없는 경우이므로 평균에 따른 각 값의 증감처리를 해주었다.
 * 주의할 점은 평균과 값이 같다면 +1도 -1도 하면 안되었다.
 *
 * 그 외에는 문제대로 구현하면 되는 문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '원판 돌리기'

public class BOJ17822 {
    static int [][] plate;
    static int N, M;
    static int [] dx = {-1, 1, 0, 0};
    static int [] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        plate = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                plate[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            rotate(x, d, k);
            func();
        }

        System.out.println(plateSum());
    }

    public static void func(){
        Set<Point> erasePointSet = new HashSet<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(plate[i][j] != -1){
                    for(int k=0;k<4;k++){
                        int nx = i + dx[k];
                        int ny = (j + dy[k] + M) % M;

                        if(isIn(nx) && plate[i][j] == plate[nx][ny]) {
                            erasePointSet.add(new Point(i, j));
                            erasePointSet.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }

        if(!erasePointSet.isEmpty()){
            for(Point point : erasePointSet){
                plate[point.x][point.y] = -1;
            }
        }else{
            double avg = plateAvg();

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(plate[i][j] == -1){
                        continue;
                    }

                    if(plate[i][j] > avg){
                        plate[i][j]--;
                    }else if(plate[i][j] < avg){
                        plate[i][j]++;
                    }
                }
            }
        }
    }

    public static boolean isIn(int x){
        return x>=0 && x<N;
    }

    public static void rotate(int x, int d, int k){
        for(int i=x;i<=N;i+=x){
            if(d == 0) {
                for(int j=0;j<k;j++) {
                    int temp = plate[i - 1][M - 1];
                    for(int l=M-1;l>=1;l--){
                        plate[i - 1][l] = plate[i - 1][l - 1];
                    }
                    plate[i - 1][0] = temp;
                }
            }else{
                for(int j=0;j<k;j++) {
                    int temp = plate[i - 1][0];
                    for(int l=0;l<M-1;l++){
                        plate[i - 1][l] = plate[i - 1][l + 1];
                    }
                    plate[i - 1][M - 1] = temp;
                }
            }
        }
    }

    public static int plateSum(){
        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(plate[i][j] != -1){
                    sum += plate[i][j];
                }
            }
        }
        return sum;
    }

    public static double plateAvg(){
        double sum = 0;
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(plate[i][j] != -1){
                    sum += plate[i][j];
                    count++;
                }
            }
        }
        return count == 0 ? 0 : sum / count;
    }

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}