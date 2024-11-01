/**
 * @author nakhoonchoi
 * @date 2024/11/1
 * @see https://softeer.ai/practice/9657
 * @caution
 * [고려사항]
 * 일반적인 간단한 구현문제였다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//소프티어 <연습문제> '나무 공격'

public class Softeer9657 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int [][] map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<2;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            attack(start, end, map);
        }

        System.out.println(Arrays.stream(map).flatMapToInt(Arrays::stream).filter(num -> (num == 1)).count());
    }

    public static void attack(int start, int end, int [][] map){
        for(int i=start;i<=end;i++){
            for(int j=0;j<map[0].length;j++){
                if(map[i][j] != 0){
                    map[i][j] = 0;
                    break;
                }
            }
        }
    }
}