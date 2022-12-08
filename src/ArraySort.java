import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	/** Insertion sort of an array
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/** 
	 * This method performs a bubble sort on an array of values.
	 * 
	 * This method has a complexity of O(N^2)
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {
	
		// By default, swaps is true, meaning the method needs to look into 
		// the array to see if it is sorted before the method may complete.
		boolean swaps = true;
		while(swaps)
		{
			// The swaps value is then set to false until evidence of another 
			// swap needing to take place is seen.
			swaps = false;
			// The following code looks through every element in the array.
			for(int i = 0; i < arr.length-1; i++) {
				// If it sees that an element is not in order, it swaps them.
				// Then, it sets swaps to true because that may not be the final
				// swap that needs to take place.
				if(arr[i] > arr[i+1]){
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					swaps = true;
				}
			}
		}
		
	}

	/**
	 * This method performs a quickSort recursively on an arrayList of values.
	 * 
	 * This method has a complexity of (N Log(N))
	 * 
	 * @param S is the array to be sorted (not in place).
	 * @return is the array to be returned after the sorting is complete.
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {
		
		// This is the base case for the recursion, which simply returns the
		// arrayList fed into it if the arrayList has a size of 0 or 1.
		if(S.size() < 2){
			return S;
		}
		
		// This is the recursive case which first divides the elements into
		// three arrayLists recursively until the arrayLists are zero or one
		// element long. Then it puts them all together in the right order.
		else {
			
			//DIVIDE PHASE
			
			ArrayList<Integer> L = new ArrayList<Integer>();
			ArrayList<Integer> E = new ArrayList<Integer>();
			ArrayList<Integer> G = new ArrayList<Integer>();
			
			// E acts as the pivot.
			E.add(S.get(S.size() - 1));
			
			// All numbers in S larger than E's first element are added to G 
			// and all numbers less than E's first element are added to L.
			// (All elements equal to the pivot are added to E.)
			for(int i = 0; i < S.size() - 1; i++) {
				if(S.get(i) < S.get(S.size() -1)) {
					L.add(S.get(i));
				}
				else if(S.get(i) == S.get(S.size() - 1)){
					E.add(S.get(i));
				}
				else {
					G.add(S.get(i));
				}
			}
			
			// Recursion is performed on L and G until they are 0 or 1 elements long.
			ArrayList<Integer> LSorted = quickSort(L);
			ArrayList<Integer> GSorted = quickSort(G);
			
			//CONQUER PHASE
			
			ArrayList<Integer> finalAList = new ArrayList<Integer>();
			
			// Finally, in order, all elements of LSorted, E, and GSorted are added
			// to a final arrayList and sent up the call stack, and finally returned to the user.
			finalAList.addAll(LSorted);
			finalAList.addAll(E);
			finalAList.addAll(GSorted);
			
			return finalAList;
		}
	}

	
	/** predicate to check if array is sorted
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	
	/** predicate to check if arrayList is sorted.
	 *  Useful for checking ArrayList<Integer> lists returned
	 *  from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	
	/** Helper printing methods for testing
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};

	}

}
