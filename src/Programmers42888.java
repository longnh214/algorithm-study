import java.util.*;
//프로그래머스 코딩테스트 연습 <2019 KAKAO BLIND RECRUITMENT> - '오픈채팅방' 문제
public class Programmers42888 {
    public static void main(String[] args) {
        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String [] log = solution(record);
        for(String s : log){
            System.out.println(s);
        }
    }

    public static String[] solution(String[] record) {
        //아이디, 닉네임을 저장하는 HashMap
        Map<String, String> dataMap = new HashMap<>();
        //for문을 한번 돌며 닉네임의 최종 변동 사항을 map에 저장
        for(int i=0;i<record.length;i++){
            String [] arr = record[i].split(" ");

            if(arr[0].equals("Enter")){
                dataMap.put(arr[1],arr[2]);
            }else if(arr[0].equals("Leave")){
                continue;
            }
            //Change
            else{
                dataMap.remove(arr[1]);
                dataMap.put(arr[1],arr[2]);
            }
        }
        //로그를 저장하는 List
        ArrayList<String> logList = new ArrayList<>();
        //최종 확정된 닉네임을 이용해 로그를 List에 저장
        for(int i=0;i<record.length;i++){
            String [] arr = record[i].split(" ");
            if(arr[0].equals("Enter")){
                logList.add(dataMap.get(arr[1]) + "님이 들어왔습니다.");
            }else if(arr[0].equals("Leave")){
                logList.add(dataMap.get(arr[1]) + "님이 나갔습니다.");
            }
            //Change
            else{
                continue;
            }
        }

        String [] answer = new String[logList.size()];

        for(int i=0;i<answer.length;i++){
            answer[i] = logList.get(i);
        }
        return answer;
    }
}