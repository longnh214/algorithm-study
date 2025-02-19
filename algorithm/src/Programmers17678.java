/**
 * @author nakhoonchoi
 * @date 2025/02/19
 * @see https://school.programmers.co.kr/learn/courses/30/lessons/17678
 * @caution
 * [고려사항]
 * 단순하게 생각하면 쉬운데, 복잡하게 생각하니 어려운 문제였다.
 * 마지막 버스까지 최대한 태우고, 마지막 버스가 비어있다면 마지막 버스의 출발 시각을 출력하고,
 * 마지막 버스가 꽉 찼다면 (탑승자 중 가장 늦은 탑승 시각 - 1)을 출력하면 되었다.
 *
 * 보통 시간을 문자열로 나타내는 문제는 시간 문자열을 int 형으로 변환하여 푸는 편이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//프로그래머스 <2018 Kakao Blind recruitment> '셔틀버스'

public class Programmers17678 {
    public String solution(int n, int t, int m, String[] timetable) {
        int answer = 0;

        PriorityQueue<Integer> waitingLine = new PriorityQueue<>();

        Arrays.stream(timetable).forEach(time -> waitingLine.offer(timeStrToInt(time)));

        int shuttleTime = timeStrToInt("09:00"); // 540
        int passengerTime = 0;

        for(int i=0;i<n-1;i++){ //마지막 버스 전까지 수행
            int passenger = 0;
            //로직 수행
            while(!waitingLine.isEmpty() && waitingLine.peek() <= shuttleTime && passenger < m){
                passengerTime = Math.max(waitingLine.poll(), passengerTime);
                passenger++;
            }

            if(waitingLine.isEmpty() && passenger < m){
                answer = shuttleTime;
            }

            shuttleTime += t;
        }

        //마지막 버스 로직 수행
        int passenger = 0;
        //로직 수행
        while(!waitingLine.isEmpty() && waitingLine.peek() <= shuttleTime && passenger < m){
            passengerTime = Math.max(waitingLine.poll(), passengerTime); //09:00 - 08:00 08:01 08:03
            passenger++;
        }

        if(passenger < m){
            answer = Math.max(shuttleTime, answer);
        }

        if(answer == 0){
            answer = Math.max(passengerTime - 1, answer);
        }

        return timeIntToStr(answer);
    }

    public int timeStrToInt(String time){
        int totalTime;

        int hour = Integer.parseInt(time.split(":")[0]);
        int minute = Integer.parseInt(time.split(":")[1]);

        totalTime = (hour * 60) + minute;

        return totalTime;
    }

    public String timeIntToStr(int time) {
        int hour = time / 60;
        int minute = time % 60;

        return String.format("%02d:%02d", hour, minute);
    }
}