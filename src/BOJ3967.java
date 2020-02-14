import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//백트래킹 https://idea-sketch.tistory.com/29
public class BOJ3967 {
    static char [][] hexaGram = new char[5][9];
    static boolean [] visited = new boolean[13];
    static int [][][] magicStar = {
            {{0,4},{1,3},{2,2},{3,1}},
            {{0,4},{1,5},{2,6},{3,7}},
            {{1,1},{1,3},{1,5},{1,7}},
            {{3,1},{3,3},{3,5},{3,7}},
            {{1,1},{2,2},{3,3},{4,4}},
            {{1,7},{2,6},{3,5},{4,4}}
    };
    static ArrayList<Point> list = new ArrayList<>();
    static int size;
    static boolean ok;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<5;i++){
            char [] temp = br.readLine().toCharArray();
            for(int j=0;j<9;j++){
                hexaGram[i][j] = temp[j];
                if(temp[j] == 'x') list.add((new Point(i,j)));
                else if(temp[j] != '.') visited[temp[j] - 'A' + 1] = true;
            }
        }
        size = list.size();

        dfs(0,0);
    }

    static void dfs(int cnt, int idx){
        if(ok) return;

        if(cnt == size && check()){
            ok = true;
            for(int i=0;i<5;i++){
                System.out.println(hexaGram[i]);
            }
            return;
        }

        for(int i=1;i<=12;i++){
            if(visited[i]) continue;

            Point cur = list.get(idx);
            visited[i] = true;
            hexaGram[cur.x][cur.y] = (char)(i+64);
            dfs(cnt+1,idx+1);
            visited[i] = false;
            hexaGram[cur.x][cur.y] = 'x';
        }
    }

    static boolean check(){
        for(int i=0;i<6;i++){
            int sum = 0;
            for(int j=0;j<4;j++){
                sum += (hexaGram[magicStar[i][j][0]][magicStar[i][j][1]] - 'A' + 1);
            }
            if(sum != 26) return false;
        }
        return true;
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