import java.util.Scanner;

public class Solution1948 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int [] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int month1,month2;
        int date1,date2;
        int value;

        for(int t=1;t<=T;t++){
            value = 1;
            month1 = scan.nextInt();
            date1 = scan.nextInt();
            month2 = scan.nextInt();
            date2 = scan.nextInt();

            value += (day[month1] - date1); //첫 번째 날짜 값 계산
            if(month1 != month2)//첫 번째 달과 두 번째 달이 다르다면
                value += date2; //두 번째 날짜 값 계산

            for(int i=month1+1;i<month2;i++){//첫 번째 달과 두 번째 달 사이의 값 계산
                value += day[i];
            }

            System.out.format("#%d %d\n",t,value);
        }
    }
}
