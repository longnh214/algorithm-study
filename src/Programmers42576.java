import java.util.*;

public class Programmers42576 {
    //Hash를 안썼을 때 2중 for문으로 짠 함수
    //O(n*n)으로 시간 초과
    public String solution1(String[] participant, String[] completion) {
        String answer = "";

        for(int i=0;i<participant.length;i++){
            for(int j=0;j<completion.length;j++){
                if(participant[i].equals(completion[j])){
                    participant[i] = null;
                    completion[j] = null;
                    break;
                }
            }
        }

        for(int i=0;i<participant.length;i++){
            if(participant[i] != null)
                answer += participant[i];
        }
        return answer;
    }
    //효율성 에러,  두 번째 생각한 방법
    //두 배열을 정렬한 후, 다르면 그 값을 출력하거나 끝까지 남은 part배열 마지막 값 출력
    //정렬은 안될 줄 알았는데 효율성 통과
    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for(i=0;i<completion.length;i++){
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[i];
    }
}
