package challenge06;

import java.math.BigInteger;

public class Test {

	private static final boolean SHOULD_VERIFY = true;

	public static void main(String[] args) {

//		executeAndVerify(200, 487_067_745);

		long start = System.currentTimeMillis();

		// 100000000000000000000
		for (BigInteger gen = BigInteger.ZERO; gen.compareTo(new BigInteger("1_000_000_000")) < 0; gen = gen.add(BigInteger.ONE)) {

//			System.out.println(gen);
		}

		long execTimeMillis = System.currentTimeMillis() - start;

		System.out.println(execTimeMillis / 1000);
	}

	private static void executeAndVerify(int input, int expected) {

		System.out.println(input + " : " + expected);

//		int actual = Solution.solution(input);
		int actual = -1;

		verify(actual == expected, "Expected '" + expected + "' but actual is: " + actual);

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
