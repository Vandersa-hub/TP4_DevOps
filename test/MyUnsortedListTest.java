package unsortedlist;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import datastruct.EmptyListException;
import datastruct.MyUnsortedList;

public class MyUnsortedListTest {
	private MyUnsortedList<Integer> myIntList;
	
	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	
	@Before
	public void initialize() {
		myIntList = MyUnsortedList.of();
	}
	
	
	@Test
	public void listShouldBeEmpty() {
		assertTrue(myIntList.isEmpty());
		assertEquals(0, myIntList.size());
	}
	
	@Test(expected = EmptyListException.class)
	public void popShouldThrowEmptyListException() {
		myIntList.pop();
	}
	
	@Test
	public void popShouldReturnFirstElement() {
		setMyListWithValues();
		
		assertEquals(5, myIntList.size());
		
		assertEquals(1, myIntList.pop().intValue());
		
		assertEquals(4, myIntList.size());
	}
	
	@Test
	public void removeShouldThrowIndexOutOfBoundException()
	{
		exceptionRule.expect(IndexOutOfBoundsException.class);
		myIntList.remove(0);
	}
	
	@Test
	public void removeShouldThrowIndexOutOfBoundExceptionBadValue()
	{
		exceptionRule.expect(IndexOutOfBoundsException.class);
		myIntList.remove(-1);
	}
	
	@Test
	public void removeShouldThrowIndexOutOfBoundExceptionWhenListNotEmpty()
	{
		setMyListWithValues();
		exceptionRule.expect(IndexOutOfBoundsException.class);
		myIntList.remove(6);
	}
	
	@Test
	public void removeShouldReturnAnElementAndRemoveItFromList() {
		setMyListWithValues();
		
		System.out.println(myIntList);
		System.out.println("Taille attendu : 5");
		assertEquals(5, myIntList.size());
		
		System.out.println("Element 0 à retirer, valeur attendue : 1");
		assertEquals(1, myIntList.remove(0).intValue());
		
		System.out.println("Taille attendu : 4");
		assertEquals(4, myIntList.size());
		
		System.out.println("Element 0 à retirer, valeur attendue : 2");
		assertEquals(2, myIntList.remove(0).intValue());
		
		System.out.println("Taille attendu : 3");
		assertEquals(3, myIntList.size());
		
		System.out.println("Element 1 à retirer, valeur attendue : 4");
		assertEquals(4, myIntList.remove(1).intValue());
		
		System.out.println("Taille attendu : 2");
		assertEquals(2, myIntList.size());
		
	}
	
	
	@Test(expected = EmptyListException.class)
	public void popLastShouldThrowEmptyListException() {
		myIntList.popLast();
	}
	
	@Test
	public void popLastShouldReturnLastElement() {
		setMyListWithValues();
		
		assertEquals(5, myIntList.size());
		
		assertEquals(5, myIntList.popLast().intValue());
		
		assertEquals(4, myIntList.size());
	}
	
	@Test
	public void shouldAppendElementLast() {	
		myIntList.append(0);
		
		assertFalse(myIntList.isEmpty());
		assertEquals(1, myIntList.size());
		
		myIntList.append(Integer.MIN_VALUE);
		assertEquals(2, myIntList.size());
		
		myIntList.append(Integer.MAX_VALUE);
		assertEquals(3, myIntList.size());
		
	}
	
	private void setMyListWithValues() {
		myIntList = MyUnsortedList.of(1,2,3,4,5);
	}

}
