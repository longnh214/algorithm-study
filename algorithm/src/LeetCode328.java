/**
 * @author nakhoonchoi
 * @date 2024/12/30
 * @see https://leetcode.com/problems/odd-even-linked-list/
 * @mem 44.54MB
 * @time 0ms
 * @caution
 * [고려사항]
 * 앞선 LeetCode2130 문제를 통해 링크드리스트의 포인터를 고려해서 풀 수 있다는 것을 알았다.
 * 홀수 인덱스의 노드를 담을 ListNode 맨 앞과, 짝수 인덱스의 노드를 담을 ListNode 맨 앞을 각각 선언한 뒤에,
 * 규칙에 맞게 홀수번, 짝수번 인덱스의 노드를 odd, even의 next에 적절히 대입해주면 되었다.
 *
 * 마지막에 odd의 next를 even 노드의 맨 앞과 연결시켜준다면 AC를 받는다.
 *
 * oddEvenList2 메소드는 내가 푼 로직을 더 깔끔하게 한 버전으로 다른 분의 풀이를 참고했다.
 * head를 갱신시키지 않고, odd와 even만 갱신시킨다면 더 깔끔하게 문제를 해결할 수 있었다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'Odd Even Linked List'

public class LeetCode328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }

        ListNode oddStart = head;
        ListNode odd = oddStart;
        ListNode evenStart = head.next;
        ListNode even = evenStart;
        head = head.next.next;

        while(head != null || head.next != null){
            odd.next = head;
            even.next = head.next;

            odd = odd.next;
            even = even.next;

            if(head.next != null && head.next.next == null){
                break;
            }else if(head.next == null){
                break;
            }
            head = head.next.next;
        }
        odd.next = evenStart;

        return oddStart;
    }

    public ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
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