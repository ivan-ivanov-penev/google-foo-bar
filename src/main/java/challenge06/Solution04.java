package challenge06;

import java.math.BigInteger;

public class Solution04 {

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

		if (x.equals(BigInteger.ONE)) {

			return y.subtract(x).toString();
		}
		else if (y.equals(BigInteger.ONE)) {

			return x.subtract(y).toString();
		}

		BigInteger larger = x.max(y);
		BigInteger smaller = x.min(y);

		if (larger.divideAndRemainder(smaller)[1].equals(BigInteger.ZERO)) {

			return "impossible";
		}

		for (BigInteger gen = BigInteger.ZERO; shouldContinue(x, y); gen = gen.add(BigInteger.ONE)) {

			if (x.equals(BigInteger.ONE)) {

				return gen.add(y.subtract(x)).toString();
			}
			else if (y.equals(BigInteger.ONE)) {

				return gen.add(x.subtract(y)).toString();
			}
			else if (x.equals(new BigInteger("2"))) {

				return gen.add(y.add(BigInteger.ONE).divide(new BigInteger("2"))).toString();
			}
			else if (y.equals(new BigInteger("2"))) {

				return gen.add(x.add(BigInteger.ONE).divide(new BigInteger("2"))).toString();
			}
			else if (x.compareTo(y) > 0) {

				x = x.subtract(y);
			}
			else {

				y = y.subtract(x);
			}
		}

		// hopefully impossible case
		return "impossible";
	}

	private static boolean shouldContinue(BigInteger x, BigInteger y) {

		BigInteger larger = x.max(y);
		BigInteger smaller = x.min(y);

		// impossible case
		if (larger.divideAndRemainder(smaller)[1].equals(BigInteger.ZERO) && !x.equals(BigInteger.ONE) && !y.equals(BigInteger.ONE)) {

			return false;
		}

		// impossible case
		BigInteger two = new BigInteger("2");

		if (x.divideAndRemainder(two)[1].equals(BigInteger.ZERO) && y.divideAndRemainder(two)[1].equals(BigInteger.ZERO)) {

			return false;
		}

		return x.compareTo(BigInteger.ZERO) > 0 && y.compareTo(BigInteger.ZERO) > 0;
	}
}
