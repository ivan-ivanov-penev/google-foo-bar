package challenge03;

public class Test {

/*
-- Java cases --
Input:
Solution.solution("<<>><")
Output:
    4

Input:
Solution.solution(">----<")
Output:
    2
 */

	private static final boolean SHOULD_VERIFY = true;

	public static void main(String[] args) {

		executeAndVerify("--->-><-><-->-", 10);
		executeAndVerify("<<>><", 4);
		executeAndVerify(">----<", 2);
		executeAndVerify(">", 0);
		executeAndVerify("<", 0);
		executeAndVerify("-", 0);
		executeAndVerify("---", 0);
		executeAndVerify("<>", 0);
		executeAndVerify("<<<>>>", 0);
		executeAndVerify("<--->", 0);
		executeAndVerify("--<--->--", 0);
		executeAndVerify("-->--<--<", 4);
		executeAndVerify("--<-->-->", 0);
		executeAndVerify(">-->--<--", 4);
		executeAndVerify("<--<-->--", 0);
		executeAndVerify("><", 2);
		executeAndVerify(">><<", 8);
		executeAndVerify(">>><<<", 18);
	}

	private static void executeAndVerify(String input, int expected) {

		System.out.println(input);

		int solution = Solution.solution(input);

		verifySolution(solution, expected);
	}

	private static void verifySolution(int solution, int expected) {

		verify(solution == expected, "Invalid number of salutes - expected " + expected + " but actual is: " + solution);

		System.out.println("#########################################################################################");
	}

	private static void verify(boolean condition) {

		verify(condition, "Condition is NOT true!");
	}

	private static void verify(boolean condition, String message) {

		if (SHOULD_VERIFY && !condition) {

			System.out.println(message);
			System.err.println("ERROR");
			try { Thread.sleep(200L); } catch (Exception e) { e.printStackTrace(); }
		}
	}
}
