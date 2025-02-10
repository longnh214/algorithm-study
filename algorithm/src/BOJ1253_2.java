/**
 * @author nakhoonchoi
 * @date 2025/02/10
 * @see https://boj.ma/1253
 * @mem 12,936kb
 * @time 116ms
 * @caution
 * [고려사항]
 * 투 포인터를 이용해서 문제를 풀었습니다.
 * 인덱스에 해당하는 배열의 숫자는 탐색에 건너뛰어야하기 때문에
 * 포인터를 옮기고 continue를 해서 탐색을 피하도록 구현하였습니다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <투 포인터> '좋다'

public class BOJ1253_2 {
    static int N;
    static int [] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<N;i++){
            if(isGood(i)){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static boolean isGood(int index) {
        int left = 0;
        int right = N-1;
        while(left < right){
            if(left == index){
                left++;
                continue;
            }
            if(right == index){
                right--;
                continue;
            }
            int sum = arr[left] + arr[right];

            if(sum > arr[index]){
                right--;
            }else if(sum < arr[index]){
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
}