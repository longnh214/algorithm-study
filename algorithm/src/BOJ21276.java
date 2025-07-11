/**
 * @author nakhoonchoi
 * @date 2025/07/11
 * @see https://www.acmicpc.net/problem/21276
 * @mem 152,108kb
 * @time 1,440ms
 * @caution
 * [고려사항]
 * 위상 정렬 문제였다.
 * 위상 정렬의 indegree를 설정할 때, 조상부터 자손 방향으로 count를 세주는 방법이 있고,
 * 자손에서 조상 방향으로 count를 세서 직속 관계(?)를 연결하는 방법이 있다.
 * ⚠️ 하지만 자손에서 조상 방향으로 count를 세서 탐색하면 직속 관계를 연결하는 데에 반례가 생긴다.
 * (indegree[조상]++ 을 하는 경우)
 *
 * 먼저 indegree Map을 이용해서 값이 0인 이름들을 모두 맨 윗 조상이라고 생각해서 갯수와 함께 출력했다.
 * 그리고 입력 받은 관계가 직속 관계일 지 연결이 된 관계일 지 모르기 때문에 adjMap에 연결 정보를 저장함과 동시에
 * indegreeMap 중 자손 쪽에 count를 1씩 올려주었다.
 * 예를 들어 자손에 sangho, 조상으로 예상되는 이름에 minji가 왔다면 indegreeMap[sangho]에 ++를 해준 것이다.
 *
 * adjMap에 연결 정보를 저장하고, indegree 값이 0인 이름부터 위상 정렬 탐색을 진행하면서(indegree 값을 깎으면서)
 * 다음 연결된 이름을 탐색할 때 indegree 값이 0이라면 직속 관계임을 childMap에 저장하면서 큐에 담아주었다.
 *
 * 위상 정렬 문제 재미있다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <위상 정렬> '계보 복원가 호석'

public class BOJ21276{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] names = br.readLine().split(" ");
        Map<String, Integer> indegreeMap = new TreeMap<>();
        Map<String, Set<String>> childMap = new TreeMap<>();
        Map<String, Set<String>> adjMap = new TreeMap<>();
        StringTokenizer st;

        for(String name : names){
            indegreeMap.put(name, 0);
            childMap.put(name, new TreeSet<>());
            adjMap.put(name, new TreeSet<>());
        }

        int M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            String X = st.nextToken();
            String Y = st.nextToken();

            adjMap.get(Y).add(X);
            indegreeMap.put(X, indegreeMap.get(X) + 1);
        }

        StringBuilder sb = new StringBuilder();
        Queue<String> q = new ArrayDeque<>();
        int count = 0;

        for(String key : indegreeMap.keySet()){
            if(indegreeMap.get(key) == 0){
                count++;
                sb.append(key).append(" ");
                q.offer(key);
            }
        }
        sb.insert(0, count + "\n");
        sb.deleteCharAt(sb.length()-1).append('\n');

        while(!q.isEmpty()){
            String cur = q.poll();
            for(String adjName : adjMap.get(cur)){
                indegreeMap.put(adjName, indegreeMap.get(adjName) - 1);

                if(indegreeMap.get(adjName) == 0){
                    q.offer(adjName);
                    childMap.get(cur).add(adjName);
                }
            }
        }

        for(String key : childMap.keySet()){
            sb.append(key).append(' ').append(childMap.get(key).size()).append(' ');
            for(String child : childMap.get(key)){
                sb.append(child).append(' ');
            }
            sb.deleteCharAt(sb.length() - 1).append('\n');
        }

        System.out.println(sb);
    }
}