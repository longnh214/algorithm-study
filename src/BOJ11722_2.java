import java.util.*;
public class BOJ11722_2 {

    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        int num=scanner.nextInt();
        //int array[]=new int[num];  //수열의 개수만큼 배열이 만들어짐,수열의개수->틀림
        //int answer[]=new int[num]; //수열의 최대길이 ->틀림
        int array[]=new int[1000];
        int answer[]=new int[1000];

        for(int i=0;i<num;i++) {
            array[i]=scanner.nextInt(); //0~num-1까지 배열넣어줌
        }

        answer[0]=1;   //수열의 길이는 기본적으로 1이다
        //현재배열의 마지막 인덱스보다 작은값이 이전인덱스배열에 있으면 길이 "+1"
        for(int j=1;j<num;j++) { //비교의 for문
            answer[j]=1;
            for(int k=0;k<j;k++)
                if(array[k]>array[j] && answer[k]+1>answer[j])
                    answer[j]=answer[k]+1;
        }
        int max=answer[0];
        for(int k=1;k<num;k++)
        {
            if(max<answer[k])
                max=answer[k];
        }
        System.out.println(max);
    }
}