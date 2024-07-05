package challenge02;

import java.util.Arrays;

public class Test02 {

/*
-- Java cases --
Input:
Solution.solution({1, 2, 3, 4}, 15)
Output:
    -1,-1

Input:
Solution.solution({4, 3, 10, 2, 8}, 12)
Output:
    2,3

- Each list l will contain at least 1 element but never more than 100.
- Each element of l will be between 1 and 100.
- t will be a positive integer, not exceeding 250.
- The first element of the list l has index 0.
- For the list returned by solution(l, t), the start index must be equal or smaller than the end index.
 */

	private static final boolean SHOULD_VERIFY = true;

	public static void main(String[] args) {

		executeAndVerify(new int[] { 1, 2, 3, 4 }, 15, -1, -1);

		executeAndVerify(new int[] { 4, 3, 10, 2, 8 }, 12, 2, 3);

		executeAndVerify(new int[] { 1 }, 1, 0, 0);

		executeAndVerify(new int[] { 100 }, 100, 0, 0);

		executeAndVerify(new int[] { 1 }, 100, -1, -1);

		executeAndVerify(new int[] { 100 }, 1, -1, -1);

		executeAndVerify(new int[] { 5 }, 5, 0, 0);

		executeAndVerify(new int[] { 4 }, 5, -1, -1);

		executeAndVerify(new int[] { 6 }, 5, -1, -1);

		executeAndVerify(new int[] { 5, 5, 5, 5 }, 5, 0, 0);

		executeAndVerify(new int[] { 5, 5, 5, 5 }, 4, -1, -1);

		executeAndVerify(new int[] { 5, 5, 5, 5 }, 6, -1, -1);

		executeAndVerify(new int[] { 5, 5, 5, 6 }, 6, 3, 3);

		executeAndVerify(new int[] { 15, 26, 37, 45 }, 250, -1, -1);

		executeAndVerify(new int[] { 35, 46, 57, 68, 79, 81, 93, 5, 17, 29, 31, 43, 55 }, 250, 1, 4);

		executeAndVerify(new int[] { 35, 46, 57, 68, 21, 81, 93, 5, 17, 29, 31, 43, 55 }, 250, -1, -1);

		executeAndVerify(new int[] { 20, 30, 40, 50, 80, 10, 70, 5, 17, 29, 31, 43, 55 }, 250, 2, 6);

		executeAndVerify(new int[] { 85, 93, 98, 20, 30, 40, 50, 80, 10, 70, 5, 17, 29, 31, 43, 55 }, 250, 5, 9);

		executeAndVerify(new int[] { 85, 93, 98, 20, 30, 40,55 }, 55, 6, 6);

		executeAndVerify(new int[] { 20, 30, 40, 50, 80, 10, 70, 5, 17, 29,  31, 40, 50, 80, 10, 70, 43, 55 }, 250, 2, 6);

		executeAndVerify(new int[] { 46, 22, 13, 100 }, 8, -1, -1);
	}

	private static void executeAndVerify(int[] l, int t, int expected1, int expected2) {

		System.out.print(t + " : ");

		printArray(l);

		int[] solution = Solution.solution(l, t);

		verifySolution(solution, expected1, expected2);
	}

	private static void verifySolution(int[] solution, int expected1, int expected2) {

		verify(solution.length == 2, "Array length not equal to 2 - Received: " + solution.length);
		verify(solution[0] == expected1, "First element: " + expected1 + " doesn't match!. Received: " + solution[0]);
		verify(solution[1] == expected2, "Second element: " + expected2 + " doesn't match!. Received: " + solution[1]);

		System.out.println("-----------------------");
		System.out.println();
	}

	private static void printArray(int[] solution) {

		System.out.println(Arrays.toString(solution));
	}

	private static void verify(boolean condition) {

		verify(condition, "Condition is NOT true!");
	}

	private static void verify(boolean condition, String message) {

		if (SHOULD_VERIFY && !condition) {

			System.out.println(message);
			System.err.println("ERROR");
		}
	}
}
