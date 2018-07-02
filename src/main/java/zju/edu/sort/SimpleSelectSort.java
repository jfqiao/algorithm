package zju.edu.sort;

/**
 * 简单排序算法之简单选择排序
 * 算法原理: 
 *    将初始序列(A[0] ~ A[n-1])作为待排序序列,第一趟扫描序列,找到最小的数,与A[0]进行交换,
 * 然后开始进行下一趟扫描,待排序序列为(A[1]~A[n-1]). 第i趟排序待排序序列为(A[i]~A[n-1]).经过n-1次排序后
 * 整个序列有序.
 * 
 * 算法空间复杂度: 
 *     O(1)
 * 算法时间复杂度:
 *   无论原始序列是否有序,算法都会扫描 n - 1趟,
 *   最好: O(n^2)
 *   最坏: O(n^2)
 *     
 * 算法稳定性:
 *     不稳定
 * 注: 算法稳定的意思是经过排序算法的重新排序,元素相同的项在序列中的相对位置不会发生改变,
 * @author jfq
 *
 */
public class SimpleSelectSort {
	
	public static void simpleSelectSort(int[] nums) {
		int minIndex;
		// 从开始元素开始扫描整个,i之前的序列已经是有序的了.
		for (int i = 0; i < nums.length - 1; i++) {
			minIndex = i;
			// 扫描从i到剩下的序列,找到最小的值,让它与i所在的位置进行交换
			for (int j = i + 1; j < nums.length; j++) {
				// 记录剩下的序列最小值的位置
				if (nums[j] < nums[minIndex])
					minIndex = j;
			}
			// 将A[i] 与最小值的位置进行值的交换.
			int tmp = nums[i];
			nums[i] = nums[minIndex];
			nums[minIndex] = tmp;
		}
	}
}
