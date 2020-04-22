import java.util.*;
//프로그래머스 코딩테스트 연습 <DFS/BFS> - '여행경로' 문제
public class Programmers43164 {
    static List<String> list = new ArrayList<>();
    static String route = "";
    static boolean[] visit;

    private static void dfs(String[][] tickets, String end, int cnt) {
        //end문자열을 차곡차곡 모아 list에 저장하기 위한 temp 변수 route
        route += end + ",";

        if(cnt == tickets.length) {
            list.add(route);
            return;
        }

        for(int i = 0; i < tickets.length; i++) {
            String s = tickets[i][0];
            String e = tickets[i][1];
            if(s.equals(end) && !visit[i]) {
                visit[i] = true;
                dfs(tickets, e, cnt + 1);
                visit[i] = false;
                //end 문자열을 제거해줘야한다. 나라코드+,은 총 길이 4
                route = route.substring(0, route.length()-4);
            }
        }
    }

    public static String[] solution(String[][] tickets) {
        for(int i = 0; i < tickets.length; i++) {
            visit = new boolean[tickets.length];
            String start = tickets[i][0];
            String end = tickets[i][1];
            //무조건 시작은 인천
            if(start.equals("ICN")) {
                route = start + ","; visit[i] = true;
                dfs(tickets, end, 1);
            }
        }
        //성립되는 모든 경우의 수 리스트 중에 가장 사전 식 정렬에서 앞으로 오는 index를 뽑아야 하므로 sort
        Collections.sort(list);
        String[] answer = list.get(0).split(",");

        return answer;
    }
    public static void main(String[] args) {
        //String [][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        //String [][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String [][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" },{ "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
        for(String s : solution(tickets)){
            System.out.println(s);
        }
    }
}
