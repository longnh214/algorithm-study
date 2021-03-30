import java.util.Scanner;

public class Solution1970 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int money;
        int []unit;
        for (int t = 1; t <= T; t++) {
            unit = new int[8];
            money = scan.nextInt();
            money /= 10;
            money *= 10;
            while(money != 0){
                if(money >= 50000){
                    unit[0] = money / 50000;
                    money -= unit[0]*50000;
                }else if(money >= 10000) {
                    unit[1] = money / 10000;
                    money -= unit[1]*10000;
                }else if(money >= 5000){
                    unit[2] = money / 5000;
                    money -= unit[2]*5000;
                }else if(money >= 1000){
                    unit[3] = money / 1000;
                    money -= unit[3]*1000;
                }else if(money >= 500){
                    unit[4] = money / 500;
                    money -= unit[4]*500;
                }else if(money >= 100){
                    unit[5] = money / 100;
                    money -= unit[5]*100;
                }else if(money >= 50){
                    unit[6] = money / 50;
                    money -= unit[6]*50;
                }else if(money >= 10){
                    unit[7] = money / 10;
                    money -= unit[7]*10;
                }
            }
            System.out.format("#%d\n", t);
            for(int i=0;i<unit.length;i++){
                System.out.printf("%d ",unit[i]);
            }
            System.out.println();
        }
        scan.close();
    }
}
