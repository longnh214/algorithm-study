/**
 * @author nakhoonchoi
 * @date 2025/10/10
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/150366
 * @caution
 * [고려사항]
 * 💡 IDE를 이용하지 않고 문제를 풀었다.(프로그래머스 웹 버전에서)
 *
 * 보니까 레벨 3이었네... 어려울만 했다.
 *
 * 단순하게 50*50의 String 배열로 나누어서 값을 관리하면 되겠다. 라고 생각했다.
 * MERGE와 UNMERGE를 보는 순간 어떻게 관리해야할 지 바로 보이진 않았으나 union-find를 떠올렸다.
 * union-find로 parent 배열과 값 배열을 관리한다면 풀 수 있을 것이라고 생각하고 바로 적용했다.
 *
 * 다행히 범위 union('1 1 3 4'를 입력 받았다면 (1, 1)부터 (3, 4)까지 전부 합치기)은 없기에
 * parent 배열과 value 배열은 union-find에 익숙한대로 1차원 배열로 진행했다.
 * ⚠️ 변환 방법 (r, c -> [r * 50 + c] / [index] -> index / 50, index % 50)
 *
 * ⚠️ 좌표 입력은 1부터 50 사이의 숫자들로 구성되어있기 때문에 코드에서는 -1을 해서 0부터 49로 관리하도록 했다.
 *
 * union-find의 설명은 간단하게 하도록 하겠다.
 * init으로 parent 배열의 값을 인덱스와 똑같게 기본 세팅했다.
 * getParent 메소드로 r, c에 대한 'parent 배열을 업데이트' 하면서 부모 인덱스 값을 반환하도록 했다.
 * union 메소드로 r1, c1, r2, c2를 r1, c1 좌표 기준으로 merge 하도록 구성했다.
 *
 * 번외로 union을 분리하는 unmerge 메소드도 구현했다.(자세한 건 아래에서)
 *
 * command에 따라 각각 설명을 남기려고 한다.
 * - UPDATE
 * -- 값을 변경 (UPDATE s1 s2)
 *    딱히 별 로직을 적용하지 않았고 value 배열을 순회하면서 s1인 값이 있다면 s2로 바꿔주었다.
 *
 * -- 좌표의 값을 특정 값으로 변경 (UPDATE r c s)
 *    입력 받은 r과 c에 대해 부모 인덱스를 구하고, 똑같은 부모를 가진(merge된) 셀에 대해서 s로 모두 업데이트를 시켜주었다.
 *
 * - PRINT (PRINT r c)
 *   입력 받은 r과 c에 대해 부모 인덱스를 구하고, 그 부모 인덱스에 대한 value가 비었다면 EMPTY를,
 *   값이 있다면 value를 answerList에 넣어주었다.
 *
 * - MERGE (MERGE r1 c1 r2 c2)
 *   union-find의 union을 적용했다. 두 좌표의 부모 인덱스를 얻어서 같다면 아무런 진행을 하지 않았고,
 *   다르다면 r2, c2 하위의 parent 배열 값들 모두 r1, c1의 부모 인덱스로 연쇄적으로 바꿔주어야 한다.
 *   (하지만 parent 배열을 순회하면서 r2, c2의 부모와 똑같다면 r1, c1 부모의 인덱스로 바꿔주었다. 2500 크기 배열 반복)
 *   그리고 parent 배열 값 뿐만 아니라 value의 값도 연쇄적으로 바꿔주어야했는데,
 *   위에서 부모 값을 갱신했다면 parent 값 기준으로 value도 반복문을 순회해서 update 시켜주었다.(updateByParent 활용)
 *   ⚠️ 주의 해야할 점은 r1, c1 기준 값이 null일 때, merge에 적용할 값은 r2, c2의 값이다.
 *
 * - UNMERGE (UNMERGE r c)
 *   union의 반대라고 생각했다. 우선 r, c의 부모 인덱스를 구하고, 그에 대한 값을 변수로 저장해놓는다.
 *   같은 부모를 가진 좌표들 모두 parent와 value를 초기화 시켰다.
 *   (초기화 로직 : parent[index] = index; value[index] = null;)
 *   초기화 한 뒤에 r, c에 대한 좌표에만 값을 남겨야하기 때문에 아래와 같이 값을 지정해주었다.
 *   value[r, c] = 'unmerge하기 전의 값'
 *
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2023 KAKAO BLIND RECRUITMENT> '표 병합'

public class Programmers150366 {
    String [] value;
    int [] parent;
    List<String> answerList;

    public String[] solution(String[] commands) {
        value = new String[50 * 50 + 1];
        parent = new int[50 * 50 + 1];
        answerList = new ArrayList<>();

        init();

        for(int i=0;i<commands.length;i++){
            String [] input = commands[i].split(" ");

            switch(input[0]){
                case "UPDATE":
                    if(input.length == 3){ // 값을 update
                        update(input[1], input[2]);
                    }else{ // 좌표의 값을 update
                        int r = Integer.parseInt(input[1]) - 1;
                        int c = Integer.parseInt(input[2]) - 1;

                        int parentIndex = getParent(r, c);

                        updateByParent(parentIndex, input[3]);
                    }

                    break;

                case "PRINT":
                    int r = Integer.parseInt(input[1]) - 1;
                    int c = Integer.parseInt(input[2]) - 1;

                    int parentIndex = getParent(r, c);

                    if(Objects.isNull(value[parentIndex])){
                        answerList.add("EMPTY");
                    }else{
                        answerList.add(value[parentIndex]);
                    }

                    break;

                case "MERGE":
                    union(Integer.parseInt(input[1]) - 1, Integer.parseInt(input[2]) - 1, Integer.parseInt(input[3]) - 1, Integer.parseInt(input[4]) - 1);
                    break;

                case "UNMERGE":
                    unmerge(Integer.parseInt(input[1]) - 1, Integer.parseInt(input[2]) - 1);
                    break;
            }
        }

        String[] answer = new String[answerList.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                sb.append(value[i * 50 + j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public void printParent(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                sb.append(parent[i * 50 + j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public void init(){ //union-find의 init
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
    }

    public void update(String s1, String s2){ //value를 순회하면서 s1의 값을 가졌다면 s2로 대체 (단순 반복문)
        for(int j=0;j<value.length;j++){
            if(Objects.nonNull(value[j]) && !value[j].isBlank() && value[j].equals(s1)){
                value[j] = s2;
            }
        }
    }

    public int getParent(int r, int c){ //union-find의 좌표 기반 부모 찾기
        if(parent[r * 50 + c] == r * 50 + c){
            return r * 50 + c;
        }
        return parent[r * 50 + c] = getParent(parent[r * 50 + c] / 50, parent[r * 50 + c] % 50);
    }

    public void union(int r1, int c1, int r2, int c2){ //union-find의 union(문제의 규칙을 잘 적용해야한다.)
        int parent1 = getParent(r1, c1);
        int parent2 = getParent(r2, c2);

        if(parent1 == parent2){
            return;
        }

        String value1 = value[parent1];
        String value2 = value[parent2];


        parent[r2 * 50 + c2] = parent1;

        for(int i=0;i<parent.length;i++){
            if(parent[i] == parent2){
                parent[i] = parent1;
            }
        }

        if(Objects.isNull(value1)){
            updateByParent(parent1, value2);
        }else{
            updateByParent(parent1, value1);
        }
    }

    public void updateByParent(int p, String s){ //특정 부모 인덱스를 가진 좌표들에 대해서 일괄로 값을 s로 대체한다.
        for(int i=0;i<value.length;i++){
            if(parent[i] == p){
                value[i] = s;
            }
        }
    }

    public void unmerge(int r, int c){ //union-find의 union과 반대되는 개념이라고 생각했다.
        int parentIndex = getParent(r, c);
        String valueStr = value[parentIndex];

        for(int i=0;i<parent.length;i++){
            if(parent[i] == parentIndex){
                parent[i] = i;
                value[i] = null;
            }
        }

        value[r * 50 + c] = valueStr;
    }
}