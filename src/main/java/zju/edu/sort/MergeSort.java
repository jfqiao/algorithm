package zju.edu.sort;
/**
 * 算法原理:
 *     将待排序的原始序列视作n个长度为1的有序序列,然后两两合并,得到n/2个长度为1或2的有序序列
 * 不断进行两两合并,知道得到一个长度为n的有序序列.(该算法的原理与快速排序的分治法刚好相反,归并
 * 排序的算法原理是从局部到整体,不断合并得到最终的结果)
 * 
 * 空间复杂度:
 *     两路归并排序需要额外的辅助空间来保存数组的值,
 *     其空间复杂度为:Ｏ(n).
 *     
 * 时间复杂度:
 *     数组合并次数不超过log(n), 每次都要扫描n个元素,因此时间复杂度是:
 *     O(nlog[n]).
 * 
 * 稳定性:
 *     两路归并排序没有直接交换元素位置，是一种稳定的排序．
 *     
 * @author jfq
 *
 */
public class MergeSort {
	public static void mergeSort(int[] nums) {
		// 初始化时是长度为1的序列,两两进行合并, 合并完成后再次合并的序列长度乘以2. 
		int size = 1;
		int[] dst = new int[nums.length];
		while (size < nums.length) {
		    int start = 0;
		    // 从前往后遍历进行合并操作.
		    while (start + size < nums.length) {
		    	int mid = start + size;
		    	int end;
		    	if (mid + size > nums.length) 
		    		end = nums.length;
		    	else
		    		end = mid + size;
		    	merge(nums, dst, start, mid, end);
		    	start = end;
		    }
		    size *= 2;
		}
	}
	
	// 将两个数组合并，数组１从start开始，到mid(不包括)结束, 数组2从mid开始, 到end(不包括)结束.
	// 合并后,在start到end为有序序列.
	private static void merge(int[] src, int[] dst, int start, int mid, int end) {
	    int index1 = start, index2 = mid; // index1, index2 分别是数组1和数组2的移动下标.
	    int index3 = start; // index3为临时保存下标索引.
	    while (index1 < mid && index2 < end) {
	    	if (src[index1] <= src[index2]) {
	    		dst[index3] = src[index1];
	    		index1++;
	    	} else {
	    		dst[index3] = src[index2];
	    		index2++;
	    	}
	    	index3++;
	    }
	    while (index1 < mid) {
	    	dst[index3] = src[index1];
	    	index1++;
	    	index3++;
	    }
	    while (index2 < end) {
	    	dst[index3] = src[index2];
	    	index2++;
	    	index3++;
	    }
	    for (int i = start; i < end; i++) {
	    	src[i] = dst[i];
	    }
	}
}
