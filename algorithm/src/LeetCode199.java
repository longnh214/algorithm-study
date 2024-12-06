/**
 * @author nakhoonchoi
 * @date 2024/12/06
 * @mem 42.26mb
 * @time 1ms
 * @see https://leetcode.com/problems/binary-tree-right-side-view/?envType=study-plan-v2&envId=leetcode-75
 * @caution
 * [고려사항]
 * LeetCode를 처음 풀어봐서 당황했다. 기존 백준처럼 친절하게 입력값을 문자열로 주는 것이 아니라,
 * 객체로 입력값을 주기 때문에 입력을 받으면 처리해서 출력하는 '함수'를 만드는 느낌이었다.
 *
 * 프로그래머스와 느낌이 또 달라서 적응해야겠다.
 * [입력사항]
 * [출력사항]
 */

import java.util.*;
//LeetCode <LeetCode 75> 'Binary Tree Right Side View'

public class LeetCode199 {
    List<Integer> answerList = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return answerList;
    }
    public void bfs(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                TreeNode cur = q.poll();

                if(size == 0){
                    answerList.add(cur.val);
                }
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right);
                }
            }
        }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}