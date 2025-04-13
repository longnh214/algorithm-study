import java.util.*;
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();


        for(int i=0;i<100000;i++){
            stack.add(i);
            stack2.push(i);
        }

        for(int num : stack){
            System.out.println(num);
        }
    }
}
