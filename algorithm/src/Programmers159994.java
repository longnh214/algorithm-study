/**
 * @author nakhoon
 * @date 11/4/23
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/159994
 * @mem
 * @time
 * @caution
 * [고려사항] goal 배열을 순회하면서 cards1과 cards2의 현재 인덱스에 대한 값에 포함되는 지 확인하고, 최대한 있는 개수만큼 판별한 뒤, 다 순회했을 때 각 인덱스의 합이 goal의 length 보다 낮다면 No, 같다면 Yes를 리턴했다.
 * [입력사항]
 * [출력사항]
 */

//프로그래머스 <연습문제> '카드 뭉치'
public class Programmers159994 {

    public static void main(String[] args) {
        String [] cards1 = {"i", "drink", "water"};
        String [] cards2 = {"want", "to"};
        String [] result = {"i", "want", "to", "drink", "water"};

        System.out.println(solution(cards1, cards2, result));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        boolean check = false;

        for (int i = 0; i < goal.length; i++){
            if (index1 < cards1.length && goal[i].equals(cards1[index1])) {
                index1++;
                check = true;
            }
            else if (index2 < cards2.length && goal[i].equals(cards2[index2])) {
                index2++;
                check = true;
            }
        }
        if (index1 + index2 < goal.length)
            return "No";

        return check ? "Yes" : "No";
    }
}
