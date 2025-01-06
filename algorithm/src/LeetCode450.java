/**
 * @author nakhoonchoi
 * @date 2025/01/06
 * @see https://leetcode.com/problems/delete-node-in-a-bst/description/
 * @mem 45.93MB
 * @time 0ms
 * @caution
 * [고려사항]
 * <참고했던 테스트 케이스>
 * [0], 0 -> []
 * [5,3,6,2,4,null,7], 5 -> [6,3,7,2,4,null,null]
 *
 * 일단 이 문제는 정답을 참고해서 풀었다.
 * 먼저 이진 트리가 중위 순회 정렬 방식으로 정렬되어있는 문제인지 몰랐다.
 *
 * 그래서 정렬이 되어있기 때문에 O(logN)으로 지워야하는 타겟 노드의 위치를 찾을 수 있다.
 * 현재 노드 기준으로 작으면 왼쪽, 크면 오른쪽에 위치하기 때문에 노드의 위치를 먼저 찾고,
 * 지워야하는 노드 기준으로 오른쪽 자식의 노드들 중 가장 작은 노드의 값을 가져와서 지워야하는 노드의 값을 바꿔주고,
 * deleteNode 메소드를 이용해서 해당 값의 노드를 지워준다.(남겨두면 중복이 생김.)
 *
 * 트리에서 원소의 삭제를 구현하는 문제인데 막상 코드로 구현하려니 어려웠다.
 * 자료구조 패키지에 의존하지 않고 직접 구현해보는 연습을 해야겠다.
 * [입력사항]
 * [출력사항]
 */
import java.io.*;
import java.util.*;
//LeetCode <LeetCode 75> 'Delete Node in a BST'

public class LeetCode450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode minNode = findMin(root.right);

                root.val = minNode.val;

                root.right = deleteNode(root.right, minNode.val);
            }
        }

        return root;
    }

    // 현재 위치 중 오른쪽 중 가장 작은 값을 찾기 위한 메소드
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
//    public TreeNode deleteNode(TreeNode root, int key) {
//        return root;
//    }
//
//    public static void bfs(TreeNode root, int key){
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//
//        while(!q.isEmpty()){
//            TreeNode cur = q.poll();
//
//            if(cur.left != null){
//                if(cur.left.val == key){
//                    //cur.left가 양쪽 자식이 없을 경우.
//                    if(cur.left.left == null && cur.left.right == null){
//                        cur.left = null;
//                    }else if(cur.left.left != null){
//                        //cur.left가 왼쪽 자식이 있을 경우
//                        cur.left = cur.left.left;
//                    }else if(cur.left.right != null){
//                        //cur.left가 오른쪽 자식이 있을 경우
//                        cur.left = cur.left.right;
//                    }else{
//                        //자식이 둘 다 있을 경우
//                        TreeNode temp = cur.left.right;
//                        cur.left = cur.left.left;
//                        cur.left.right = temp;
//                    }
//                    break;
//                }
//
//                q.offer(cur.left);
//            }
//
//            if(cur.right != null){
//                if(cur.right.val == key){
//                    if(cur.right.left == null && cur.right.right == null){
//                        cur.right = null;
//                    }else if(cur.right.left != null){
//                        cur.right = cur.right.left;
//                    }else if(cur.right.right != null){
//                        cur.right = cur.right.right;
//                    }else{
//                        //자식이 둘 다 있을 경우
//                        TreeNode temp = cur.right.left;
//                        cur.right = cur.right.left;
//                        cur.right.left = temp;
//                    }
//                    break;
//                }
//
//                q.offer(cur.right);
//            }
//        }
//
//    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
