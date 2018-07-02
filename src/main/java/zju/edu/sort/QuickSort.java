package zju.edu.sort;

/**
 * 算法原理:
 *     对序列A[0]~A[n-1]中任意给定元素A[k],经过一趟排序后,序列为A[0]~A[i-1], A[k], A[i+1]~A[n-1],
 * 其中前一个序列的任意元素均小于或等于A[k], 后一个序列的元素均大于或等于A[k], 故A[k]将原序列分割为两个子序列,
 * 以后只需要分别对两个子序列进行如上操作,知道序列为空或只有一个元素,最后得到有序序列.
 *     算法的思想采用了分而治之的思想,将原序列分为两个序列,每个单独处理,递归使用该方法,最后得到有序序列.
 *     
 * 空间复杂度: 
 * 		O(n) -- 算法在递归的过程中会创建堆栈用于保存递归调用的数据,嵌套调用的最大深度为n-1,因此空间复杂度为O(n).
 * 
 * 时间复杂度:
 *     最好: 没有最好
 *     最坏: O(n^2), 原序列有序时,算法时间复杂度最高
 *     平均: O(nlogn) 
 *     
 * 稳定性:
 *     不稳定 -- 算法排序过程中交换导致算法不稳定.
 * 
 * 算法实现:
 *     算法实现采用分治法, 用一个partition方法负责切分数组
 * 
 * 快速排序算法用到了分治法的策略,其原理可以在多种算法问题中使用到.
 * @author jfq created on 2018/06/28
 *
 */

public class QuickSort {
	
	public static void quickSort(int[] nums) {
		quickSort(nums, 0, nums.length - 1);
	}
	
	private static void quickSort(int[] nums, int start, int end) {
		// 将序列从start到end切分为两个序列,然后递归调用快速排序算法
		if (start < end) {
			int p = partition(nums, start, end);
			quickSort(nums, start, p - 1);
			quickSort(nums, p + 1, end);
		}
	}

	// partition将nums从start(包含)到end(包含)切分为两个序列,并且返回切分元素所在的索引.
	private static int partition(int[] nums, int start, int end) {
		// 用开始元素或末尾元素做分割都是可以的,这里选用末尾元素做分割
		int partitionNum = nums[end];
		int j = start - 1;     // 用来记录较小的元素的位置,开始时较小元素没有,因此初始化为起始位置的前面一个位置.
		for (int i = start; i < end; i++) {
			// 用最后一个元素最为分割元素,比较当前元素与分割元素的值,
			// 如果小于分割元素,则
			// 此处利用冒泡排序的思想,使得较小的元素向左边移动.
			if (nums[i] <= partitionNum) {
				j++;
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp;
			}
		}
		int tmp = nums[j + 1];
		nums[j + 1] = nums[end];
		nums[end] = tmp;
		return j + 1;
	}
}
