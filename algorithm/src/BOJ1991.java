import java.util.*;
import java.io.*;
public class BOJ1991 {
    static Map<String, ArrayList<String>> map = new HashMap<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        while(N-->0){
            ArrayList<String> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();
            list.add(left);
            list.add(right);
            map.put(value,list);
        }
        VLR("A");//전위 순회
        System.out.println();
        LVR("A");//중위 순회
        System.out.println();
        LRV("A");//후위 순회
        System.out.println();
    }

    public static void VLR(String s){//전위 순회 - 루트 왼쪽 오른쪽
        if(s.equals(".")) return;

        System.out.print(s);
        VLR(map.get(s).get(0));
        VLR(map.get(s).get(1));
    }

    public static void LVR(String s){//중위 순회 - 왼쪽 루트 오른쪽
        if(s.equals(".")) return;

        LVR(map.get(s).get(0));
        System.out.print(s);
        LVR(map.get(s).get(1));
    }

    public static void LRV(String s){//후위 순회 - 왼쪽 오른쪽 루트
        if(s.equals(".")) return;

        LRV(map.get(s).get(0));
        LRV(map.get(s).get(1));
        System.out.print(s);
    }
}
