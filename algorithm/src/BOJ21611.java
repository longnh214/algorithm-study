/**
 * @author nakhoonchoi
 * @date 2024/12/09
 * @see https://boj.ma/21611
 * @mem 42,208kb
 * @time 428ms
 * @caution
 * [고려사항]
 * 크게 로직은 블리자드, 폭발, 그룹화 세 가지로 나눌 수 있다.
 *
 * 블리자드로 인한 구슬의 파괴와 구슬의 폭발은 다른 의미이다.
 *
 * 빈 칸을 당겨오는 로직을 새로운 배열로 덮어쓰는 형식으로 구현하였다.
 *
 * 배열을 회전 순서대로 list에 보관할 때 빈 칸(0)에 대한 정보를 제외한 구슬에 대한 정보만 보관하고,
 * list에서 배열로 변환하면서 파괴된 구슬은 제외했다.
 * 
 * 폭발과 그룹화는 배열 <-> list 변환 사이에 로직을 추가했다.
 * 주의할 점은 list를 전부 순회한 뒤에 폭발이 일어나거나, 그룹화를 진행해야하는 경우가 있었다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <삼성기출/구현> '마법사 상어와 블리자드'

public class BOJ21611 {
    static int[][] map;
    static int N, M;
    static int[][] blizzardInfo;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] rotateX = {0,1,0,-1};
    static int[] rotateY = {-1,0,1,0};
    static List<Integer> beadList;
    static int [] breakCount = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        blizzardInfo = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            blizzardInfo[i][0] = Integer.parseInt(st.nextToken()) - 1;
            blizzardInfo[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<M;i++){
            //블리자드
            blizzard(i);

            //달팽이 배열 -> list
            mapToList();
            
            //list -> 달팽이 배열
            listToMap();


            //폭발
            explosion();

            //그룹화
            grouping();
        }

        System.out.println(result());
    }

    public static int result(){
        int sum = 0;

        for(int i=0;i<breakCount.length;i++){
            sum += ((i+1) * breakCount[i]);
        }

        return sum;
    }

    public static void grouping(){
        mapToList();

        setGroupList();

        listToMap();
    }

    public static void setGroupList(){
        List<Integer> tempList = new ArrayList<>();

        int checkBead = -1;
        int count = 0;

        for(int i=0;i<beadList.size();i++){
            int curBead = beadList.get(i);

            if(curBead == checkBead){
                count++;
            }else{
                if(checkBead != -1 && checkBead != 0) {
                    tempList.add(count + 1);
                    tempList.add(checkBead);
                }

                checkBead = curBead;
                count = 0;
            }
        }
        if(checkBead != -1 && checkBead != 0) {
            tempList.add(count + 1);
            tempList.add(checkBead);
        }

        beadList = tempList;
    }

    public static void listToMap() {
        int[][] temp = new int[N][N];

        int x = N / 2;
        int y = N / 2;

        int moveCount = 1;
        int curIndex = 0;

        while (isIn(x, y)) {
            //왼쪽
            for (int i = 0; i < moveCount; i++) {
                x += rotateX[0];
                y += rotateY[0];
                if (!isIn(x, y)) {
                    break;
                }
                if(curIndex < beadList.size()){
                    if(beadList.get(curIndex) > 0) {
                        temp[x][y] = beadList.get(curIndex++);
                    }else{
                        curIndex++;
                    }
                }
            }

            if(!isIn(x, y)){
                break;
            }

            //아래
            for (int i = 0; i < moveCount; i++) {
                x += rotateX[1];
                y += rotateY[1];
                if(curIndex < beadList.size()){
                    if(beadList.get(curIndex) > 0) {
                        temp[x][y] = beadList.get(curIndex++);
                    }else{
                        curIndex++;
                    }
                }
            }

            moveCount++;


            //오른쪽
            for (int i = 0; i < moveCount; i++) {
                x += rotateX[2];
                y += rotateY[2];
                if(curIndex < beadList.size()){
                    if(beadList.get(curIndex) > 0) {
                        temp[x][y] = beadList.get(curIndex++);
                    }else{
                        curIndex++;
                    }
                }
            }

            //위
            for (int i = 0; i < moveCount; i++) {
                x += rotateX[3];
                y += rotateY[3];
                if(curIndex < beadList.size()){
                    if(beadList.get(curIndex) > 0) {
                        temp[x][y] = beadList.get(curIndex++);
                    }else{
                        curIndex++;
                    }
                }
            }

            moveCount++;
        }
        map = temp;
    }

    public static void mapToList(){
        List<Integer> tempList = new ArrayList<>();

        int x = N/2;
        int y = N/2;

        int moveCount = 1;

        while(isIn(x, y)){
            //왼쪽
            for(int i=0;i<moveCount;i++){
                x += rotateX[0];
                y += rotateY[0];
                if(!isIn(x, y)){
                    break;
                }
                if(map[x][y] != 0) {
                    tempList.add(map[x][y]);
                }
            }

            if(!isIn(x, y)){
                break;
            }

            //아래
            for(int i=0;i<moveCount;i++){
                x += rotateX[1];
                y += rotateY[1];
                if(map[x][y] != 0) {
                    tempList.add(map[x][y]);
                }
            }

            moveCount++;


            //오른쪽
            for(int i=0;i<moveCount;i++){
                x += rotateX[2];
                y += rotateY[2];
                if(map[x][y] != 0) {
                    tempList.add(map[x][y]);
                }
            }

            //위
            for(int i=0;i<moveCount;i++){
                x += rotateX[3];
                y += rotateY[3];
                if(map[x][y] != 0) {
                    tempList.add(map[x][y]);
                }
            }

            moveCount++;
        }

        beadList = tempList;
    }

    public static boolean findExplosion(){
        boolean flag = false;

        int checkBead = -1;
        int count = 0;

        for(int i=0;i<beadList.size();i++){
            int curBead = beadList.get(i);

            if(curBead == checkBead){
                count++;
            }else if(count >= 3){
                for(int j=0;j<count+1;j++){
                    beadList.set(i-j-1, Integer.MIN_VALUE);
                }
                //파괴한 갯수 카운트
                breakCount[checkBead-1] += (count+1);

                //파괴가 되었음을 flag처리
                flag = true;
                checkBead = curBead;
                count = 0;
            }else{
                checkBead = curBead;
                count = 0;
            }
        }

        if(count >= 3){
            for(int j=0;j<count+1;j++){
                beadList.set(beadList.size()-j-1, Integer.MIN_VALUE);
            }
            //파괴한 갯수 카운트
            breakCount[checkBead-1] += (count+1);

            //파괴가 되었음을 flag처리
            flag = true;
        }

        return flag;
    }

    public static void explosion(){
        while(true) {
            mapToList();

            if (!findExplosion()) {
                listToMap();
                return;
            }

            listToMap();
        }
    }

    public static void blizzard(int index) {
        // 블리자드의 시작 위치 (가장 중앙)
        int x = N / 2;
        int y = N / 2;

        for(int i=1;i<=blizzardInfo[index][1];i++){
            int nx = x + (dx[blizzardInfo[index][0]] * i);
            int ny = y + (dy[blizzardInfo[index][0]] * i);

            map[nx][ny] = 0;
        }
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }
}