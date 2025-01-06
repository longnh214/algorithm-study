/**
 * @author nakhoonchoi
 * @date 2025/01/06
 * @see https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
 * @mem 54.91MB
 * @time 4ms
 * @caution
 * [고려사항]
 * 릿코드 437번을 풀고 이 문제를 푸니 상대적으로 쉬웠다.
 * 처음이 아닌 length의 초기화를 0이 아니라 1로 해주어야했음이 주의점이었다.
 * [입력사항]
 * [출력사항]
 */
//LeetCode <LeetCode 75> 'Longest ZigZag Path in a Binary Tree'

public class LeetCode1372 {
    int answer = 0;
    public int longestZigZag(TreeNode root) {
        dfs(root, 0, false);

        return answer;
    }

    public void dfs(TreeNode cur, int length, boolean isLeft){
        if(cur == null){
            return;
        }

        answer = Math.max(answer, length);

        if(length == 0){
            dfs(cur.left, length + 1, true);
            dfs(cur.right, length + 1, false);
        }else if(isLeft){
            dfs(cur.left, 1, true);
            dfs(cur.right, length + 1, false);
        }else{
            dfs(cur.right, 1, false);
            dfs(cur.left, length + 1, true);
        }
    }
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