package zju.edu.test;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import zju.edu.sort.BubbleSort;
import zju.edu.sort.DirectInsertionSort;
import zju.edu.sort.HeapSort;
import zju.edu.sort.MergeSort;
import zju.edu.sort.QuickSort;
import zju.edu.sort.SimpleSelectSort;

public class SortTest {
	
	private int[] unsortedNums = {48, 36, 68, 72, 12, 48, 2};
	
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void before() {
		System.out.println(String.format("The test method is %s : ",testName.getMethodName()));
	}
	
	@After
	public void print() {
		for (int i = 0; i < unsortedNums.length; i++) {
			System.out.print(unsortedNums[i] + "\t" ) ;
		}
		System.out.println();
	}
	
	@Test
	public void simpleSelectSort() throws Exception {
		SimpleSelectSort.simpleSelectSort(unsortedNums);
	}
	
	@Test
	public void directInsertionSort() throws Exception {
		DirectInsertionSort.directInsertionSort(unsortedNums);
	}
	
	@Test
	public void bubbleSort() throws Exception {
		BubbleSort.bubbleSort(unsortedNums);
	}
	
	@Test
	public void quickSort() throws Exception {
		QuickSort.quickSort(unsortedNums);
	}
	
	@Test
	public void mergeSort() throws Exception {
		MergeSort.mergeSort(unsortedNums);
	}
	
	@Test
	public void headSort() throws Exception {
		HeapSort.heapSort(unsortedNums);
	}
}
