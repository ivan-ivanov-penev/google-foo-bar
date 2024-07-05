package challenge06;

import java.math.BigInteger;

public class Solution03 {

	public static String solution(String x, String y) {

		// a bit of optimization
		if (x.equals(y) && !x.equals("1")) {

			return "impossible";
		}
		else {

			BigInteger bintX = new BigInteger(x);
			BigInteger bintY = new BigInteger(y);

			return calculateRequiredNumberOfGenerations(bintX, bintY, BigInteger.ZERO);
		}
	}

	private static String calculateRequiredNumberOfGenerations(BigInteger x, BigInteger y, BigInteger gen) {

		if (x.compareTo(BigInteger.ZERO) <= 0 || y.compareTo(BigInteger.ZERO) <= 0) {

			return "impossible";
		}
		else {

			if (x.equals(BigInteger.ONE)) {

				return gen.add(y.subtract(x)).toString();
			}
			else if (y.equals(BigInteger.ONE)) {

				return gen.add(x.subtract(y)).toString();
			}
			else if (x.compareTo(y) > 0) {

				return calculateRequiredNumberOfGenerations(x.subtract(y), y, gen.add(BigInteger.ONE));
			}
			else {

				return calculateRequiredNumberOfGenerations(x, y.subtract(x), gen.add(BigInteger.ONE));
			}
		}
	}
}
