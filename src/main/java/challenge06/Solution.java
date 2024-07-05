package challenge06;

import java.math.BigInteger;

public class Solution {

	public static String solution(String x, String y) {

		// a bit of optimization
		if (x.equals(y) && !x.equals("1")) {

			return "impossible";
		}
		else {

			return calculateRequiredNumberOfGenerations(new BigInteger(x), new BigInteger(y));
		}
	}

	private static String calculateRequiredNumberOfGenerations(BigInteger x, BigInteger y) {

		// while (x > 0 && y > 0)
		for (BigInteger gen = BigInteger.ZERO; x.compareTo(BigInteger.ZERO) > 0 && y.compareTo(BigInteger.ZERO) > 0;) {

			if (x.equals(BigInteger.ONE)) {

				return gen.add(y.subtract(x)).toString();
			}
			else if (y.equals(BigInteger.ONE)) {

				return gen.add(x.subtract(y)).toString();
			}
			else if (x.compareTo(y) > 0) { // (if x > y)

				BigInteger[] divideAndRemainder = x.divideAndRemainder(y);
				x = divideAndRemainder[1];
				gen = gen.add(divideAndRemainder[0]);
			}
			else {

				BigInteger[] divideAndRemainder = y.divideAndRemainder(x);
				y = divideAndRemainder[1];
				gen = gen.add(divideAndRemainder[0]);
			}
		}

		return "impossible";
	}
}
