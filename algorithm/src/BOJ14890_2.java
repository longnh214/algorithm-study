/**
 * @author nakhoonchoi
 * @date 2024/09/02
 * @see https://www.acmicpc.net/problem/14890
 * @mem 12,724kb
 * @time 84ms
 * @caution
 * [고려사항]
 * 가로 방향으로 탐색하기 위해서 N*N 배열을 두 개 선언하여,
 * map1[i][j] = map2[j][i] = num 으로 값을 넣어주었다.
 * 1차원 배열에 경사로가 될 지 판별할 때에
 * 기준 높이와 높이가 같을 때 / 내리막 1차이 날 때 /
 * 오르막 1차이 날 때 / 예외 와 같이 총 4가지 case로
 * 나누어서 생각했다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '경사로'

public class BOJ14890_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int [][] map1 = new int[N][N];
        int [][] map2 = new int[N][N];

        int answer = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int num = Integer.parseInt(st.nextToken());
                map1[i][j] = num;
                map2[j][i] = num;
            }
        }

        for(int i=0;i<N;i++){
            if(isOk(map1[i], L)){
                answer++;
            }
            if(isOk(map2[i], L)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean isOk(int [] map, int L){
        int height = map[0];
        int count = 1;

        for(int i=1;i<map.length;i++){
            if(height == map[i]){
                count++;
            }else if(height - map[i] == 1){ // 내리막인 경우
                if(map.length < L + i){
                    return false;
                }

                for(int j=1;j<L;j++){
                    if(height - map[++i] != 1){
                        return false;
                    }
                }

                height = map[i];
                count = 0;
            }else if(map[i] - height == 1){ // 오르막인 경우
                if(count < L){
                    return false;
                }else{
                    height = map[i];
                    count = 1;
                }
            }else{ //길이 차이가 1 이상 나는 것이므로 전부 false
                return false;
            }
        }

        return true;
    }
}