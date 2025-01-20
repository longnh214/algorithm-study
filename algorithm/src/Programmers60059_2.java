/**
 * @author nakhoonchoi
 * @date 2025/01/20
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/60059
 */
import java.util.*;
//프로그래머스 <2020 KAKAO BLIND RECRUITMENT> '자물쇠와 열쇠'

public class Programmers60059_2 {
    private final int DUMMY_DATA = -1;
    public boolean solution(int[][] key, int[][] lock) {
        int N = lock.length;
        int M = key.length;

        int emptyCount = 0;

        for(int i=0;i<N;i++){
            for (int j = 0; j < N; j++) {
                if(lock[i][j] == 0){
                    emptyCount++;
                }
            }
        }

        for(int i=0;i<4;i++){
            key = rotate(key);
            for(int j=0;j<M+N-1;j++){
                for(int k=0;k<M+N-1;k++){
                    if(isMatch(key, j, k, lock, emptyCount)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean isMatch(int [][] key, int x, int y, int [][] lock, int emptyCount){
        int N = lock.length;
        int M = key.length;
        int [][] keyStatusArr = new int[N + (2*M - 2)][N + (2*M - 2)];

        for(int i=0;i< keyStatusArr.length;i++){
            Arrays.fill(keyStatusArr[i], DUMMY_DATA);
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                keyStatusArr[x + i][y + j] = key[i][j];
            }
        }

        int count = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(keyStatusArr[M-1+i][M-1+j] == 1 && lock[i][j] == 1){
                    return false;
                }else if(keyStatusArr[M-1+i][M-1+j] == 1 && lock[i][j] == 0){
                    count++;
                }
            }
        }

        return emptyCount == count;
    }

    public int [][] rotate(int [][] key){
        int M = key.length;
        int [][] temp = new int[M][M];

        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                temp[i][j] = key[j][M-i-1];
            }
        }

        return temp;
    }
}