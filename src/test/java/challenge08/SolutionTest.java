package challenge08;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

/*
num_buns will always be between 1 and 9, and num_required will always be between 0 and 9 (both inclusive)

For example, if you had 3 bunnies and required only 1 of them to open the cell, you would give each bunny the same key
such that any of the 3 of them would be able to open it, like so:
[
  [0],
  [0],
  [0],
]
If you had 2 bunnies and required both of them to open the cell, they would receive different keys (otherwise they
wouldn't both actually be required), and your solution would be as follows:
[
  [0],
  [1],
]
Finally, if you had 3 bunnies and required 2 of them to open the cell, then any 2 of the 3 bunnies should have
all of the keys necessary to open the cell, but no single bunny would be able to do it.  Thus, the solution would be:
[
  [0, 1],
  [0, 2],
  [1, 2],
]

Given the number of bunnies available and the number of locks required to open a work room, write a function
solution(num_buns, num_required) which returns a specification of how to distribute the keys such that any num_required
bunnies can open the locks, but no group of (num_required - 1) bunnies can.

-- Java cases --
Input:
Solution.solution(2, 1)
Output:
    [[0], [0]]

Input:
Solution.solution(5, 3)
Output:
    [[0, 1, 2, 3, 4, 5], [0, 1, 2, 6, 7, 8], [0, 3, 4, 6, 7, 9], [1, 3, 5, 6, 8, 9], [2, 4, 5, 7, 8, 9]]

Input:
Solution.solution(4, 4)
Output:
    [[0], [1], [2], [3]]
*/

	@Test
	public void testReq1() {

		int[][] expected = {
				{ 0 },
				{ 0 }
		};

		assertArrayEquals(expected, Solution.solution(2, 1));
	}

	@Test
	public void testReq2() {

		int[][] expected = {
				{ 0, 1, 2, 3, 4, 5 },
				{ 0, 1, 2, 6, 7, 8 },
				{ 0, 3, 4, 6, 7, 9 },
				{ 1, 3, 5, 6, 8, 9 },
				{ 2, 4, 5, 7, 8, 9 }
		};

		assertArrayEquals(expected, Solution.solution(5, 3));
	}

	@Test
	public void testReq3() {

		int[][] expected = {
				{ 0 },
				{ 1 },
				{ 2 },
				{ 3 }
		};

		assertArrayEquals(expected, Solution.solution(4, 4));
	}

	@Test
	public void testReq4() {

		int[][] expected = {
				{ 0 },
				{ 0 },
				{ 0 }
		};

		assertArrayEquals(expected, Solution.solution(3, 1));
	}

	@Test
	public void testReq5() {

		int[][] expected = {
				{ 0 },
				{ 1 }
		};

		assertArrayEquals(expected, Solution.solution(2, 2));
	}

	@Test
	public void testReq6() {

		int[][] expected = {
				{ 0, 1 },
				{ 0, 2 },
				{ 1, 2 }
		};

		assertArrayEquals(expected, Solution.solution(3, 2));
	}

	//  num_buns will always be between 1 and 9, and num_required will always be between 0 and 9 (both inclusive)
	@Test
	public void test1() {

		assertArrayEquals(new int[][] { { } }, Solution.solution(1, 0));
	}

	@Test
	public void test2() {

		assertArrayEquals(new int[][] { { 0 } }, Solution.solution(1, 1));
	}

	@Test
	public void test3() {

		assertArrayEquals(null, Solution.solution(1, 9));
	}

	@Test
	public void test4() {

		assertArrayEquals(new int[][] {{}, {}, {}, {}, {}, {}, {}, {}, {}}, Solution.solution(9, 0));
	}

	@Test
	public void test5() {

		assertArrayEquals(new int[][] {{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}}, Solution.solution(9, 1));
	}

	@Test
	public void test6() {

		assertArrayEquals(new int[][] {{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}}, Solution.solution(9, 9));
	}

	@Test
	public void test7() {

		int[][] expected = {
				{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 },
				{ 0, 1, 2, 3, 4, 5, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35 },
				{ 0, 6, 7, 8, 9, 10, 21, 22, 23, 24, 25, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45 },
				{ 1, 6, 11, 12, 13, 14, 21, 26, 27, 28, 29, 36, 37, 38, 39, 46, 47, 48, 49, 50, 51 },
				{ 2, 7, 11, 15, 16, 17, 22, 26, 30, 31, 32, 36, 40, 41, 42, 46, 47, 48, 52, 53, 54 },
				{ 3, 8, 12, 15, 18, 19, 23, 27, 30, 33, 34, 37, 40, 43, 44, 46, 49, 50, 52, 53, 55 },
				{ 4, 9, 13, 16, 18, 20, 24, 28, 31, 33, 35, 38, 41, 43, 45, 47, 49, 51, 52, 54, 55 },
				{ 5, 10, 14, 17, 19, 20, 25, 29, 32, 34, 35, 39, 42, 44, 45, 48, 50, 51, 53, 54, 55 }
		};

		assertArrayEquals(expected, Solution.solution(8, 6));
	}

	@Test
	public void test8() {

		int[][] expected = {
				{ 0, 1, 2 },
				{ 0, 1, 3 },
				{ 0, 2, 3 },
				{ 1, 2, 3 }
		};

		assertArrayEquals(expected, Solution.solution(4, 2));
	}

	@Test
	public void test9() {

		int[][] expected = {
				{ 0, 1, 2 },
				{ 0, 3, 4 },
				{ 1, 3, 5 },
				{ 2, 4, 5 }
		};

		assertArrayEquals(expected, Solution.solution(4, 3));
	}

	@Test
	public void test10() {

		assertArrayEquals(new int[][] {{}, {}}, Solution.solution(2, 0));
		assertArrayEquals(new int[][] {{}, {}, {}}, Solution.solution(3, 0));
		assertArrayEquals(new int[][] {{}, {}, {}, {}}, Solution.solution(4, 0));
		assertArrayEquals(new int[][] {{}, {}, {}, {}, {}}, Solution.solution(5, 0));
		assertArrayEquals(new int[][] {{}, {}, {}, {}, {}, {}}, Solution.solution(6, 0));
		assertArrayEquals(new int[][] {{}, {}, {}, {}, {}, {}, {}}, Solution.solution(7, 0));
		assertArrayEquals(new int[][] {{}, {}, {}, {}, {}, {}, {}, {}}, Solution.solution(8, 0));
	}

	@Test
	public void test11() {

		assertArrayEquals(new int[][] {{0}, {0}, {0}, {0}}, Solution.solution(4, 1));
		assertArrayEquals(new int[][] {{0}, {0}, {0}, {0}, {0}}, Solution.solution(5, 1));
		assertArrayEquals(new int[][] {{0}, {0}, {0}, {0}, {0}, {0}}, Solution.solution(6, 1));
		assertArrayEquals(new int[][] {{0}, {0}, {0}, {0}, {0}, {0}, {0}}, Solution.solution(7, 1));
		assertArrayEquals(new int[][] {{0}, {0}, {0}, {0}, {0}, {0}, {0}, {0}}, Solution.solution(8, 1));
	}

	@Test
	public void test12() {

		assertArrayEquals(new int[][] {{0}, {1}, {2}}, Solution.solution(3, 3));
		assertArrayEquals(new int[][] {{0}, {1}, {2}, {3}, {4}}, Solution.solution(5, 5));
		assertArrayEquals(new int[][] {{0}, {1}, {2}, {3}, {4}, {5}}, Solution.solution(6, 6));
		assertArrayEquals(new int[][] {{0}, {1}, {2}, {3}, {4}, {5}, {6}}, Solution.solution(7, 7));
		assertArrayEquals(new int[][] {{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}}, Solution.solution(8, 8));
	}

	@Test
	public void test13() {

		assertArrayEquals(null, Solution.solution(1, 2));
		assertArrayEquals(null, Solution.solution(1, 3));
		assertArrayEquals(null, Solution.solution(1, 4));
		assertArrayEquals(null, Solution.solution(1, 5));
		assertArrayEquals(null, Solution.solution(1, 6));
		assertArrayEquals(null, Solution.solution(1, 7));
		assertArrayEquals(null, Solution.solution(1, 8));

		assertArrayEquals(null, Solution.solution(2, 3));
		assertArrayEquals(null, Solution.solution(2, 4));
		assertArrayEquals(null, Solution.solution(2, 5));
		assertArrayEquals(null, Solution.solution(2, 6));
		assertArrayEquals(null, Solution.solution(2, 7));
		assertArrayEquals(null, Solution.solution(2, 8));
		assertArrayEquals(null, Solution.solution(2, 9));

		assertArrayEquals(null, Solution.solution(3, 4));
		assertArrayEquals(null, Solution.solution(3, 5));
		assertArrayEquals(null, Solution.solution(3, 6));
		assertArrayEquals(null, Solution.solution(3, 7));
		assertArrayEquals(null, Solution.solution(3, 8));
		assertArrayEquals(null, Solution.solution(3, 9));

		assertArrayEquals(null, Solution.solution(4, 5));
		assertArrayEquals(null, Solution.solution(4, 6));
		assertArrayEquals(null, Solution.solution(4, 7));
		assertArrayEquals(null, Solution.solution(4, 8));
		assertArrayEquals(null, Solution.solution(4, 9));

		assertArrayEquals(null, Solution.solution(5, 6));
		assertArrayEquals(null, Solution.solution(5, 7));
		assertArrayEquals(null, Solution.solution(5, 8));
		assertArrayEquals(null, Solution.solution(5, 9));

		assertArrayEquals(null, Solution.solution(6, 7));
		assertArrayEquals(null, Solution.solution(6, 8));
		assertArrayEquals(null, Solution.solution(6, 9));

		assertArrayEquals(null, Solution.solution(7, 8));
		assertArrayEquals(null, Solution.solution(7, 9));

		assertArrayEquals(null, Solution.solution(8, 9));
	}

	@Test
	public void test14() {

		int[][] expected = {
				{ 0, 1, 2, 3 },
				{ 0, 1, 2, 4 },
				{ 0, 1, 3, 4 },
				{ 0, 2, 3, 4 },
				{ 1, 2, 3, 4 }
		};

		assertArrayEquals(expected, Solution.solution(5, 2));
	}

	@Test
	public void test15() {

		int[][] expected = {
				{ 0, 1, 2, 3 },
				{ 0, 4, 5, 6 },
				{ 1, 4, 7, 8 },
				{ 2, 5, 7, 9 },
				{ 3, 6, 8, 9 }
		};

		assertArrayEquals(expected, Solution.solution(5, 4));
	}

	@Test
	public void test16() {

		int[][] expected = {
				{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 0, 1, 2, 3, 4, 5, 10, 11, 12, 13 },
				{ 0, 1, 2, 6, 7, 8, 10, 11, 12, 14 },
				{ 0, 3, 4, 6, 7, 9, 10, 11, 13, 14 },
				{ 1, 3, 5, 6, 8, 9, 10, 12, 13, 14 },
				{ 2, 4, 5, 7, 8, 9, 11, 12, 13, 14 }
		};

		assertArrayEquals(expected, Solution.solution(6, 3));
	}

	@Test
	public void test17() {

		int[][] expected = {
				{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
				{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 15, 16, 17, 18, 19 },
				{ 0, 1, 2, 3, 4, 5, 10, 11, 12, 13, 15, 16, 17, 18, 20 },
				{ 0, 1, 2, 6, 7, 8, 10, 11, 12, 14, 15, 16, 17, 19, 20 },
				{ 0, 3, 4, 6, 7, 9, 10, 11, 13, 14, 15, 16, 18, 19, 20 },
				{ 1, 3, 5, 6, 8, 9, 10, 12, 13, 14, 15, 17, 18, 19, 20 },
				{ 2, 4, 5, 7, 8, 9, 11, 12, 13, 14, 16, 17, 18, 19, 20 }
		};

		assertArrayEquals(expected, Solution.solution(7, 3));
	}

	@Test
	public void test18() {

		int[][] expected = {
				{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 0, 1, 2, 3, 10, 11, 12, 13, 14, 15 },
				{ 0, 4, 5, 6, 10, 11, 12, 16, 17, 18 },
				{ 1, 4, 7, 8, 10, 13, 14, 16, 17, 19 },
				{ 2, 5, 7, 9, 11, 13, 15, 16, 18, 19 },
				{ 3, 6, 8, 9, 12, 14, 15, 17, 18, 19 }
		};

		assertArrayEquals(expected, Solution.solution(6, 4));
	}

	@Test
	public void test19() {

		int[][] expected = {
				{ 0, 1, 2, 3, 4 },
				{ 0, 5, 6, 7, 8 },
				{ 1, 5, 9, 10, 11 },
				{ 2, 6, 9, 12, 13 },
				{ 3, 7, 10, 12, 14 },
				{ 4, 8, 11, 13, 14 }
		};

		assertArrayEquals(expected, Solution.solution(6, 5));
	}

	@Test
	public void test20() {

		int[][] expected = {
				{ 0, 1, 2, 3, 4, 5 },
				{ 0, 6, 7, 8, 9, 10 },
				{ 1, 6, 11, 12, 13, 14 },
				{ 2, 7, 11, 15, 16, 17 },
				{ 3, 8, 12, 15, 18, 19 },
				{ 4, 9, 13, 16, 18, 20 },
				{ 5, 10, 14, 17, 19, 20 }
		};

		assertArrayEquals(expected, Solution.solution(7, 6));
	}
}