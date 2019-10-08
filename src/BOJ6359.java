import java.util.Scanner;

public class BOJ6359 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int [] jail = new int[101];//각 감옥 방을 배열로 나타낸 것

        jail[1] = 0;//1번 방은 한번 열리고 그 다음부터는 절대 닫히지 않는다.

        for(int i=2;i<jail.length;i++){
            for(int j=2;j<=i;j++){
                if(i%j==0)
                    jail[i]++;//1을 제외한 약수의 개수만큼 ++
            }
        }

        for(int t=1;t<=T;t++){
           int room = scan.nextInt();//방의 개수
           int count = 0;//1을 제외한 약수가 짝수개인 개수
           for(int i=1;i<=room;i++){
               if(jail[i]%2 == 0)
                   count++;//개수를 count
           }
           System.out.println(count);
        }
    }
}
