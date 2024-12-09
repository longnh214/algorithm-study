/**
 * @author nakhoonchoi
 * @date 2024/12/09
 * @see https://boj.ma/23290
 * @mem 366,488kb
 * @time 2,608ms
 * @caution
 * [고려사항]
 * fishMemoryList에 이전 물고기의 이력을 저장하고,
 * fishStateList에 복제하는 로직에서 많은 시행착오가 있었다.
 *
 * list.addAll은 일단 얕은 복사가 일어난다.
 *
 * 스트림을 통해 먹힌 물고기 외에
 * 유효한 물고기를 filter해서 fishMemoryList에 넣는 과정에서
 * filter 뿐만 아니라 map에 생성자를 새로 선언해서
 * 새로운 객체를 memoryList에 담아야했다.(독립적인 객체를 위해)
 *
 * 깊은 복사가 일어나지 않았을 때에는 fishStateList의 내용을 수정하면
 * fishMemoryList내의 객체 내용도 수정이 되어 맞왜틀이 계속 발생해서 오래 걸렸다.
 *
 * 물고기의 이동에서 상어의 좌표를 피할 때 조건문에서 주의해야했다.
 * if(isIn(nx, ny) && map[nx][ny] == 0 && (nx != sharkX && ny != sharkY)){ (X)
 * if(isIn(nx, ny) && map[nx][ny] == 0 && !(nx == sharkX && ny == sharkY)){ (O)
 *
 * 그리고 상어의 3연속 이동 사전 나열 순을 String 문자열로 처리하였다.(ex : 000, 030, 333)
 *
 * 대부분 stream.filter()을 이용해서 리스트를 필터링했다.
 * (그래서 소요 시간이 오래 걸린듯...)
 *
 * 결론 : 깊은 복사 때문에 애먹었다...
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//백준 <삼성기출/구현> '마법사 상어와 복제'

public class BOJ23290 {
    static List<Fish> fishMemoryList = new ArrayList<>();
    static List<Fish> fishStateList = new ArrayList<>();
    static int [][] map = new int[4][4];
    static int [] dx = {0,-1,-1,-1,0,1,1,1};
    static int [] dy = {-1,-1,0,1,1,1,0,-1};
    static int sharkX, sharkY;
    static int [] sharkDx = {-1,0,1,0};
    static int [] sharkDy = {0,-1,0,1};
    static String [] routeCase = new String[64];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        initRouteCase();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;

            fishMemoryList.add(new Fish(x, y, dir, i));
        }

        st = new StringTokenizer(br.readLine());
        sharkX = Integer.parseInt(st.nextToken()) - 1;
        sharkY = Integer.parseInt(st.nextToken()) - 1;

        copyFish();

        while(S-->0){
            //물고기 이동
            moveFish();
            //상어 이동
            moveShark();
            //냄새 --
            smellArrange();
            //복제
            copyFish();
        }

        System.out.println((int) fishStateList.stream().filter(fish -> !fish.isDead).count());
    }

    public static void smellArrange(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(map[i][j] > 0){
                    map[i][j]--;
                }
            }
        }
    }

    public static void initRouteCase(){
        for(int i=0;i<64;i++){
            routeCase[i] = String.format("%03d", Integer.parseInt(Integer.toString(i, 4)));
        }
    }

    public static void moveShark(){
        PriorityQueue<RouteState> pq = new PriorityQueue<>();
        for(int i=0;i<64;i++){
            int result = calEatFishCount(routeCase[i]);
            if(result != -1){
                pq.offer(new RouteState(routeCase[i], result));
            }
        }

        RouteState bestCase = pq.poll();
        makeSmellAndEat(bestCase.route);
    }

    public static void makeSmellAndEat(String route){
        int nx = sharkX;
        int ny = sharkY;

        for(int i=0;i<route.length();i++){
            int dir = route.charAt(i) - '0';
            nx += sharkDx[dir];
            ny += sharkDy[dir];

            int count = eatFish(nx, ny);

            if(count > 0) {
                map[nx][ny] = 3;
            }
        }

        sharkX = nx;
        sharkY = ny;
    }

    public static int eatFish(int x, int y){
        List<Fish> eatFishList = getFishByXY(x, y);
        for(Fish fish : eatFishList){
            fish.isDead = true;
        }

        return eatFishList.size();
    }

    public static List<Fish> getFishByXY(int x, int y){
        return fishStateList.stream().filter(fish -> fish.x == x && fish.y == y && !fish.isDead).collect(Collectors.toList());
    }

    public static int calEatFishCount(String route){
        int sum = 0;
        int nx = sharkX;
        int ny = sharkY;

        boolean [][] visited = new boolean[4][4];

        for(int i=0;i<route.length();i++){
            int dir = route.charAt(i) - '0';
            nx += sharkDx[dir];
            ny += sharkDy[dir];

            if(isIn(nx, ny) && !visited[nx][ny]){
                visited[nx][ny] = true;
                int count = getFishByXY(nx, ny).size();
                sum += count;
            }else if(isIn(nx, ny) && visited[nx][ny]){

            }else{
                return -1;
            }
        }

        return sum;
    }

    public static void moveFish(){
        outer: for(Fish fish : fishStateList){
            for(int i=0;i<8;i++){
                int dir = ((fish.dir - i) + 8) % 8;
                int nx = fish.x + dx[dir];
                int ny = fish.y + dy[dir];

                if(isIn(nx, ny) && map[nx][ny] == 0 && !(nx == sharkX && ny == sharkY)){
                    fish.x = nx;
                    fish.y = ny;
                    fish.dir = dir;
                    continue outer;
                }
            }
        }
    }

    public static void copyFish(){
        for (Fish fish : fishMemoryList) {
            // 완전히 새로운 Fish 객체를 생성하여 추가
            Fish newFish = new Fish(fish.x, fish.y, fish.dir, fish.index);
            newFish.isDead = fish.isDead; // 상태 복사
            fishStateList.add(newFish);
        }

        // fishMemoryList는 fishStateList의 내용을 기반으로 갱신
        fishMemoryList = fishStateList.stream()
                .filter(fish -> !fish.isDead)
                .map(fish -> new Fish(fish.x, fish.y, fish.dir, fish.index))
                .collect(Collectors.toList());
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<4 && y>=0 && y<4;
    }

    static class RouteState implements Comparable<RouteState>{
        String route;

        int eatFishCount;

        RouteState(String route, int eatFishCount){
            this.route = route;
            this.eatFishCount = eatFishCount;
        }

        @Override
        public int compareTo(RouteState o) {
            if(this.eatFishCount == o.eatFishCount){
                return this.route.compareTo(o.route);
            }
            return Integer.compare(this.eatFishCount, o.eatFishCount) * -1;
        }
    }

    static class Fish{
        int x;
        int y;
        int dir;
        boolean isDead;
        int index;

        Fish(int x, int y, int dir, int index){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.isDead = false;
            this.index = index;
        }
    }
}