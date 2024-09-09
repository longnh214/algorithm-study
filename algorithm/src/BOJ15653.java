/**
 * @author nakhoonchoi
 * @date 2024/09/09
 * @see https://www.acmicpc.net/problem/15653
 * @mem 14,768kb
 * @time 88ms
 * @caution
 * [고려사항]
 * 구슬 탈출 문제에서 10번 이상 움직였을 경우 -1을 출력하던 분기처리를 수정하고,
 * bfs로 완전탐색을 했을 때, 성공할 수 없다면 -1을 출력하였고,
 * 10번을 넘기더라도 횟수를 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '구슬 탈출 4'

public class BOJ15653 {
    static int [] dx = {-1, 0, 1, 0};
    static int [] dy = {0 ,-1, 0, 1};
    static int N, M;
    static int answer;
    static int nRedX;
    static int nRedY;
    static int nBlueX;
    static int nBlueY;
    static char [][] copyMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int redX = 0;
        int redY = 0;
        int blueX = 0;
        int blueY = 0;

        answer = Integer.MAX_VALUE;
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
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    public static void bfs(char [][] map, int redX, int redY, int blueX, int blueY){
        Set<String> visitedSet = new HashSet<>();
        Queue<Status> q = new LinkedList<>();
        String mapStr = mapToStr(map);
        visitedSet.add(mapStr);
        q.offer(new Status(redX, redY, blueX, blueY, mapStr, 0));

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
                return;
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
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1));
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
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1));
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
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1));
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
                q.offer(new Status(nRedX, nRedY, nBlueX, nBlueY, mapToStr(copyMap), cur.depth+1));
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

        Status(int redX, int redY, int blueX, int blueY, String map, int depth) {
            this.redX = redX;
            this.redY = redY;
            this.blueX = blueX;
            this.blueY = blueY;
            this.map = map;
            this.depth = depth;
        }
    }
}