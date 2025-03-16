/**
 * @author nakhoonchoi
 * @date 2025/03/16
 * @see https://boj.ma/16566
 * @mem 396,764kb
 * @time 1,584ms
 * @caution
 * [고려사항]
 * 문제를 읽고 이분 탐색과 관련된 문제라는 것을 바로 알았다.
 * N이 최대가 400만이기 때문에 NlogN의 알고리즘을 이용해야 1억으로 간당간당하게 통과할 것 같았다.
 *
 * 우선 이분 탐색을 이용해서 철수가 낸 카드보다 큰 수들 중 가장 작은 수를 upperBound를 통해 찾는다.
 * 이 때 left와 right의 기준은 chooseCard 배열 중에서 최적의 카드를 찾아야하기 때문에 0, M-1로 두고 upperBound를 구현했다.
 *
 *
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//백준 <분리 집합> '카드 게임'

public class BOJ16566 {
    static int N, M, K;
    static int [] chooseCard, parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        chooseCard = new int[M];
        parent = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            chooseCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(chooseCard);

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int target = Integer.parseInt(st.nextToken());
            int pickCard = upperBound(target);
            int upperBoundPickCard = getParent(pickCard);

            System.out.println(upperBoundPickCard);


            if(upperBoundPickCard != chooseCard[M-1]){
                union(upperBoundPickCard, upperBound(upperBoundPickCard));
            }
        }
    }

    public static int getParent(int target){
        if(parent[target] == 0){
            return target;
        }
        return parent[target] = getParent(parent[target]);
    }

    public static void union(int a, int b){
        int parentA = getParent(a);
        int parentB = getParent(b);

        if(parentA != parentB){
            parent[a] = parentB;
        }
    }

    public static int upperBound(int target){
        int left = 0;
        int right = M-1;
        int answer = chooseCard[M-1];

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(chooseCard[mid] > target){
                answer = chooseCard[mid];
                right = mid - 1;
            }else if(chooseCard[mid] < target){
                left = mid + 1;
            }else{
                answer = chooseCard[mid + 1];
                break;
            }
        }
        return answer;
    }
}