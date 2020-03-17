import java.io.*;
import java.util.*;

public class Main {
    static int [][] question;
    static int [] dx = {0,1,1};
    static int [] dy = {-1,0,-1};
    static Queue<Point> q = new LinkedList<>();
    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            question = new int[a][b];

            st = null;
            for(int i=0;i<a;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<b;j++){
                    question[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            solution(new Point(0,0));
        }
    }

    public static void solution(Point point){
        int x = point.x;
        int y = point.y;
        if(question[x][y] == 0){
            for(int i=0;i<3;i++){
                solution(new Point(x+dx[i],y+dy[i]));
            }
        }else{

        }
    }

    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
}