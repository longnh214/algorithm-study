/**
 * @author choi
 * @date Dec 3, 2020
 * @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
import java.io.*;
//SW Expert <SW 역량테스트> - '보호 필름'
public class Solution2112 {
    static int [][] map;
    static int D,W,K,answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[D][W];
            answer = Integer.MAX_VALUE;

            for(int i=0;i<D;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<W;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if(K==1) {
                System.out.println("#" + t + " " + 0);
                continue;
            }

            dfs(0,0);

            System.out.println("#" + t + " " + answer);
        }
    }

    public static void dfs(int row, int cnt){
        // 최소값 보다 이미 더 많이 뿌린 경우 탐색 X
        if(answer <= cnt)
            return;
        // 마지막 행까지 도달한 경우 성능검사
        if(row == D){
            check(cnt);
            return;
        }

        // 안 뿌림
        dfs(row+1, cnt);

        // 원본 저장
        int[] copy = new int[W];
//        for(int i=0;i<W;i++) {
//        	copy[i] = map[row][i];
//        }
        System.arraycopy(map[row], 0, copy, 0, W);

        // A 뿌림
        Arrays.fill(map[row], 0);
        dfs(row+1, cnt+1);
//        for(int i=0;i<W;i++) {
//        	map[row][i] = copy[i];
//        }
        System.arraycopy(copy, 0, map[row], 0, W);

        // B 뿌림
        Arrays.fill(map[row], 1);
        dfs(row+1, cnt+1);
//        for(int i=0;i<W;i++) {
//        	map[row][i] = copy[i];
//        }
        System.arraycopy(copy, 0, map[row], 0, W);
    }

    public static void check(int cnt){
        // 열 별로 검사
        for(int i=0; i<W; i++){
            int before = map[0][i];
            int len = 1;
            int max = 0;

            for(int j=1; j<D; j++){
                if(map[j][i] == before){
                    len++;
                }
                else{
                    max = max < len ? len : max;
                    // 이미 연속된 특성이 K개가 넘은 경우 다음 열 탐색
                    if(max >= K)
                        break;

                    len = 1;
                    before = map[j][i];
                }

                if(len >= K)
                    break;

                // 더 탐색해도 K이상 나올 수 없음
                if(len + (D-j+1) < K)
                    return;
            }

            max = max < len ? len : max;
            // 한 열이라도 연속된 수의 길이가 K 이상이 아니면 return
            if(max < K)
                return;
        }

        answer = answer > cnt ? cnt : answer;
        return;
    }
}