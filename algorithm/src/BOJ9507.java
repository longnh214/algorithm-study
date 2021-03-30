import java.util.Scanner;

public class BOJ9507 {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        long [] koong = new long[75];

        for(int i=0;i<koong.length;i++){
            if(i<2)
                koong[i] = 1;
            else if(i==2)
                koong[i] = 2;
            else if(i==3)
                koong[i] = 4;
            else
                koong[i] = koong[i-1] + koong[i-2] + koong[i-3] + koong[i-4];
        }

        for(int t=1;t<=T;t++){
            int n = scan.nextInt();
            System.out.println(koong[n]);
        }
    }
}

