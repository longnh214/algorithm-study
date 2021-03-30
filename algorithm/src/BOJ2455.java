import java.util.Scanner;

public class BOJ2455 {
    public static void main(String[] args) {
        int customer = 0;//승객
        int max = 0;//최대값
        int a;//하차하는 승객
        int b;//승차하는 승객
        Scanner scan = new Scanner(System.in);
        for(int i=0;i<4;i++){
            a = scan.nextInt();
            b = scan.nextInt();
            max = Math.max(max,customer - a + b);
            customer = customer - a + b;
        }
        System.out.println(max);
    }
}