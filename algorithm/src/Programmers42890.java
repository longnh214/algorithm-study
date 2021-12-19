/**
 * @author nakhoon
 * @date Dec 19, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/42890
 * @caution
 * [고려사항]
 * Set의 containsAll 메소드를 통해 최소성을 만족하는 지 파악할 수 있었던 문제이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2019 카카오 공채> '후보키'
public class Programmers42890 {
	static List<Set<Integer>> candidateList;
	static String [][] table;
	static int size;
	static int answer;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		System.out.println(solution(relation));
	}
	
	public static int solution(String [][] relation) {
		table = relation;
		candidateList = new ArrayList<>();
		size = relation[0].length;
		
		for(int i=1;i<=size;i++) {
			makeKey(0,i,0,new HashSet<>());
		}
		
		return answer;
    }
	
	public static void makeKey(int index, int keySize, int count, Set<Integer> keySet) {
		if(count == keySize) {
			//계산
			if(isUnique(keySet)) {
				for(Set<Integer> candidateKey : candidateList) {
					if(keySet.containsAll(candidateKey)) {
						return;
					}
				}
				candidateList.add(keySet);
				answer++;
			}
			return;
		}
		
		for(int i=index;i<size;i++) {
			Set<Integer> newSet = new HashSet<>(keySet);
			newSet.add(i);
			makeKey(i, keySize, count+1, newSet);
		}
	}
	
	public static boolean isUnique(Set<Integer> set) {
		List<String> list = new ArrayList<>();
		for(int i=0;i<table.length;i++) {
			String str = "";
			for(int index : set) {
				str += table[i][index];
			}
			if(!list.contains(str)) {
				list.add(str);
			}else {
				return false;
			}
		}
		return true;
	}
}