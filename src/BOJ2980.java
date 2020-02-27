import java.util.*;

public class BOJ2980 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int L = scan.nextInt();
        TrafficLight [] road = new TrafficLight[L+1];
        for(int i=0;i<N;i++){
            road[scan.nextInt()] = new TrafficLight(scan.nextInt(),scan.nextInt());
        }

        int time = 0;
        int position = 0;

        while(position < L){
            ++time;
            ++position;
            //신호등이 있을 때
            if(road[position] != null){
                //시간을 (R+G)로 나눈 나머지가 R보다 작거나 같으면
                //R에서 시간을 (R+G)로 나눈 나머지를 뺀 만큼 시간이 지난 뒤에야 신호등을 통과할 수 있다.
                if(time % (road[position].R + road[position].G) <= road[position].R){
                    time += (road[position].R - (time % (road[position].R + road[position].G)));
                }
            }
        }
        System.out.println(time);
    }

    static class TrafficLight{
        int R;
        int G;
        TrafficLight(int R,int G){
            this.R = R;
            this.G = G;
        }
    }
}