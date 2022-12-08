import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ArraySortTest {

	@Test
	public void testIsSortedEmpty() {
		int[] arr = {};
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedTrue() {
		int[] arr = { 1, 2, 3, 67, 78 };
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedFalse() {
		int[] arr = { 1, 2, 7, 5, 3 };
		assertFalse(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedArrayListEmpty() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedArrayListTrue() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testIsSortedArrayListFalse() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(5);
		arr.add(4);
		assertFalse(ArraySort.isSorted(arr));
	}

	@Test
	public void testInsertionSortOrdered() {
		int[] arr = { 1, 2, 3, 4 };
		// Sorts the array with ArraySort.insertionSort(arr)
		ArraySort.insertionSort(arr);
		// Checks the length of the array
		assertEquals(4, arr.length);
		// Checks if the array is sorted
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testInsertionSortRandom() {
		int[] arr = { 4, 2, 1, 8 };
		// Sorts the array with ArraySort.insertionSort(arr)
		ArraySort.insertionSort(arr);
		// Checks the length of the array
		assertEquals(4, arr.length);
		// Checks if the array is sorted
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testBubbleSortEmpty() {
		int[] arr = {};
		ArraySort.bubbleSort(arr);
		assertTrue(arr.length == 0);
	}

	@Test
	public void testBubbleSortRandom() {
		int[] arr = { 5, 1, 4, 2, 8 };
		// Sorts the array with ArraySort.bubbleSort(arr).
		ArraySort.bubbleSort(arr);
		// Checks the length of the array.
		assertEquals(5, arr.length);
		// Checks if the array is sorted.
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testBubbleSortOrdered() {
		int[] arr = { 1, 2, 3, 4 };
		// Sorts the array with ArraySort.bubbleSort(arr).
		ArraySort.bubbleSort(arr);
		// Checks the length of the array.
		assertEquals(4, arr.length);
		// Checks if the array is sorted.
		assertTrue(ArraySort.isSorted(arr));
	}

	@Test
	public void testQuickSortSorted() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		
		// Sorts the array with ArraySort.quickSort(arr).
		ArrayList<Integer> finalArr = ArraySort.quickSort(arr);
		// Checks the length of the arrayList.
		assertEquals(5, finalArr.size());
		// Checks if the array is sorted.
		assertTrue(ArraySort.isSorted(finalArr));
	}

	@Test
	public void testQuickSortRandom() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(5);
		arr.add(2);
		arr.add(9);
		arr.add(5);
		
		// Sorts the array with ArraySort.quickSort(arr).
		ArrayList<Integer> finalArr = ArraySort.quickSort(arr);
		// Checks the length of the arrayList.
		assertEquals(5, finalArr.size());
		// Checks if the array is sorted.
		assertTrue(ArraySort.isSorted(finalArr));
	}

	@Test
	public void testQuickSortEmpty() {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		// Sorts the array with ArraySort.quickSort(arr).
		ArrayList<Integer> finalArr = ArraySort.quickSort(arr);
		// Checks the length of the arrayList.
		assertEquals(0, finalArr.size());
		// Checks if the array is sorted.
		assertTrue(ArraySort.isSorted(finalArr));
	}
}
