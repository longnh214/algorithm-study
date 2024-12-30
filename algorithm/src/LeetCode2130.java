/**
 * @author nakhoonchoi
 * @date 2024/12/30
 * @see https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * @mem 67.86MB
 * @time 16ms
 * @caution
 * [고려사항]
 * 공간 복잡도를 고려하지 않고, 시간 복잡도 O(N), 공간 복잡도 O(N)으로 구현하였다.
 * Deque에 한 번 탐색하면서 모든 val을 담고, pollFirst와 pollLast를 통해 Twin index의 수 합 중 최대를 구하였다.
 *
 * 힌트의 fast 포인터, slow 포인터가 이해가 되지 않았는데 다른 풀이의 코드를 참고해서 이해했다.
 * slow 포인터를 이용해서 중간을 찾고,
 * prev는 중간 + 1부터 끝까지의 노드를 반대로 순회해서 기록한다.
 *
 * 마지막에 head, prev부터 시작하는 순회를 통해 Twin sum을 구할 수 있다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Maximum Twin Sum of a Linked List'

public class LeetCode2130 {
    public int pairSum(ListNode head) {
        int answer = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        ListNode cur = head;

        while(true){
            deque.offer(cur.val);
            if(cur.next != null){
                cur = cur.next;
            }else{
                break;
            }
        }

        while(!deque.isEmpty()){
            int first = deque.pollFirst();
            int last = deque.pollLast();

            answer = Math.max(first + last, answer);
        }

        return answer;
    }

    public int pairSum2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Get middle of the linked list.
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half of the linked list.
        ListNode nextNode, prev = null;
        while (slow != null) {
            nextNode = slow.next;
            slow.next = prev;
            prev = slow;
            slow = nextNode;
        }

        ListNode start = head;
        int maximumSum = 0;
        while (prev != null) {
            maximumSum = Math.max(maximumSum, start.val + prev.val);
            prev = prev.next;
            start = start.next;
        }

        return maximumSum;
    }
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
}