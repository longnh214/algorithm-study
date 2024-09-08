/**
 * @author nakhoonchoi
 * @date 2024/09/08
 * @see https://www.acmicpc.net/problem/15644
 * @mem 14,384kb
 * @time 80ms
 * @caution
 * [고려사항]
 * 백준 13459, 13460의 구슬 탈출 1,2 문제에서
 * 기존 경로를 Status 중 route 변수에 저장해서 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '구슬 탈출 3'

public class BOJ15644 {
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0 ,-1, 0, 1};
    static int N, M;
    static int answer;
    static int nRedX;
    static int nRedY;
    static int nBlueX;
    static int nBlueY;
    static char [][] copyMap;
    static String answerRoute;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;

        answer = 11;
        char [][] map = new char[N][M];
        for(int i=0;i<N;i++){
            String str = br.readLine();
            map[i] = str.toCharArray();
            if(str.contains("R")){
                redX = i;
                redY = str.indexOf("R");
            }
            if(str.contains("B")){
                blueX = i;
                blueY = str.indexOf("B");
            }
        }

        bfs(map, redX, redY, blueX, blueY);
        if(answer > 10){
            System.out.println(-1);
        }else{
            System.out.println(answer);
            System.out.println(answerRoute);
        }
    }

    public static void bfs(char [][] map, int redX, int redY, int blueX, int blueY){
        Set<String> visitedSet = new HashSet<>();
        Queue<Status> q = new LinkedList<>();
        String mapStr = mapToStr(map);
        visitedSet.add(mapStr);
        q.offer(new Status(redX, redY, blueX, blueY, mapStr, 0, ""));

        while(!q.isEmpty()){
            Status cur = q.poll();
            char [][] curMap = strToMap(cur.map);
            int curRedX = cur.redX;
            int curRedY = cur.redY;
            int curBlueX = cur.blueX;
            int curBlueY = cur.blueY;

            if(curBlueX == curBlueY && curBlueX == -1){
                //실패
                continue;
            }

            if(curRedX == curBlueX && curRedX == -1){
                //실패
                continue;
            }

            if(curRedX == curRedY && curRedX == -1){
                answer = Math.min(answer, cur.depth);
                answerRoute = cur.route;
                return;
            }

            if(cur.depth > 10){
                //실패
                continue;
            }

            copyMap = copy(curMap);
            nRedX = curRedX;
            nRedY = curRedY;
            nBlueX = curBlueX;
            nBlueY = curBlueY;
            //위
            if(curRedX < curBlueX){
                //빨강 먼저
                redBeedMove(0);
                blueBeedMove(0);
            }else{
                blueBeedMove(0);
                redBeedMove(0);
            }
            if(!visitedSet.contains(mapToStr(copyMap))){
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1, cur.route + "U"));
                visitedSet.add(mapToStr(copyMap));
            }

            //왼
            copyMap = copy(curMap);
            nRedX = curRedX;
            nRedY = curRedY;
            nBlueX = curBlueX;
            nBlueY = curBlueY;
            if(curRedY < curBlueY){
                //빨강 먼저
                redBeedMove(1);
                blueBeedMove(1);
            }else{
                blueBeedMove(1);
                redBeedMove(1);
            }
            if(!visitedSet.contains(mapToStr(copyMap))){
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1, cur.route + "L"));
                visitedSet.add(mapToStr(copyMap));
            }

            //아래
            copyMap = copy(curMap);
            nRedX = curRedX;
            nRedY = curRedY;
            nBlueX = curBlueX;
            nBlueY = curBlueY;
            if(curBlueX < curRedX){
                //빨강 먼저
                redBeedMove(2);
                blueBeedMove(2);
            }else{
                blueBeedMove(2);
                redBeedMove(2);
            }
            if(!visitedSet.contains(mapToStr(copyMap))){
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1, cur.route + "D"));
                visitedSet.add(mapToStr(copyMap));
            }

            //오른
            copyMap = copy(curMap);
            nRedX = curRedX;
            nRedY = curRedY;
            nBlueX = curBlueX;
            nBlueY = curBlueY;
            if(curBlueY < curRedY){
                //빨강 먼저
                redBeedMove(3);
                blueBeedMove(3);
            }else{
                blueBeedMove(3);
                redBeedMove(3);
            }
            if(!visitedSet.contains(mapToStr(copyMap))){
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1, cur.route + "R"));
                visitedSet.add(mapToStr(copyMap));
            }
        }
    }

    public static void redBeedMove(int dir){
        while(true){
            if(copyMap[nRedX + dx[dir]][nRedY + dy[dir]] == '.'){
                copyMap[nRedX + dx[dir]][nRedY + dy[dir]] = 'R';
                copyMap[nRedX][nRedY] = '.';
                nRedX += dx[dir];
                nRedY += dy[dir];
            }else if(copyMap[nRedX + dx[dir]][nRedY + dy[dir]] == 'O'){
                copyMap[nRedX][nRedY] = '.';
                nRedX = -1;
                nRedY = -1;
                break;
            }else{ //벽이거나 갈 수 없을 때
                break;
            }
        }
    }

    public static void blueBeedMove(int dir){
        while(true){
            if(copyMap[nBlueX + dx[dir]][nBlueY + dy[dir]] == '.'){
                copyMap[nBlueX + dx[dir]][nBlueY + dy[dir]] = 'B';
                copyMap[nBlueX][nBlueY] = '.';
                nBlueX += dx[dir];
                nBlueY += dy[dir];
            }else if(copyMap[nBlueX + dx[dir]][nBlueY + dy[dir]] == 'O'){
                copyMap[nBlueX][nBlueY] = '.';
                nBlueX = -1;
                nBlueY = -1;
                break;
            }else{ //벽이거나 갈 수 없을 때
                break;
            }
        }
    }

    public static String mapToStr(char [][] map){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<map.length;i++){
            sb.append(map[i]);
        }
        return sb.toString();
    }

    public static char [][] strToMap(String str){
        char [][] map = new char[N][M];
        for(int i=0;i<N;i++){
            map[i] = str.substring(M * i, M * (i+1)).toCharArray();
        }
        return map;
    }

    public static char [][] copy(char [][] map){
        char [][] copyArr = new char[map.length][map[0].length];
        for(int i=0;i<N;i++){
            copyArr[i] = map[i].clone();
        }
        return copyArr;
    }

    static class Status{
        int redX;
        int redY;
        int blueX;
        int blueY;
        String map;
        int depth;
        String route;

        Status(int redX, int redY, int blueX, int blueY, String map, int depth, String route) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.map = map;
            this.depth = depth;
            this.route = route;
        }
    }
}