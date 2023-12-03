/**
 * @author nakhoon
 * @date 12/3/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/12969
 * @mem
 * @time
 * @caution
 * [고려사항]
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

public class Programmers12969 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        printStar(a,b);
    }

    private static void printStar(int a, int b){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<b;i++){
            for(int j=0;j<a;j++){
                sb.append('*');
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
