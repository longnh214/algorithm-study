import java.util.*;
//백준 12101번 <?> - '1,2,3 더하기 2'
public class BOJ12101 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int K = scan.nextInt();

		List<String> [] dic = new ArrayList[12];
		for(int i=1;i<dic.length;i++) 
			dic[i] = new ArrayList<>();
		dic[1].add("1");
		dic[2].add("1+1");
		dic[2].add("2");
		dic[3].add("1+1+1");
		dic[3].add("1+2");
		dic[3].add("2+1");
		dic[3].add("3");
		
		for(int i=4;i<=N;i++) {
			for(int j=1;j<=3;j++) {
				for(int k=0;k<dic[i-j].size();k++)
					dic[i].add(j + "+" +dic[i-j].get(k));
			}
		}
		//System.out.println(dic[4].size());
		if(K > dic[N].size()) System.out.println(-1);
		else {
			System.out.println(dic[N].get(K-1));
		}
	}
}