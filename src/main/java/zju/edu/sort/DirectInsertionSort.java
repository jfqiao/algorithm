package zju.edu.sort;

/**
 * 简单排序算法之直接插入排序
 * 算法原理: 
 *    将序列中的第一个元素作为有序序列,然后将剩下的n-1个元素依次插入该有序序列,
 * 每插入一个元素, 该序列仍然保持有序, 经过n-1次插入后,整个序列有序.
 * 
 * 算法空间复杂度: 
 *    O(1)
 *     
 * 算法时间复杂度:
 *    最好: O(n)   原始序列有序
 *    最坏: O(n^2) 原始序列为非递增序列(相等或递减)
 *     
 * 算法稳定性:
 *     稳定: 如果第30行代码中改为小于或等于,则算法不稳定.
 *     
 * @author jfq created on 2018/06/28
 *
 */
public class DirectInsertionSort {
	
	public static void directInsertionSort(int[] nums) {
		// 从第0个元素开始,到第n - 1个元素结束
		for (int i = 0; i < nums.length - 1; i++) {
			// 从后向前比较是否当前元素是否小于前面的元素,如果大于或等于,则比较结束.
			for (int j = i; j >= 0; j--) {
				// 比较起始位置为 j + 1开始
				if (nums[j + 1] < nums[j]) {
					int tmp = nums[j + 1];
					nums[j + 1] = nums[j];
					nums[j] = tmp;
				} else
					break;
			}
		}
	}
}
