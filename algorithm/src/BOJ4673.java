/**
 * @author nakhoon
 * @date 2022, 5월 12일
 * @see https://www.acmicpc.net/problem/4673
 * @mem 11,456kb
 * @time 76ms
 * @caution
 * [고려사항]
 * 1부터 10000까지 해당 수로 만들 수 있는 생성자를 모두 boolean 배열에 반영하고,
 * boolean 값이 false인 값들만 출력해주었다.
 * [입력사항]
 * [출력사항]
 */
//백준 <수학> '셀프 넘버'
public class BOJ4673 {
    public static void main(String[] args) {
        boolean [] check = new boolean[10001];

        for(int i=1;i<10001;i++){
            int n = d(i);

            if(n < 10001){
                check[n] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<10001;i++){
            if(!check[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb.substring(0, sb.length()-1));
    }

    public static int d(int number){
        int sum = number;

        while(number != 0){
            sum = sum + (number % 10); // 첫 째 자리수
            number = number/10;	// 10을 나누어 첫 째 자리를 없앤다
        }

        return sum;
    }
}