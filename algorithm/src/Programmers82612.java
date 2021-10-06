/**
 * @author nakhoon
 * @date Oct 6, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/82612
 * [고려사항]
 * 네이버 공채 코딩테스트 기출 문제이다. 재귀를 이용하여 풀 수 있었다.
 * [입력사항]
 * [출력사항]
 */
//프로그래머스 <위클리 챌린지 1주차> '부족한 금액 계산하기'
public class Programmers82612 {
	public long solution(int price, int money, int count) {
        long total = price * totalCount(count);
        long answer = total > money ? total - money : 0;
        return answer;
    }
    
    public long totalCount(int n){
        if(n == 0) return 0;
        else return totalCount(n-1) + n;
    }
}