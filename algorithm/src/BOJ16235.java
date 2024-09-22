/**
 * @author nakhoonchoi
 * @date 2024/09/22
 * @see https://www.acmicpc.net/problem/16235
 * @mem 301,808kb
 * @time 1,096ms
 * @caution
 * [고려사항]
 * 죽은 나무를 제거할 때, list에서 remove를 하지 않고
 * stream의 filter를 이용해서 죽은 나무를 제거하였다.
 *
 * 하나의 칸에 여러 나무가 있을 수 있지만 나이가 어린 나무부터 양분을 먹어야하기 때문에,
 * 4계절의 로직을 진행한 뒤에 treeList를 나이 순으로 정렬해주었다.
 *
 * 삼성 기출 답게 문제에 나와있는 대로 코드에 구현하였더니 AC를 받았다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
//백준 <삼성기출/구현> '나무 재테크'

public class BOJ16235 {
    static int N;
    static int [] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int [] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][N];
        int [][] feeds = new int[N][N];

        List<Tree> treeList = new ArrayList<>();

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            Arrays.fill(map[i], 5);

            for(int j=0;j<N;j++){
                feeds[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());

            treeList.add(new Tree(r, c, age));
        }

        Collections.sort(treeList);

        for(int i=0;i<K;i++){
            //봄
            for(Tree tree : treeList){
                if(map[tree.r][tree.c] < tree.age){
                    tree.isDead = true;
                }else{
                    map[tree.r][tree.c] -= tree.age;
                    tree.age++;
                }
            }
            //여름
            List<Tree> deadTreeList = treeList.stream()
                    .filter(tree -> tree.isDead)
                    .collect(Collectors.toList());

            for(Tree tree : deadTreeList){
                map[tree.r][tree.c] += (tree.age / 2);
            }

            treeList = treeList.stream()
                    .filter(tree -> !tree.isDead)
                    .collect(Collectors.toList());
            //가을
            List<Tree> fallTreeList = treeList.stream()
                    .filter(tree -> tree.age % 5 == 0)
                    .collect(Collectors.toList());

            for(Tree tree : fallTreeList){
                for(int j=0;j<8;j++){
                    int nr = tree.r + dx[j];
                    int nc = tree.c + dy[j];

                    if(isIn(nr, nc)){
                        treeList.add(new Tree(nr, nc, 1));
                    }
                }
            }

            //겨울
            for(int j=0;j<N;j++){
                for(int k=0;k<N;k++){
                    map[j][k] += feeds[j][k];
                }
            }

            Collections.sort(treeList);
        }

        System.out.println(treeList.size());
    }

    public static boolean isIn(int x, int y){
        return x>=0 && x<N && y>=0 && y<N;
    }

    static class Tree implements Comparable<Tree>{
        int r;
        int c;
        int age;
        boolean isDead;

        Tree(int r, int c, int age){
            this.r = r;
            this.c = c;
            this.age = age;
            this.isDead = false;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }
}
