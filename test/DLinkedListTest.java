import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DLinkedListTest {

	DLinkedList dl;
	
	@Before
	public void setup(){
		dl = new DLinkedList();
	}
	
	@Test
	public void testIsSortedEmpty() {
		assertTrue(dl.isSorted());
	}

	@Test
	public void testIsSortedTrue() {
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(3);
		dl.addAtTail(5);
		assertTrue(dl.isSorted());
	}
	
	@Test
	public void testIsSortedFalse() {
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(5);
		dl.addAtTail(4);
		assertFalse(dl.isSorted());
	}
	
	@Test
	public void testSizeEmpty() {
		assertEquals(0,dl.size());
	}

	@Test
	public void testSizeOne() {
		dl.addAtTail(1);
		assertEquals(1,dl.size());
	}
	
	@Test
	public void testSizeThree() {
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(5);
		assertEquals(3,dl.size());
	}
	
	@Test
	public void testInsertionSortEmpty() {
		// Call the insertionSort() method on empty doubly linked list dl.
		dl.insertionSort();
		// Tests the size of the empty linked list.
		assertEquals(0, dl.size());
		// Tests that the list is sorted (empty).
		assertTrue(dl.isSorted());
	}
	
	@Test
	public void testInsertionSortOrdered() {
		// Adds some numbers to the head and tail of the doubly linked list dl, ordering it.
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(3);
		dl.addAtTail(5);
		// Calls the insertionSort() method on dl.
		dl.insertionSort();
		// Tests the size of the doubly linked list.
		assertEquals(4, dl.size());
		// Tests that the list is sorted.
		assertTrue(dl.isSorted());
	}
	
	@Test
	public void testInsertionSortRandom() {
		// add some numbers to the head and tail of
		// the list dl, such that the list is unordered
		dl.addAtTail(1);
		dl.addAtTail(2);
		dl.addAtTail(5);
		dl.addAtTail(4);	
		// Calls the insertionSort() method on dl.
		dl.insertionSort();		
		// Tests the size of the doubly linked list.
		assertEquals(4, dl.size());
		// Tests that the list is sorted.
		assertTrue(dl.isSorted());
	}
	
}
