/**
 * @author nakhoonchoi
 * @date 2025/10/09
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/150364
 * @caution
 * [고려사항]
 * 💡 IDE를 이용하지 않고 문제를 풀었다.(프로그래머스 웹 버전에서)
 *
 * 우선, 레벨 4의 어려운 문제였다.
 * 1,2,3 숫자만 쌓을 수 있다는 점을 고려해야한다.
 * 완전 탐색으로 모든 경우의 수를 탐방하게 된다면 숫자를 얼만큼 떨어뜨려야하는 지 판별하기 어려울 것이라고 생각했다.
 *
 * 우선 target 별로 1,2,3을 이용해서 합이 target이 되도록 합산할 때 최소 방문 횟수와 최대 방문 횟수를 미리 계산했다.
 *
 * 다음으로 부모와 자식 노드를 연결해주었다.
 * 노드 클래스에는 index와 자식 노드들을 관리할 childNodes 리스트, 그리고 어떤 자식 노드를 탐방할 차례인지 관리할 curTurn을 가지도록 했다.
 * (현재 turn % 자식 노드 리스트의 크기) 모듈러 연산을 기반으로 자식 노드로 향하는 길을 표시했다.
 *
 * 그래서 전체 차례(turn)대로 어떤 리프 노드에 방문(도달)하는 지 체크해서 리프 노드 별로 방문 횟수를 체크해주었다.
 * 그리고 현재 방문 횟수를 기준으로 target에 도달할 수 없는지, target을 시도할 만 한지 판별해서 answer 배열을 반환했다.
 *
 * - target에 도달할 수 없는 경우 판별법
 *   전체 차례에서 방문한 index에 대한 현재 방문 횟수가 target 별 최대 허용 방문 횟수보다 높다면
 *   더 방문하더라도 target에 도달할 수 없다고 판단해서 {-1}을 반환했다.
 *
 * - target에 시도할 수 있는 경우 판별법
 *   targetVisitCount 배열에 리프 노드들의 현재 방문 횟수를 관리했다.
 *   모든 리프 노드에 대해서 현재 방문 노드가 최소와 최대 방문 횟수 사이에 위치한다면
 *   target에 시도할 수 있는 차례라고 판단해서 계산했다.
 *
 * - 시도할 수 있는 경우에는 answer 배열을 뽑아야한다.
 *   visitRoute 리스트에 문제 첫 번째 예제 기준 [4, 8, 7, 9, 4, 10, 7, 8, 4, 9, 7, 10...] 로
 *   리프 노드 방문 순서가 저장되어있을 것이다. 위의 방문 순서대로 1,2,3 숫자를 하나씩 채워야 한다.
 *   사전 순 순서 상으로 작은 숫자부터 채우는 것이 유리하기 때문에 맨 앞에 1,2,3 순으로 채울 수 있는 가장 작은 숫자를 채택한다.
 *   채택한 수를 채웠다고 가정하고 남은 횟수와 남은 target 숫자를 기준으로 1,2,3 숫자를 가지고 채울 수 있는 지 계산해서 효율적인 숫자를 채운다.
 *
 *   아래에서도 설명되었지만 리프 노드 4 인덱스에 대한 target이 6이고, 남은 방문 횟수가 3일 때,
 *   ex( [4, o, o, o, 4, o, o, o, 4, o...] )
 *   각 횟수 별로 [2,2,2]를 배분하는 것보다 [1,2,3]을 배분해서 '사전 순서의 앞'을 고려해야한다.
 *
 * 주의할 점이 많았다.
 * ⚠️ 6이라는 target을 기회 3번에 맞추려면 {2, 2, 2}보다는 {1, 2, 3}이 사전 순으로 유리하다.
 * ⚠️ 리프 노드에 대한 target 값이 0이라면 절대 도달할 수 없는 target이므로 바로 [-1]을 반환한다.
 * ⚠️ 리프 노드 방문에 대해 규칙과 주기가 있는데 주기를 고려하지 않고 풀었다.
 * (전체 turn을 550까지 돌고 target을 못 찾는다면 {-1}을 반환했다.)
 * (다행히 노드의 개수가 100개로 적기 때문에 계속 탐색하더라도 AC를 받을 수 있었던 것 같다.)
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2023 KAKAO BLIND RECRUITMENT> '1,2,3 떨어뜨리기'

public class Programmers150364 {
    Map<Integer, Node> nodeMap;
    List<Integer> visitRoute;
    int [] targetVisitCount;
    int [] targetMinVisitCount;
    int [] targetMaxVisitCount;
    final int ROOT = 1;

    public int[] solution(int[][] edges, int[] target) {
        nodeMap = new HashMap<>();
        visitRoute = new ArrayList<>();
        targetVisitCount = new int[target.length];
        targetMinVisitCount = new int[target.length];
        targetMaxVisitCount = new int[target.length];

        for(int i=0;i<target.length;i++){
            targetMinVisitCount[i] = (int) Math.ceil((double) target[i] / 3);
            targetMaxVisitCount[i] = target[i];
        }

        for(int i=0;i<edges.length;i++){ //edge 기반으로 그래프 연결
            int parent = edges[i][0];
            int child = edges[i][1];

            Node parentNode = nodeMap.getOrDefault(parent, new Node(parent - 1));
            Node childNode = nodeMap.getOrDefault(child, new Node(child - 1));

            parentNode.addChild(childNode);
            parentNode.childNodeSort();

            nodeMap.put(parent, parentNode);
            nodeMap.put(child, childNode);
        }

        for(int i=0;i<550;i++){ //TODO 주기를 기준으로 탐색
            int index = findNextVisitIndex(nodeMap.get(ROOT));

            if(target[index] == 0){ //리프 노드인데 target이 0인 경우
                return new int[]{-1};
            }

            if(targetVisitCount[index] > targetMaxVisitCount[index]){ //최대 허용 가능한 방문 카운트보다 현재 카운트가 높아져서 target 대로 절대 맞출 수 없을 때
                return new int[]{-1};
            }

            if(isPossible(target)){
                int [] answer = new int[visitRoute.size()];

                outer: for(int j=0;j<visitRoute.size();j++){
                    for(int k=1;k<=3;k++){
                        target[visitRoute.get(j)] -= k;

                        targetVisitCount[visitRoute.get(j)]--;

                        if(targetVisitCount[visitRoute.get(j)] <= target[visitRoute.get(j)] && (targetVisitCount[visitRoute.get(j)] >= (int) Math.ceil((double) target[visitRoute.get(j)] / 3))){
                            answer[j] = k;

                            continue outer;
                        }else{
                            target[visitRoute.get(j)] += k;

                            targetVisitCount[visitRoute.get(j)]++;
                        }
                    }
                }

                return answer;
            }
        }
        return new int[]{-1};
    }

    public boolean isPossible(int [] target){ //현재 방문 횟수 정보 기반으로 계산이 가능한 지 판별
        for(int i=0;i<target.length;i++){
            if(targetVisitCount[i] < targetMinVisitCount[i]){
                return false;
            }
        }

        return true;
    }

    public int findNextVisitIndex(Node node){ //다음 방문 리프 노드 인덱스 찾기
        if(node.childNodes.size() == 0){ //리프 노드일 때
            targetVisitCount[node.index]++;
            visitRoute.add(node.index);
            return node.index;
        }

        return findNextVisitIndex(node.childNodes.get((node.curTurn++) % node.childNodes.size()));
    }

    class Node implements Comparable<Node>{
        int index;
        int curTurn;
        List<Node> childNodes;

        Node(int index){
            this.index = index;
            this.curTurn = 0;
            this.childNodes = new ArrayList<>();
        }

        public void addChild(Node child){
            this.childNodes.add(child);
        }

        public void childNodeSort(){
            Collections.sort(childNodes);
        }

        public int compareTo(Node node){
            return Integer.compare(this.index, node.index);
        }
    }
}