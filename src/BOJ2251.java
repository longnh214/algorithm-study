import java.util.*;

public class BOJ2251 {
    static boolean [][] checked;
    static ArrayList<Integer> al = new ArrayList<>();
    static int A;
    static int B;
    static int C;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        A = scan.nextInt();
        B = scan.nextInt();
        C = scan.nextInt();

        checked = new boolean[A+1][B+1];
        bfs(new Status(0,0,C));

        Collections.sort(al);
        for(int i : al){
            System.out.format("%d ",i);
        }
    }

    public static class Status{
        int a;
        int b;
        int c;
        Status(int a, int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void bfs(Status s){
        Queue<Status> q = new LinkedList<>();
        q.add(s);

        while(!q.isEmpty()){
            Status temp = q.poll();
            if(checked[temp.a][temp.b])
                continue;
            checked[temp.a][temp.b] = true;
            //첫 번째 물통이 비어있다면 그 때 물통 c의 물의 양을 list에 저장
            if(temp.a == 0){
                al.add(temp.c);
            }
            //a->b로 물을 옮길 때
            if(temp.a + temp.b > B)
                q.add(new Status((temp.a + temp.b - B),B,temp.c));
            else
                q.add(new Status(0,temp.a + temp.b,temp.c));

            //a->c로 물을 옮길 때
            if(temp.a + temp.c > C)
                q.add(new Status((temp.a + temp.c - C),temp.b,C));
            else
                q.add(new Status(0,temp.b,temp.a + temp.c));

            //b->a로 물을 옮길 때
            if(temp.a + temp.b > A)
                q.add(new Status(A,(temp.a + temp.b - A),temp.c));
            else
                q.add(new Status(temp.a + temp.b,0,temp.c));

            //b->c로 물을 옮길 때
            if(temp.b + temp.c > C)
                q.add(new Status(temp.a,(temp.b + temp.c - C),C));
            else
                q.add(new Status(temp.a,0,temp.b + temp.c));

            //c->a로 물을 옮길 때
            if(temp.a + temp.c > A)
                q.add(new Status(A,temp.b,(temp.a + temp.c - A)));
            else
                q.add(new Status(temp.a + temp.c,temp.b,0));

            //c->b로 물을 옮길 때
            if(temp.b + temp.c > B)
                q.add(new Status(temp.a,B,(temp.b + temp.c - B)));
            else
                q.add(new Status(temp.a,temp.b + temp.c,0));
        }
    }
}