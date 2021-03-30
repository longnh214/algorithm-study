import java.util.Scanner;

public class Solution1946 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        char [] c;//문
        int n;//줄 수
        int [] k;//문자 수
        int count;//문자열 자리 수
        for(int t=1;t<=T;t++){
            count = 1;
            n = scan.nextInt();
            c = new char[n];
            k = new int[n];
            for(int i=0;i<n;i++){
                c[i] = scan.next().charAt(0);
                k[i] = scan.nextInt();
            }

            System.out.format("#%d\n",t);

            for(int i=0;i<n;i++){
                for(int j=0;j<k[i];j++){
                    System.out.print(c[i]);
                    count++;
                    if(count == 11) {
                        System.out.println();
                        count = 1;
                    }
                }
            }
            System.out.println();
        }
    }
}
