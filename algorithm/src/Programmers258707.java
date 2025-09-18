/**
 * @author nakhoonchoi
 * @date 2025/09/18
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/258707
 * @caution
 * [고려사항]
 * 💡 IDE를 이용하지 않고 문제를 풀었다.(프로그래머스 웹 버전에서)
 *
 * 우선 블랙잭처럼 카드의 합이 특정 숫자가 되도록 맞추는 최대의 경우의 수를 찾는 문제라고 생각했다.
 * 카드의 합이 되어야하는 숫자는 카드뭉치의 크기 + 1이라고 생각했고, 이를 MAGIC_NUMBER 라고 칭한다.
 *
 * 이 문제에서 생각해야하는 점은 크게 두 가지였다.
 * - 현재 집합에서 합이 MAGIC_NUMBER가 되는 짝을 어떻게 빨리 찾을 수 있을까
 *   (반복문 탐색은 비효율적이라고 생각했기에 다른 방법을 생각했다.)
 * - 어떻게 바로 카드를 버릴 지 coin을 써서 살릴 지(?) 판단할 수 있을까?
 *
 * 하나씩 아이디어를 남겨놓는다.
 * 먼저 '현재 집합에서 합이 MAGIC_NUMBER가 되는 짝을 어떻게 빨리 찾을 수 있을까'
 * 는 MAGIC_NUMBER 기준으로 반을 나눠서 반보다 작다면 음수 형태로 음수 집합에 저장,
 * 반보다 크거나 같다면 양수 형태로 양수 집합에 저장했다.
 * 만약 현재 카드가 7일 때, 음수 집합에 -7 형태로 저장된 '6'의 값이 있다면
 * 현재 집합에 7에 대한 짝이 있다고 판단할 수 있지 않을까 생각했다.
 * 반복문을 반복해서 짝을 찾는 것보다는 HashSet의 contains가 더 빠르지 않을까해서 아이디어를 적용했다.
 *
 * 그리고 '어떻게 바로 카드를 버릴 지 coin을 써서 살릴 지(?) 판단할 수 있을까'인데,
 * 이 부분을 해결하는 점이 굉장히 어렵고, 생각할 부분이 많았다.
 * 가장 먼저 중요하게 생각해야할 점은, 'coin을 적게 써서 최대한 많은 짝을 만들어내야한다.'이다.
 *
 * 현재 내가 가지고 있는 카드 집합이 있고,
 * 새로운 카드 n을 뽑았을 때 n과 패에서 짝을 만들 수 있다면 즉시 coin을 써서 채용했다.
 * 그리고 아니라면 버렸다.(실제로 버리진 않았고 dust의 양수 음수 집합에 나눠서 저장했다. 이유는 뒤에.)
 * dust 집합은 휴지통이라고 생각하면 된다. coin을 효율적으로 써서 짝을 만들 수 있다면 카드를 복원할 것이다.
 *
 * -----라운드 시작-----
 * 1. 카드를 뽑는다.(coin이 있을 때에만)
 * 1-1. 현재 카드 패와 합쳐서 짝을 만들 수 있다면 채용(cost는 coin 1개), 못 만든다면 휴지통으로 보낸다.
 *
 * 2. 합친 카드 패를 기준으로 짝을 만들어본다.
 * 2-1. 짝을 만들었다면 다음 라운드 진행
 * 2-2. 짝을 못 만들었다면 휴지통의 카드 중에 조합해서 짝을 만들어낼 수 있는지 확인한다.
 *      (휴지통의 카드를 복원하는 것은 이전 round에서 coin으로 카드를 버리지 않고 채용하는 것과 같기 때문에
 *      coin이 총 두 개 필요하다.)
 *      -> 이 부분은 코드 예제 2번 참고
 * 3. 짝을 만든 것이 확인되면 다음 라운드 진행
 *    최종적으로 못 만들었다면 라운드 종료
 * -----라운드 끝-------
 *
 * 💡 라운드 진행 시에 주의할 점이 있었다.
 * coin이 없다고 해서 라운드가 끝나는 것이 아니라 카드를 못 뽑을 뿐이다.
 * 라운드 종료 조건은 카드 패에서 짝을 못 만들었을 때다.
 *
 * 💡 휴지통에서 짝을 찾은 경우는 coin을 두 개 써서 짝을 만드는 것이기 때문에
 * 최후에 생각해야할 부분이다.(coin이 두 개 이상 남았다면)
 *
 * 처음에 문제를 제대로 이해하지 못해서 헷갈렸지만 재미있는 문제였다.
 * IDE 없이 sysout으로 디버깅하기는 쉽지 않다...
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2024 KAKAO WINTER INTERNSHIP> 'n + 1 카드게임'

public class Programmers258707 {
    int MAGIC_NUMBER;
    int n;
    Set<Integer> plusSet; //MAGIC_NUMBER의 절반 이상을 양수 그대로 저장할 집합
    Set<Integer> minusSet; //MAGIC_NUMBER의 절반 아래를 보수 형태(?)로 저장할 집합
    //MAGIC_NUMBER가 예시1과 같이 13이고, 6이 카드로 들어왔다면 -7이 minusSet에 저장된다.
    Set<Integer> dustPlusSet; //버릴 카드를 위와 같이 양수 형태로 저장할 집합(혹시 coin에 여유 있으면 살리려고)
    Set<Integer> dustMinusSet;

    public int solution(int coin, int[] cards) {
        int answer = 1;

        MAGIC_NUMBER = cards.length + 1;
        n = cards.length;

        plusSet = new HashSet<>();
        minusSet = new HashSet<>();
        dustPlusSet = new HashSet<>();
        dustMinusSet = new HashSet<>();

        for(int i=0;i<n/3;i++){
            if(cards[i] >= (MAGIC_NUMBER / 2) + 1){
                plusSet.add(cards[i]);
            }else{
                minusSet.add(cards[i] - MAGIC_NUMBER);
            }
        }

        int curIndex = n/3;

        outer: while(true){ //하나의 라운드
            if(curIndex == cards.length){
                break;
            }

            //카드를 두 장 뽑는다.(각 한 장 씩 유효한 카드일지 계산해서 채용한다. -> 계산을 한 번 해보자.)
            if(coin > 0) {
                for (int i = 0; i < 2; i++) {
                    int card = cards[curIndex++];

                    if (coin == 0) {
                        continue;
                    }

                    if (isInPair(card)) {
                        if (card >= (MAGIC_NUMBER / 2) + 1) {
                            plusSet.add(card);
                        } else {
                            minusSet.add(card - MAGIC_NUMBER); //6이면 -7을 저장.
                        }
                        coin--;
                    } else {
                        if (card >= (MAGIC_NUMBER / 2) + 1) {
                            dustPlusSet.add(card);
                        } else {
                            dustMinusSet.add(card - MAGIC_NUMBER); //6이면 -7을 저장.
                        }
                    }
                }
            }

            //현재 카드 패 중 짝이 만들어지는 지 확인한다.
            boolean flag = false;
            for(int plus : plusSet){
                if(minusSet.contains(plus * -1)){
                    plusSet.remove(plus);
                    minusSet.remove(plus * -1);

                    flag = true;
                    break;
                }
            }

            //휴지통에서 짝을 맞출 수 있을지 판별해서 맞출 수 있다면 flag를 true로 바꾼다.
            if(!flag){
                if(coin >= 2){
                    for(int dustPlus : dustPlusSet){
                        if(dustMinusSet.contains(dustPlus * -1)){
                            answer++;
                            dustPlusSet.remove(dustPlus);
                            dustMinusSet.remove(dustPlus * -1);
                            coin -= 2;
                            continue outer;
                        }
                    }
                }else{
                    break;
                }
            }

            //무슨 짓을 해도 짝을 만들 수 없다면 최종 round 종료.
            //만들었다면 다음 라운드 진행
            if(!flag){
                break;
            }else{
                answer++;
            }
        }

        return answer;
    }

    public boolean isInPair(int card){
        if(card < (MAGIC_NUMBER / 2) + 1){
            if(plusSet.contains(MAGIC_NUMBER - card)){
                return true;
            }
        }else{
            if(minusSet.contains(card * -1)){
                return true;
            }
        }

        return false;
    }
}