/**
 * @author nakhoonchoi
 * @date 2023/10/30
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/150370?language=java
 * @mem
 * @time
 * @caution
 * [고려사항] Set은 순서가 보장이 안될 수 있기 때문에, List를 이용해서 풀어야 했던 문제... 레벨 1인데 시간 엄청 잡아먹었다. 로직은 다 맞았는데.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;

//프로그래머스 <카카오 2023 공채> - 개인정보 수집 유효기간
public class Programmers150370 {
    public static void main(String[] args) {
        String today = "2022.05.19";
        String [] terms = {"A 6", "B 12", "C 3"};
        String [] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answerList = new ArrayList<>();
        Map<String, Integer> termsMap = new HashMap<>();

        int todayValue = dateToInt(today);

        for(String term : terms){
            String [] arr = term.split(" ");
            termsMap.put(arr[0], Integer.parseInt(arr[1]));
        }

        for(int i=0;i<privacies.length;i++){
            String [] parseArr = privacies[i].split(" ");
            String standardDate = parseArr[0];
            String termsChar = parseArr[1];

            int dateValue = dateToInt(standardDate);
            long afterDateValue = dateValue + (28 * termsMap.get(termsChar));

            if(isExpire(todayValue, afterDateValue)){
                answerList.add(i+1);
            }
        }

        int [] answer = answerList.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static int dateToInt(String date){
        String [] dateArr = date.split("\\.");
        int year = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int day = Integer.parseInt(dateArr[2]);
        return year * 28 * 12 + month * 28 + day;
    }

    public static boolean isExpire(long standard, long date){
        return standard >= date;
    }
}