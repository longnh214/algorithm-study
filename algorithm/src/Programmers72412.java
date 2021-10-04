/**
 * @author nakhoon
 * @date Oct 5, 2021
 * @see https://programmers.co.kr/learn/courses/30/lessons/72412
 * [고려사항]
 * 효율성 문제는 역시 어려웠다... 많은 부분을 생각해야했다.
 * 탐색할 때에 이분탐색(binarySearch) 메소드를 이용하는 습관을 들여야겠다고 생각했다.
 * 그리고 4*3*3*3개의 리스트를 만들어야할 때 리스트를 4차원 배열로 선언해서 4중 for문으로 리스트를 선언하는 것 보다
 * 선형으로 108개의 리스트를 선언해서 관리하는 것이 더 시간적으로 효율적이였다.
 * 그리고 해당 인덱스와 -(전체)에도 점수를 저장해야하므로 조합으로 -가 들어가는 부분도 처리를 해주어야한다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <카카오 2021 상반기 블라인드 공채> '순위 검색'
public class Programmers72412 {
	static List<List<Integer>>  dataList;
	static Map<String, Integer> wordMap = new HashMap<>();
	static int [] temp = new int[4];
	public static void main(String[] args) {
		String [] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String [] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		System.out.println(Arrays.toString(solution(info, query)));
	}
	
	public static int[] solution(String[] info, String[] query) {
		dataList = new ArrayList<>();
		listInit();
		mapInit();
		
		for(int i=0;i<info.length;i++) {
			String str = info[i];
			StringTokenizer st = new StringTokenizer(str);
			int language = wordMap.get(st.nextToken());
			int field = wordMap.get(st.nextToken());
			int career = wordMap.get(st.nextToken());
			int soulFood = wordMap.get(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			int [] indexArr = new int[4];
			indexArr[0] = language;
			indexArr[1] = field;
			indexArr[2] = career;
			indexArr[3] = soulFood;
			
			subset(indexArr,0,score);
		}
		
		listSort();
		int [] answer = new int[query.length];
		
		for(int i=0;i<query.length;i++) {
			String str = query[i];
			StringTokenizer st = new StringTokenizer(str);
			int language = wordMap.get(st.nextToken());
			st.nextToken();
			int field = wordMap.get(st.nextToken());
			st.nextToken();
			int career = wordMap.get(st.nextToken());
			st.nextToken();
			int soulFood = wordMap.get(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			int index = Collections.binarySearch(dataList.get(3*3*3*language + 3*3*field + 3*career + soulFood), score);
			if(index < 0) {
				index = -1 * (index + 1);
			}else {
				for(int j= index - 1;j >= 0; j--) {
					if(dataList.get(3*3*3*language + 3*3*field + 3*career + soulFood).get(j) == score) {
						index = j;
					}else {
						break;
					}
				}
			}
			
			answer[i] = dataList.get(3*3*3*language + 3*3*field + 3*career + soulFood).size() - index;
		}
		return answer;
	}
	
	public static void listInit() {
		for(int i=0;i<4*3*3*3;i++) {
			dataList.add(new ArrayList<>());
		}
	}
	
	public static void listSort() {
		for(int i=0;i<4*3*3*3;i++) {
			Collections.sort(dataList.get(i));
		}
	}
	
	public static void mapInit() {
		wordMap.put("-", 0);
		wordMap.put("cpp", 1);
		wordMap.put("java", 2);
		wordMap.put("python", 3);
		wordMap.put("backend", 1);
		wordMap.put("frontend", 2);
		wordMap.put("junior", 1);
		wordMap.put("senior", 2);
		wordMap.put("chicken", 1);
		wordMap.put("pizza", 2);
	}
	
	public static void subset(int [] indexArr, int cnt, int score) {
		if(cnt == 4) {
			dataList.get(3*3*3*temp[0] + 3*3*temp[1] + 3*temp[2] + temp[3]).add(score);
			return;
		}
		
		temp[cnt] = 0;
		subset(indexArr,cnt+1,score);
		temp[cnt] = indexArr[cnt];
		subset(indexArr,cnt+1,score);
	}
}