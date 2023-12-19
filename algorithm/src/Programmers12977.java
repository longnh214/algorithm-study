/**
 * @author nakhoon
 * @date 12/19/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12977
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 조합 + 소수 알고리즘 문제였는데, temp 배열을 사용하는 대신 합을 저장하는 변수를 만들어 소수를 판별하였다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '소수 만들기'
public class Programmers12977 {
    static int answer;
    public static void main(String[] args) {
        int [] nums = {1,2,7,6,4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        comb(nums, 0, 0, 0);

        return answer;
    }

    private static void comb(int [] nums, int index, int count, int sum){
        if(count == 3){
            if(isPrime(sum)) {
                answer++;
            }
            return;
        }

        for(int i=index;i<nums.length;i++){
            sum += nums[i];
            comb(nums, i+1, count+1, sum);
            sum -= nums[i];
        }
    }

    private static boolean isPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
