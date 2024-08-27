/**
 * @author nakhoonchoi
 * @date 2024/08/27
 * @see https://www.acmicpc.net/problem/20055
 * @mem 13,960kb
 * @time 276ms
 * @caution
 * [고려사항]
 * 대표적인 삼성 스타일의 구현 문제이다.
 * 사실 지문대로 풀면 그대로 풀리는 문제인데, 지문에 모호한 부분이 많았다. 그리고 함정도 많았던 문제이다.
 * 주의해야할 점을 먼저 얘기하면,
 * 1. 내구도를 입력 받자마자 0의 개수가 K개 이상이라면 1을 반환해야한다.
 * 2. '내리는 위치' 이 키워드가 모호한데, 내리는 위치의 인덱스는 '2*N'이 아니라 'N'이다.
 * 3. 로봇을 내리는 로직은 1번 로직, 2번 로직에 각각 적용되어야한다.
 * 4. 그리고 로봇을 내리는 로직은 내리는 위치에 도달하면 '즉시' 내려야한다.
 * 5. 그림은 회전하는 로직을 설명하기 위한 내용이다. 로봇의 이동과는 관련이 없다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <구현> '컨베이어 벨트 위의 로봇'

public class BOJ20055 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] strengthCheck = new int[2*N];
        boolean [] robotVisited = new boolean[2*N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<2*N;i++){
            strengthCheck[i] = Integer.parseInt(st.nextToken());
        }

        int level = 1;
        if(calKCount(strengthCheck) >= K){
            System.out.println(level);
            return;
        }
        while(true){
            //1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전한다.
            int strengthTemp = strengthCheck[2*N-1];
            boolean robotTemp = robotVisited[2*N-1];
            for(int i=2*N-1;i>=1;i--){
                if(i == N-1){ //내리는 위치 로직
                    robotVisited[i] = false;
                    strengthCheck[i] = strengthCheck[i-1];
                    continue;
                }
                robotVisited[i] = robotVisited[i-1];
                strengthCheck[i] = strengthCheck[i-1];
            }
            strengthCheck[0] = strengthTemp;
            robotVisited[0] = robotTemp;

            //2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
            // - 로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며, 그 칸의 내구도가 1 이상 남아 있어야 한다.
            strengthTemp = strengthCheck[2*N-1];
            robotTemp = robotVisited[2*N-1];
            for(int i=2*N-1;i>=1;i--){
                if(!robotVisited[i] && robotVisited[i-1] && strengthCheck[i] > 0){
                    if(i != N-1){ //내리는 위치 로직
                        robotVisited[i] = robotVisited[i-1];
                    }else{
                        robotVisited[i] = false;
                    }
                    robotVisited[i-1] = false;
                    strengthCheck[i]--;
                }
            }

            if(!robotVisited[0] && robotTemp && strengthTemp > 0){
                robotVisited[0] = robotTemp;
                strengthCheck[0]--;
            }

            //3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
            if(strengthCheck[0] > 0){
                robotVisited[0] = true;
                strengthCheck[0]--;
            }

            //4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
            if(calKCount(strengthCheck) >= K){
                break;
            }
            level++;
        }
        System.out.println(level);
    }

    public static int calKCount(int [] strengthCheck){
        return (int) Arrays.stream(strengthCheck).filter(i -> i == 0).count();
    }
}