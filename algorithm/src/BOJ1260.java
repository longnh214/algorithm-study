import java.util.*;

public class BOJ1260 {
    public static void dfs(int [][] arr, boolean [] visited, int v){//(인접행렬, 방문여부, 정점)
        int n = arr.length - 1;
        visited[v] = true;
        System.out.print(v + " ");
        for(int i=1;i<=n;i++){
            if(arr[v][i] == 1 && !visited[i])
                dfs(arr,visited,i);
        }
    }

    public static void dfs(int [][] arr, boolean [] visited, int v, boolean flag){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length - 1;

        stack.push(v);
        visited[v] = true;
        System.out.print(v + " ");

        while(!stack.isEmpty()){
            int vv = stack.peek();

            flag = false;

            for(int i=1;i<=n;i++){
                if(arr[vv][i] == 1 && !visited[i]){
                    stack.push(i);
                    System.out.print(i + " ");
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                stack.pop();
            }
        }
    }

    public static void bfs(int [][] arr, boolean [] visited, int v){
        Queue<Integer> q = new LinkedList<>();
        int n = arr.length - 1;

        q.add(v);
        visited[v] = true;

        while(!q.isEmpty()){
            v = q.poll();
            System.out.print(v + " ");
            for(int i=1;i<=n;i++){
                if(arr[v][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();//정점의 개수
        int [][] arr = new int[index+1][index+1];
        int m = scan.nextInt();//간선의 개수
        int startPoint = scan.nextInt();
        boolean [] visited = new boolean[index+1];

        for(int i=0;i<m;i++){
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            arr[v1][v2] = 1;
            arr[v2][v1] = 1;
        }

        //dfs(arr,visited, startPoint);
        dfs(arr, visited, startPoint, true);
        System.out.println();
        Arrays.fill(visited,false);
        bfs(arr, visited, startPoint);

        scan.close();
    }
}