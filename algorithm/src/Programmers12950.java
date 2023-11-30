/**
 * @author nakhoon
 * @date 12/1/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12950
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '행렬의 덧셈'
public class Programmers12950 {
    public static void main(String[] args) {
        int [][] arr1 = {{1,2}, {3,4}};
        int [][] arr2 = {{3,4}, {5,6}};

        System.out.println(Arrays.toString(solution(arr1, arr2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                arr1[i][j] += arr2[i][j];
            }
        }
        return arr1;
    }
}
