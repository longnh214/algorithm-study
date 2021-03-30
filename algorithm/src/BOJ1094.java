import java.util.Scanner;

public class BOJ1094 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int count = 0;
        while(num>0){
            if(num>=64){
                num-=64;
            }else if(num>=32){
                num-=32;
            }else if(num>=16){
                num-=16;
            }else if(num>=8){
                num-=8;
            }else if(num>=4){
                num-=4;
            }else if(num>=2){
                num-=2;
            }else if(num>=1){
                num-=1;
            }
            count++;
        }
        System.out.println(count);
    }
}