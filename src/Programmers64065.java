import java.util.*;
//프로그래머스 코딩테스트 연습 <2019 카카오 개발자 겨울 인턴십> - '튜플' 문제
public class Programmers64065 {
    public static void main(String[] args) {
        String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        int [] answer = solution(s);
        for(int i : answer){
            System.out.println(i);
        }
    }

    public static int[] solution(String s) {
        //"{{1,2,3},{2,1},{1,2,4,3},{2}}"에서 앞 뒤의 중괄호 두개씩 자르고 },{를 /로 대체 결과 : "1,2,3/2,1/1,2,4,3/2"
        s = s.substring(2,s.length()-2).replace("},{", "/");
        String [] arr = s.split("/");
        //Comparator 객체를 이용한 특별한 정렬(String 길이 순으로 정렬)
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //return 뒤의 식 값이 음수이거나 같다면 o1,o2 순으로 저장, 양수라면 o2,o1 순으로 저장
                return o1.length() - o2.length();
            }
        });
        //정렬된 배열에서 순서대로 list에 원소값 있는 지 없는 지 확인해서 없으면 넣기
        ArrayList<Integer> list = new ArrayList<>();
        for(String str : arr){
            String [] index = str.split(",");

            for(int i=0;i<index.length;i++){
                int value = Integer.parseInt(index[i]);
                //원소값이 list에 없다면 list에 add
                if(!list.contains(value))
                    list.add(value);
            }
        }
        //list 값 배열로 옮기기
        int[] answer = new int[list.size()];
        for(int i=0;i<answer.length;i++)
            answer[i] = list.get(i);
        return answer;
    }
}