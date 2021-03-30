import java.util.Scanner;

public class Solution1945 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int num;
        int a,b,c,d,e;
        for (int t = 1; t <= T; t++) {
            a = b = c = d = e = 0;
            num = scan.nextInt();
            while(num % 2 == 0){
                a++;
                num/=2;
                if(num%2!=0)
                    break;
            }
            while(num % 3 == 0){
                b++;
                num/=3;
                if(num%3!=0)
                    break;
            }
            while(num % 5 == 0){
                c++;
                num/=5;
                if(num%5!=0)
                    break;
            }
            while(num % 7 == 0){
                d++;
                num/=7;
                if(num%7!=0)
                    break;
            }
            while(num % 11 == 0){
                e++;
                num/=11;
                if(num%11!=0)
                    break;
            }


            System.out.format("#%d %d %d %d %d %d", t,a,b,c,d,e);
            System.out.println();
        }
        scan.close();
    }
}