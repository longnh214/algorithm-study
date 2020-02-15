public class Programmers42576 {
    //Hash를 안썼을 때 2중 for문으로 짠 함수
    //O(n*n)으로 시간 초과
    public String solution(String[] participant, String[] completion) {
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
}
