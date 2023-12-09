/**
 * @author nakhoonchoi
 * @date 2023/12/09
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/86491
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 최소 최대값을 이용해서 가장 효율적인 명함 지갑의 크기를 구할 수 있었다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '최소직사각형'
public class Programmers86491 {
    public static void main(String[] args) {
        int [][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int maxA = 0;
        int maxB = 0;

        for(int i=0;i<sizes.length;i++){
            int a = Math.max(sizes[i][0], sizes[i][1]);
            int b = Math.min(sizes[i][0], sizes[i][1]);

            maxA = Math.max(a, maxA);
            maxB = Math.max(b, maxB);
        }

        return maxA * maxB;
    }
}
