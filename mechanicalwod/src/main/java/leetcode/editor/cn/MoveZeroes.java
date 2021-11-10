package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1293 👎 0

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[] src = new int[]{0, 1, 0, 3, 12};
        solution.moveZeroes(src);
        System.out.println(Arrays.toString(src));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroesMethod01(int[] nums) {
            int zeroSize = 0;
            for (int i = 0; i < nums.length - zeroSize; i++) {
                if (nums[i] == 0) {
                    for (int j = i; j < nums.length - zeroSize - 1; j++) {
                        nums[j] = nums[j + 1];
                    }
                    nums[nums.length - zeroSize - 1] = 0;
                    zeroSize++;
                    i--;
                }
            }
        }
        public void moveZeroes(int[] nums) {
            int j = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[j] = nums[i];
                    if (i != j) {
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}