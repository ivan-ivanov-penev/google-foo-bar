package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution01 {

	// 1.41421356237309504880168872420969807856967187537694807317667973799 (from Wikipedia)
	// 1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605714701096
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605714701096");

	private static final BigInteger TWO = BigInteger.valueOf(2);

	public static String solution(String s) {

		BigInteger n = new BigInteger(s);

		BigInteger triN = calculateTriangularNumber(n);

		BigInteger triNxSqrt2 = sqrt(triN.multiply(triN).multiply(TWO));

		BigInteger answer = triNxSqrt2.subtract(n.divide(TWO)).subtract(calculateOffset(n));

		return answer.toString();
	}

	private static BigInteger calculateOffset(BigInteger n) {

		if (n.divideAndRemainder(TWO)[1].equals(BigInteger.ONE)) {

			return BigInteger.ZERO;
		}

		int pastIterations = 4;

		BigInteger i = n.subtract(BigInteger.valueOf(pastIterations));
		BigInteger nMinusITri = calculateTriangularNumber(i);

		BigDecimal sum = getRemainder(new BigDecimal(nMinusITri).multiply(SQRT_OF_2));
		i = i.add(BigInteger.ONE);

		for (int j = 1; j <= pastIterations; j++, i = i.add(BigInteger.ONE)) {

			BigDecimal rem = getRemainder(new BigDecimal(i).multiply(SQRT_OF_2));

			sum = sum.add(rem);
		}

		return sum.toBigInteger().subtract(TWO); // since past iterations is 5 which divided by 2 is 2.5 or approx ~2
	}

	private static BigDecimal getRemainder(BigDecimal n) {

		return n.subtract(new BigDecimal(n.toBigInteger()));
	}

	private static BigInteger calculateTriangularNumber(BigInteger n) {

		return n.multiply(n.add(BigInteger.ONE)).divide(TWO);
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
