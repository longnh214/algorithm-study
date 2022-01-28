/**
 * @author nakhoon
 * @date Jan 28, 2022
 * @see https://programmers.co.kr/learn/courses/30/lessons/92341
 */
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//프로그래머스 <2022 카카오 공채> '주차 요금 계산'
public class Programmers92341 {
	static Map<String, String> inCheckTime;
	static Map<String, String> outCheckTime;
	static Map<String, Integer> totalTimeMap;
	static Map<Integer, Integer> feeMap;
	public static void main(String[] args) {
		int [] fees = {180, 5000, 10, 600};
		String [] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		System.out.println(Arrays.toString(solution(fees, records)));
	}
	
	public static int[] solution(int[] fees, String[] records) {
		inCheckTime = new HashMap<>();
		outCheckTime = new HashMap<>();
		totalTimeMap = new HashMap<>();
		feeMap = new HashMap<>();
		
		for(int i=0;i<records.length;i++) {
			String [] splitArr = records[i].split(" ");
			
			if(splitArr[2].equals("IN")) {
				inCheckTime.put(splitArr[1], splitArr[0]);
			}else {
				outCheckTime.put(splitArr[1], splitArr[0]);
				calTime(splitArr[1]);
				outCheckTime.remove(splitArr[1]);
				inCheckTime.remove(splitArr[1]);
			}
		}
		
		for(String carNum : inCheckTime.keySet() ) {
			if(inCheckTime.get(carNum) != null) {
				calTime(carNum);
			}
		}
		
		for(String carNum : totalTimeMap.keySet()) {
			feeMap.put(Integer.parseInt(carNum), getFee(totalTimeMap.get(carNum),fees));
		}
		
		List<Integer> sortCarNumList = new ArrayList<>(feeMap.keySet());
		Collections.sort(sortCarNumList);
		
		int [] answer = new int[sortCarNumList.size()];
		
		for(int i=0;i<answer.length;i++) {
			answer[i] = feeMap.get(sortCarNumList.get(i));
		}
		
        return answer;
    }
	
	public static void calTime(String carNum) {
			String inTime = inCheckTime.get(carNum) + ":00";
			String outTime = outCheckTime.getOrDefault(carNum, "23:59") + ":00";
			
			SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss", Locale.KOREA);
			
			Date inTimeDate = null;
			try {
				inTimeDate = f.parse(inTime);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Date outTimeDate = null;
			try {
				outTimeDate = f.parse(outTime);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			long diff = outTimeDate.getTime() -  inTimeDate.getTime();
			diff = diff / 1000 / 60;
			totalTimeMap.put(carNum, totalTimeMap.getOrDefault(carNum, 0) + (int)diff);
	}
	
	public static int getFee(int time, int [] fees) {
		int commonTime = fees[0];
		int commonFee = fees[1];
		int unitTime = fees[2];
		int unitFee = fees[3];
		
		int total = 0;
		
		if(time <= commonTime) {
			total += commonFee;
			time = 0;
		}else {
			total += commonFee;
			time -= commonTime;
		}
		
		if(time > 0) {
			total += ((time % unitTime == 0) ?  (time / unitTime) : (time / unitTime) + 1) * unitFee;
		}
		
		return total;
	}
}