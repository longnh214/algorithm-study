import java.util.Scanner;

public class BOJ11054 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int [] arr = new int[size];
        int [] up = new int[size];
        int [] down = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = scan.nextInt();
        }
        //오름차순으로 up dp 배열에 저장
        for(int i=0;i<size;i++){
            up[i] = 1;
            for(int j=0;j<i;j++){
                if(arr[i] > arr[j])
                    up[i] = Math.max(up[i], up[j]+1);
            }
        }

        //끝부분부터 오름차순(반대)으로 down dp 배열에 저장
        for(int i=size-1;i>=0;i--){
            down[i] = 1;
            for(int j=size-1;j>i;j--){
                if(arr[i] > arr[j])
                    down[i] = Math.max(down[i], down[j]+1);
            }
        }
        //결과 값 저장 (왼쪽 오름차순 + 오른쪽 오름차순 - 1)
        int output = 0;
        for(int i=0;i<size;i++){
            output = Math.max(up[i] + down[i],output);
        }
        System.out.println(output - 1);
        scan.close();
    }
}