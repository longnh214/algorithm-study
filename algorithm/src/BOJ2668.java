import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2668 {
    static int [] map;
    static boolean [] visited;
    static ArrayList<Integer> list;
    static int value; //싸이클 확인 변수
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        map = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList<>();
        for(int i=1;i<n+1;i++){
            map[i] = scan.nextInt();
        }
        for(int i=1;i<n+1;i++){
            visited[i] = true;
            value = i;//첫 값을 저장
            dfs(i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int m : list)
            System.out.println(m);
    }

    static void dfs(int i){
        if(!visited[map[i]]){//이전에 방문한 적이 없어야한다.
            visited[map[i]] = true;
            dfs(map[i]);
            visited[map[i]] = false;
        }
        if(map[i] == value)
            list.add(value);
    }
}