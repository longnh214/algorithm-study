import java.util.*;
//문제 접근을 처음부터 잘못했던 문제.
public class BOJ1043 {
    static int N;
    static int M;
    static int K;
    static ArrayList<Integer> truth = new ArrayList<>();
    static boolean [] visited;
    static ArrayList<Integer> [] party; //각 파티마다 참가자를 저장하는 함수
    static ArrayList<Integer> [] people; //참가자들이 속한 파티를 저장하는 함수
    static int answer = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();//각 파티에 참가한 인원
        M = scan.nextInt();//파티 횟수
        K = scan.nextInt();//진실을 알고있는 참가자 수
        for(int i=0;i<K;i++){
            truth.add(scan.nextInt());
        }

        party = new ArrayList[M+1];
        for(int i=0;i<M+1;i++){
            party[i] = new ArrayList<>();
        }

        people = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            people[i] = new ArrayList<>();
        }
        visited = new boolean[M];
        for(int i=0;i<M;i++) {
            int participant = scan.nextInt();
            for (int j = 0; j < participant; j++) {
                int value = scan.nextInt();
                party[i].add(value);
                people[value].add(i);
            }
        }

        bfs();

        System.out.println(answer);
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        //큐에 진실을 알고있는 사람을 넣는다.
        for(int i=0;i<truth.size();i++){
            for(int j=0;j<people[truth.get(i)].size();j++){
                if(!visited[people[truth.get(i)].get(j)]){
                    visited[people[truth.get(i)].get(j)] = true;
                    q.add(people[truth.get(i)].get(j));
                }
            }
        }

        //진실을 아는 사람 앞에서 진실을 말했을 때 들었던 사람들이 허풍을 듣지 않기 위해 큐에 넣어준다.
        while(!q.isEmpty()){
            int value = q.poll();
            for(int i=0;i<party[value].size();i++){
                for(int j=0;j<people[party[value].get(i)].size();j++){
                    if(!visited[people[party[value].get(i)].get(j)]){
                        visited[people[party[value].get(i)].get(j)] = true;
                        q.add(people[party[value].get(i)].get(j));
                    }
                }
            }
        }

        for(int i=0;i<visited.length;i++){
            if(!visited[i])
                answer++;
        }
    }
}