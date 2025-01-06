/**
 * @author nakhoonchoi
 * @date 2025/01/06
 * @see https://leetcode.com/problems/path-sum-iii/description/
 * @mem 51.73MB
 * @time 2,331ms
 * @caution
 * [고려사항]
 * 타 풀이에 비해 많이 비효율적으로 풀었다.
 * dfs를 이용해서 풀어야하는데
 * 지나온 노드의 수, 지나온 노드까지의 합을 가지고 있는 자료구조가 필요했기에
 * List를 계속 함수 내에서 가지고 있었고 갱신해주었다.
 * 외부에 Map을 선언해서 풀었다면 더 효율적으로 풀 수 있었을 것이다.
 * [입력사항]
 * [출력사항]
 */
import java.util.*;
//LeetCode <LeetCode 75> 'Path Sum III'

public class LeetCode437 {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, new ArrayList<>(), targetSum);

        return count;
    }

    public void dfs(TreeNode cur, List<Integer> list, int targetSum){
        List<Integer> newList = new ArrayList<>();

        if(cur != null){
            newList.add(cur.val);

            if(cur.val == targetSum){
                count++;
            }
        }else{
            return;
        }

        for(int sum : list){
            if(cur != null){
                if((cur.val > 0 && sum > Integer.MAX_VALUE - cur.val) || (cur.val < 0 && sum < Integer.MIN_VALUE - cur.val)) {
                    continue;
                }
                newList.add(sum + cur.val);

                if(sum + cur.val == targetSum){
                    count++;
                }
            }
        }

        dfs(cur.left, newList, targetSum);
        dfs(cur.right, newList, targetSum);
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