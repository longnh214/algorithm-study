/**
 * @author nakhoonchoi
 * @date 2024/12/30
 * @see https://leetcode.com/problems/dota2-senate/description/
 * @mem 42.86MB
 * @time 7ms
 * @caution
 * [고려사항]
 * 문제를 번역해도 이해가 잘 안됐던 문제이다.
 *
 * Senate를 번역하면 '상원'이라고 나오던데, 투표로 생각하고 문제를 풀었다.
 *
 * 1. 현재 투표는, 바로 다음에 나올 상대방의 투표권 권리를 묵살시킬 수 있다.
 * 2. 투표권이 상대방에게는 이제 없고 나만 있다고 판단되면, 승리라도 판단할 수 있다.
 *
 * 로 해석되었는데, 선형으로 문자열의 왼쪽부터 오른쪽 방향으로 한 번만 탐색하면 되는 줄 알았다.
 * 하지만 모든 투표권이 유효될 때까지 탐색되어야했고, while문과 for문으로 2중 반복문을 통해 해결하였다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'Dota2 Senate'

public class LeetCode649 {
    public String predictPartyVictory(String senate) {
        int radiantCount = 0;
        int direCount = 0;

        boolean [] isVoted = new boolean[senate.length()];

        while(radiantCount < senate.length() && direCount < senate.length()){
            for(int i=0;i<senate.length();i++){
                if(isVoted[i]) continue;
                if(radiantCount == senate.length() && direCount == senate.length()){
                    break;
                }

                if(senate.charAt(i) == 'R'){
                    if(radiantCount < direCount) {
                        isVoted[i] = true;
                    }
                    radiantCount++;
                }else{
                    if(direCount < radiantCount) {
                        isVoted[i] = true;
                    }
                    direCount++;
                }
            }
        }

        return radiantCount == senate.length() ? "Radiant" : "Dire";
    }
}