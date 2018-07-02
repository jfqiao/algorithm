package zju.edu.sort;

/**
 * 简单排序算法之冒泡排序
 * 算法原理:
 *     首先扫描序列,比较相邻两个元素的大小,如果后面的元素小于前面的元素,则交换位置.经过一趟扫描后,
 * 序列中最大的元素移动到序列最后(即沉到最底下), 然后扫描剩下的n-1个元素. 经过n-1次扫描后,序列有序.
 * 如果在一次扫描过程中,未发生元素的交换,则说明序列已经有序,停止即可.
 * 
 * 空间复杂度
 *     O(1)
 * 时间复杂度:
 *     最好: O(n) 原序列为有序非递减序列,
 *     最坏: O(n^2) 原序列为有序非递增序列.
 *     
 * 稳定性:
 *     稳定
 * @author jfq created on 2018/06/28
 *
 */
public class BubbleSort {
	
	public static void bubbleSort(int[] nums) {
		// last 用来记录一次扫描的过程
		int i = nums.length - 1, last;
		while (i > 0) {
			last = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] > nums[j + 1]) {
					int tmp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = tmp;
					last = j;
				}
			}
			i = last;
		}
	}
}
