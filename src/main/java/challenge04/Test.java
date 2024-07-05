package challenge04;

import java.util.Arrays;

public class Test {

/*
The length of l is between 2 and 2000 inclusive.
The elements of l are between 1 and 999999 inclusive.

-- Java cases --
Input:
Solution.solution([1, 1, 1])
Output:
    1

Input:
Solution.solution([1, 2, 3, 4, 5, 6])
Output:
    3
 */

	private static final boolean SHOULD_VERIFY = true;

	public static void main(String[] args) {

		// Some test cases will fail. The reason is that duplicated numbers seem to be accepted which is strange
		// in the context of the task
		executeAndVerify(new int[] { 1, 1, 1 }, 1);
		executeAndVerify(new int[] { 1, 2, 3, 4, 5, 6 }, 3);
		executeAndVerify(new int[] { 1, 2 }, 0);
		executeAndVerify(new int[] { 2, 1 }, 0);
		executeAndVerify(new int[] { 1, 1 }, 0);
		executeAndVerify(new int[] { 999_999, 999_999 }, 0);
		executeAndVerify(new int[] { 999_999, 1 }, 0);
		executeAndVerify(new int[] { 1, 999_999 }, 0);
		executeAndVerify(new int[] { 1, 2, 4, 8, 16 }, 10);
//		executeAndVerify(new int[] { 1, 1, 2, 4, 8, 16 }, 14);
//		executeAndVerify(new int[] { 1, 2, 4, 8, 16, 16 }, 14);
//		executeAndVerify(new int[] { 1, 2, 4, 8, 8, 16 }, 14);
//		executeAndVerify(new int[] { 1, 2, 2, 4, 8, 16 }, 14);
//		executeAndVerify(new int[] { 1, 2, 4, 4, 8, 16 }, 14);
//		executeAndVerify(new int[] { 1, 1, 2, 4, 8, 16, 16 }, 18);
//		executeAndVerify(new int[] { 1, 2, 2, 4, 8, 8, 16 }, 18);
		executeAndVerify(new int[] { 16, 8, 4, 2, 1 }, 0);
		executeAndVerify(new int[] { 3, 8, 333_333, 5, 999_999 }, 1);
		executeAndVerify(new int[] { 222_222, 5, 444_444, 5, 888_888 }, 1);
		executeAndVerify(new int[] { 123, 7, 246, 5, 492, 3 }, 1);
		executeAndVerify(new int[] { 120, 2, 240, 5, 480, 3 }, 2);
		/*
		 */
	}

	private static void executeAndVerify(int[] input, int expected) {

		System.out.print(expected + " : ");
		System.out.println(Arrays.toString(input));

		int actual = Solution.solution(input);

		verify(actual == expected, "Invalid number of codes - expected '" + expected + "' but actual is: " + actual);

		System.out.println("#########################################################################################");
	}

	private static void verify(boolean condition, String message) {

		if (SHOULD_VERIFY && !condition) {

			System.err.println("ERROR");

			try { Thread.sleep(100L); } catch (Exception e) { e.printStackTrace(); }

			System.out.println(message);
		}
	}
}
