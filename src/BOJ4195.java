/**
 * @author choi
 * @date 2020. 8. 5
 * @see https://www.acmicpc.net/problem/4195
 * @mem 44,336kb
 * @time 456ms
 * @caution
 * [고려사항] HashMap과 union-find 알고리즘을 써야 맞을 수 있는 문제였다.
 *        union-find에 대해서 공부를 더 열심히 해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <최대 독립 집합> - '친구 네트워크'
public class BOJ4195 {
    static int[] disjointSet;
    static HashMap<String, Integer> names;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        while(T-->0) {
            int F = Integer.parseInt(br.readLine());
            int nowIndex = 1;
            disjointSet = new int[(2 * F) + 1];
            Arrays.fill(disjointSet, -1);
            names = new HashMap<String, Integer>();

            for(int i=0;i<F;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String first = st.nextToken();
                String second = st.nextToken();
                int size = 0;
                int firstKey, secondKey;

                if(names.containsKey(first)) {
                    firstKey = names.get(first);
                }else {
                    names.put(first, nowIndex);
                    firstKey = nowIndex++;
                }

                if(names.containsKey(second)) {
                    secondKey = names.get(second);
                }else {
                    names.put(second, nowIndex);
                    secondKey = nowIndex++;
                }

                size = -merge(firstKey, secondKey);

                sb.append(size).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    // 베스트 정답.
    // 초기 모든 노드 값을 -1로 설정
    // 부모 노드는 음수로서 자식노드들의 크기를 담고 있고, 자식 노드들은 부모 노드의 인덱스를 가지고 있음
    // 둘 다 부모 노드일 경우 값 비교를 통해 절댓값이 작은 부모 노드를 큰 부모 노드에 이어붙인다.
    // 굳이 자식 노드들 전부 변경하지 않고 부모 노드만 한 번 바꿔놓으면 어차피 find 함수를 통해 최상단 부모 노드를 찾을 수 있음
    // 그래서 크기 계산까지 가능하게 됨.
    private static int merge(int firstKey, int secondKey) {
        firstKey = find(firstKey);
        secondKey = find(secondKey);

        if(firstKey != secondKey) {
            if(disjointSet[firstKey] > disjointSet[secondKey]) {
                disjointSet[secondKey] += disjointSet[firstKey];
                disjointSet[firstKey] = secondKey;
            }
            else {
                disjointSet[firstKey] += disjointSet[secondKey];
                disjointSet[secondKey] = firstKey;
            }
        }

        return disjointSet[firstKey] < 0 ? disjointSet[firstKey] : disjointSet[secondKey];
    }

    // 루트 노드를 찾는 함수
    static int find(int index) {
        if(disjointSet[index] < 0) {    // 부모 노드의 값이 개수(음수)이기 때문에 이 코드는 사용할 수 없음
            return index;
        }
        return disjointSet[index] = find(disjointSet[index]);
    }
}