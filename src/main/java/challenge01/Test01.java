package challenge01;

import java.util.Arrays;

public class Test01 {

/*
-- Java cases --
Input:
Solution.solution({1, 2, 3}, 0)
Output:


Input:
Solution.solution({1, 2, 2, 3, 3, 3, 4, 5, 5}, 1)
Output:
    1,4
 */

	private static final boolean SHOULD_VERIFY = true;

	public static void main(String[] args) {

		int[] solution1 = Solution.solution(new int[] { 1, 2, 3 }, 0);

		printArray(solution1);

		verify(solution1.length == 0, "Invalid length");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		int[] solution2 = Solution.solution(new int[] { 1, 2, 2, 3, 3, 3, 4, 5, 5 }, 1);

		printArray(solution2);

		verify(solution2.length == 2, "Invalid length");
		verify(solution2[0] == 1, "Invalid number 0 - should be 1");
		verify(solution2[1] == 4, "Invalid number 1 - should be 4");

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		int[] data1 = new int[99];

		for (int i = 0; i < data1.length; i++) {

			data1[i] = i + 10;
		}

		int[] solution3 = Solution.solution(data1, 1);

		printArray(solution3);
	}

	private static void printArray(int[] arr) {

		System.out.println(Arrays.toString(arr));
	}

	private static void verify(boolean condition) {

		verify(condition, "Condition is NOT true!");
	}

	private static void verify(boolean condition, String message) {

		if (SHOULD_VERIFY && !condition) {

			throw new RuntimeException(message);
		}
	}
}
