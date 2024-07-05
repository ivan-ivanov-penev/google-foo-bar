package challenge07;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Solution2Test {

	@Test
	public void test1() {

		int x = 3;
		int roomX = 4;

		assertEquals(3, Solution.calculateLandingPoint(x, roomX, 2));
		assertEquals(2, Solution.calculateLandingPoint(x, roomX, 3));
		assertEquals(1, Solution.calculateLandingPoint(x, roomX, 4));
		assertEquals(0, Solution.calculateLandingPoint(x, roomX, 5));
		assertEquals(1, Solution.calculateLandingPoint(x, roomX, 6));
		assertEquals(2, Solution.calculateLandingPoint(x, roomX, 7));
		assertEquals(3, Solution.calculateLandingPoint(x, roomX, 8));
		assertEquals(2, Solution.calculateLandingPoint(x, roomX, 11));
		assertEquals(4, Solution.calculateLandingPoint(x, roomX, 25));
		assertEquals(3, Solution.calculateLandingPoint(x, roomX, 18));
		assertEquals(4, Solution.calculateLandingPoint(x, roomX, 33));
	}

	@Test
	public void test2() {

		int x = 4;
		int roomX = 11;

		assertEquals(11, Solution.calculateLandingPoint(x, roomX, 7));
		assertEquals(6, Solution.calculateLandingPoint(x, roomX, 2));
		assertEquals(10, Solution.calculateLandingPoint(x, roomX, 8));
		assertEquals(5, Solution.calculateLandingPoint(x, roomX, 45));
		assertEquals(7, Solution.calculateLandingPoint(x, roomX, 69));
	}

	@Test
	public void test3() {

		int x = 1;
		int roomX = 3;

		assertEquals(2, Solution.calculateLandingPoint(x, roomX, 1));
		assertEquals(2, Solution.calculateLandingPoint(x, roomX, 9));
		assertEquals(1, Solution.calculateLandingPoint(x, roomX, 16));
	}

	@Test
	public void test4() {

		int x = 2;
		int roomX = 5;

		assertEquals(0, Solution.calculateLandingPoint(x, roomX, -2));
		assertEquals(4, Solution.calculateLandingPoint(x, roomX, -8));
		assertEquals(5, Solution.calculateLandingPoint(x, roomX, -17));
		assertEquals(1, Solution.calculateLandingPoint(x, roomX, -23));
		assertEquals(2, Solution.calculateLandingPoint(x, roomX, -24));
		assertEquals(4, Solution.calculateLandingPoint(x, roomX, -6));
	}

	@Test
	public void test5() {

		int x = 6;
		int roomX = 9;

		assertEquals(0, Solution.calculateLandingPoint(x, roomX, -6));
		assertEquals(3, Solution.calculateLandingPoint(x, roomX, -9));
		assertEquals(4, Solution.calculateLandingPoint(x, roomX, -38));
		assertEquals(6, Solution.calculateLandingPoint(x, roomX, -72));
	}
}