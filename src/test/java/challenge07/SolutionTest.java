package challenge07;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

/*
Luckily, the beams can only travel a certain maximum distance before becoming too weak to cause damage.
You also know that if a beam hits a corner, it will bounce back in exactly the same direction.
And of course, if the beam hits either you or the bunny trainer, it will stop immediately (albeit painfully).

The room has integer dimensions [1 < x_dim <= 1250, 1 < y_dim <= 1250]. You and the elite trainer are both positioned
on the integer lattice at different distinct positions (x, y) inside the room such that [0 < x < x_dim, 0 < y < y_dim].
Finally, the maximum distance that the beam can travel before becoming harmless will be given as an integer 1 < distance <= 10000

For example, if you and the elite trainer were positioned in a
room with dimensions [3, 2],
your_position [1, 1],
trainer_position [2, 1], and a
maximum shot distance of 4,
you could shoot in seven different directions to hit the elite trainer
(given as vector bearings from your location): [1, 0], [1, 2], [1, -2], [3, 2], [3, -2], [-3, 2], and [-3, -2].
As specific examples, the shot at bearing [1, 0] is the straight line horizontal shot of distance 1,
the shot at bearing [-3, -2] bounces off the left wall and then the bottom wall before hitting the elite trainer
with a total shot distance of sqrt(13), and the shot at bearing [1, 2] bounces off just the top wall before hitting
the elite trainer with a total shot distance of sqrt(5).

-- Java cases --
Input:
Solution.solution([3,2], [1,1], [2,1], 4)
Output:
    7

Input:
Solution.solution([300,275], [150,150], [185,100], 500)
Output:
    9
*/

	@Test
	public void testReq1() {

		assertEquals(7, Solution.solution(new int[]{3,2}, new int[]{1,1}, new int[]{2,1}, 4));
	}

	@Test
	public void testReq2() {

		assertEquals(9, Solution.solution(new int[]{300,275}, new int[]{150,150}, new int[]{185,100}, 500));
	}

	@Test
	@Ignore("According to the requirements this scenario is impossible:\n"
			+ "you and the elite trainer are both positioned on the integer lattice at different distinct "
			+ "positions (x, y) inside the room such that [0 < x < x_dim, 0 < y < y_dim]")
	public void test1() {

		assertEquals(1, Solution.solution(new int[]{3,2}, new int[]{1,1}, new int[]{3,2}, 4));
	}

	@Test
	@Ignore("According to the requirements this scenario is impossible:\n"
			+ "you and the elite trainer are both positioned on the integer lattice at different distinct "
			+ "positions (x, y) inside the room such that [0 < x < x_dim, 0 < y < y_dim]")
	public void test2() {

		assertEquals(1, Solution.solution(new int[]{3,2}, new int[]{0,0}, new int[]{3,2}, 4));
	}

	@Test
	public void test3() {

		assertEquals(0, Solution.solution(new int[]{5,3}, new int[]{1,1}, new int[]{4,2}, 1));
	}

	@Test(timeout = 3000)
	public void test4() {

		// this will fail - should be a lot of combinations perhaps 188? or 187?
		assertEquals(188, Solution.solution(new int[]{1250,1250}, new int[]{8,12}, new int[]{15,23}, 10000));
	}

//	@Test(timeout = 3000)
	@Test
	public void test5() {

		assertEquals(32_898_670, Solution.solution(new int[]{3,2}, new int[]{1,1}, new int[]{2,1}, 10000));
	}

	@Test
	public void test6() {

		assertEquals(0, Solution.solution(new int[]{1250,1250}, new int[]{1,1}, new int[]{4,2}, 1));
	}

	@Test
	public void test7() {

		assertEquals(7, Solution.solution(new int[]{3,2}, new int[]{2,1}, new int[]{1,1}, 4));
	}

	@Test
	public void test8() {

		assertEquals(9, Solution.solution(new int[]{300,275}, new int[]{185,100}, new int[]{150,150}, 500));
	}

	@Test
	public void test9() {

		assertEquals(1, Solution.solution(new int[]{8,5}, new int[]{2,2}, new int[]{7,2}, 5));
	}

	//////// Duplicating vectors ////////
	@Test
	public void test10() {

		assertEquals(16, Solution.solution(new int[]{4,3}, new int[]{2,1}, new int[]{1,1}, 9));
	}

	@Test
	public void test10point5() {

		assertEquals(16, Solution.solution(new int[]{40,30}, new int[]{20,10}, new int[]{10,10}, 90));
	}

	//////// Testing the diagonals ////////
	@Test
	public void test11() {

		assertEquals(1, Solution.solution(new int[]{8,5}, new int[]{2,2}, new int[]{3,3}, 2));
	}

	@Test
	public void test12() {

		assertEquals(1, Solution.solution(new int[]{8,5}, new int[]{2,2}, new int[]{1,1}, 2));
	}

	@Test
	public void test13() {

		assertEquals(1, Solution.solution(new int[]{8,5}, new int[]{2,2}, new int[]{3,1}, 2));
	}

	@Test
	public void test14() {

		assertEquals(1, Solution.solution(new int[]{8,5}, new int[]{2,2}, new int[]{1,3}, 2));
	}

	//////// Moving through your position ////////
	@Test
	public void test15() {

		// 1:1, 1:3, -1:1, -3;1, 1:3 OR 1:1, 1:3, 1:-3, -3:1, -3:3 (-1:-1 OR -3:-3 is a trap because it will hit player)
		assertEquals(5, Solution.solution(new int[]{4,3}, new int[]{1,1}, new int[]{2,2}, 5));
	}

	@Test
	public void test16() {

		// 1:1, 1:3, -1:1, -3;1, 1:3 OR 1:1, 1:3, 1:-3, -3:1, -3:3 (-1:-1 OR -3:-3 is a trap because it will hit player)
		assertEquals(5, Solution.solution(new int[]{40,30}, new int[]{10,10}, new int[]{20,20}, 50));
	}
}

/////////////// Check if number increments proportionally to the beam increment ///////////////

//		int[] dimensions = { 3, 3 };
//
//		System.out.println("10: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 10));
//		System.out.println("11: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 11));
//		System.out.println("12: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 12));
//		System.out.println("13: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 13));
//		System.out.println("14: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 14));
//		System.out.println("15: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 15));
//		System.out.println("16: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 16));
//		System.out.println("17: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 17));
//		System.out.println("18: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 18));
//		System.out.println("19: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 19));
//		System.out.println("20: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 20));
//		System.out.println("30: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 30));
//		System.out.println("40: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 40));
//		System.out.println("50: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 50));
//		System.out.println("100: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 100));
//		System.out.println("200: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 200));
//		System.out.println("300: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 300));
//		System.out.println("400: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 400));
//		System.out.println("500: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 500));
//		System.out.println("1000: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 1000));
//
//		System.out.println();
//		dimensions = new int[] { 4, 4 };
//
//		System.out.println("10: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 10));
//		System.out.println("20: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 20));
//		System.out.println("30: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 30));
//		System.out.println("40: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 40));
//		System.out.println("50: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 50));
//		System.out.println("100: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 100));
//		System.out.println("200: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 200));
//		System.out.println("300: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 300));
//		System.out.println("400: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 400));
//		System.out.println("500: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 500));
//		System.out.println("1000: " + Solution.solution(dimensions, new int[] { 1, 1 }, new int[] { 2, 2 }, 1000));