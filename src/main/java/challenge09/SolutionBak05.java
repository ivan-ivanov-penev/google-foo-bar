package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolutionBak05 {

	// 1.41421356237309504880168872420969807856967187537694807317667973799 (from Wikipedia)
	// 1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605715
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.41421356237309504880168872420969807856967187537694807317667973799");

	private static final BigInteger TWO = BigInteger.valueOf(2);

	// the triangular number can be found with (n * (n + 1)) / 2
	public static String solution(String s) {

		BigInteger n = new BigInteger(s);
		BigInteger nPlus1 = n.add(BigInteger.ONE);
		BigInteger nTimesNPlus1 = n.multiply(nPlus1);

		BigInteger triangularNumber = nTimesNPlus1.divide(TWO);
		BigInteger triangularNumberMultiplied = triangularNumber.multiply(triangularNumber).multiply(TWO);

		BigInteger sqrt = sqrt(triangularNumberMultiplied);

		return sqrt.subtract(n.divide(TWO)).toString();
	}

	public static BigInteger sqrt(BigInteger n) {

		if (n.signum() >= 0) {

			final int bitLength = n.bitLength();

			BigInteger root = BigInteger.ONE.shiftLeft(bitLength / 2);

			while (!isSqrtXXX(n, root)) {

				root = root.add(n.divide(root)).divide(TWO);
			}

			return root;
		}
		else {

			throw new ArithmeticException("square root of negative number");
		}
	}

	private static boolean isSqrtXXX(BigInteger n, BigInteger root) {

		final BigInteger lowerBound = root.pow(2);
		final BigInteger upperBound = root.add(BigInteger.ONE).pow(2);

		return lowerBound.compareTo(n) <= 0 && n.compareTo(upperBound) < 0;
	}
}
