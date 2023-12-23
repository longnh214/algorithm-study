/**
 * @author nakhoonchoi
 * @date 2023/12/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/42889
 * @mem
 * @time
 * @caution
 * [고려사항]
 * 레벨 1 문제였는데... 꽤 구현력이 많이 필요했던 문제였다.
 * 먼저, Stage 객체에 대한 TreeSet으로 구현하려 했는데, Comparable 인터페이스를 구체화해서 compareTo를 선언할 때,
 * 비교 대상이 된 객체의 key 값이 중복된다면 Set에 저장되지 않는다는 것을 이번 문제를 통해서 알았다.
 * 그렇기 때문에 Set에서 List를 이용한 정렬로 수정하였다.
 *
 * 그리고 해당 level을 모두 통과할 경우에 대해서 예외 처리를 잘 해줘야했다.
 * 배열의 index, for문의 index를 잘 신경써주어야했다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <연습문제> '실패율'
public class Programmers42889 {
    public static void main(String[] args) {
        int N = 5;
        int [] stages = {2};
        System.out.println(Arrays.toString(solution(N, stages)));
    }

    public static int[] solution(int N, int[] stages) {
        List<Stage> stageList = new ArrayList<>();

        Arrays.sort(stages);
        int total = stages.length;
        int j = 0;
        for(int level=1;level<=N;level++){
            int failCount = 0;
            if(j == stages.length){
                stageList.add(new Stage(level, 0, total + 1));
            }
            for(;j<stages.length;j++){
                if(stages[j] > level){
                    stageList.add(new Stage(level, 0, total));
                    break;
                }else{
                    if(j < stages.length -1 && stages[j] == stages[j+1]){
                        failCount++;
                    }else{
                        failCount++;
                        stageList.add(new Stage(level, failCount, total));
                        j++;
                        break;
                    }
                }
            }
            total -= failCount;
        }
        Collections.sort(stageList);
        return stageList.stream().mapToInt(stage -> stage.level).toArray();
    }

    static class Stage implements Comparable<Stage>{
        int level;
        double failRate;

        Stage(int level, double failRate){
            this.level = level;
            this.failRate = failRate;
        }

        Stage(int level, int fail, int total){
            this.level = level;
            this.failRate = (double) fail / (double) total;
        }

        @Override
        public int compareTo(Stage o) {
            return Double.compare(this.failRate, o.failRate) * -1;
        }
    }
}
