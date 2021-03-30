import java.util.Scanner;

public class Solution1954 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int [][] map;
        int value;
        int index;
        int size;
        for(int t=1;t<=T;t++){
            size = scan.nextInt();
            map = new int[size][size];
            value = 1;
            index = 0;
            int row,col;

            for(int i=size;i>0;i-=2){
                for(row = 0;row<i;row++){
                    map[index][index+row] = value++;
                }
                for(col = 1;col<i;col++){
                    map[index+col][size-index-1] = value++;
                }
                for(row = 1;row<i;row++){
                    map[size-index-1][size-row-index-1] = value++;
                }
                for(col = 1;col<i-1;col++){
                    map[size-index-col-1][index] = value++;
                }
                index++;
            }
            System.out.format("#%d\n",t);
            for(int i=0;i<size;i++){
                for(int j=0;j<size;j++){
                    System.out.format("%d ",map[i][j]);
                }
                System.out.println();
            }
        }
        scan.close();
    }
}