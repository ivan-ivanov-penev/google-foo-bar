package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolutionBak06 {

	// 1.41421356237309504880168872420969807856967187537694807317667973799 (from Wikipedia)
	// 1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605715
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605715");
	private static final BigDecimal HALF_SQRT_OF_2 = new BigDecimal("0.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605715");

	private static final BigInteger TWO = BigInteger.valueOf(2);

	private static int counter = 1;

	// the triangular number can be found with (n * (n + 1)) / 2
	public static String solution(String s, BigDecimal sq) {

		BigInteger triN = calculateTriangularNumber(new BigInteger(s));

		System.out.print(s + " # " + triN);

		//		sol(s, new BigDecimal("1.25"));
		//		sol(s, new BigDecimal("1.33334"));
		//		sol(s, new BigDecimal("1.5"));
		//		sol(s, new BigDecimal("1.41423"));
		sol(s, sq);

		System.out.println();

		return null;
	}

	public static String sol(String s, BigDecimal sq2) {

		BigInteger max = new BigInteger(s);

		BigInteger sum = new BigInteger("0");
		BigDecimal bdSum = new BigDecimal("0");

		for (int i = 1; i <= max.longValue(); i++) {

			BigDecimal multi = sq2.multiply(new BigDecimal(i));

			BigInteger multiply = multi.toBigInteger();

			sum = sum.add(multiply);

			bdSum = bdSum.add(multi);
		}

		System.out.print(" # " + sum + " # " + bdSum + " # " + bdSum.subtract(new BigDecimal(sum)));

		return sum.toString();
	}

	public static String solution3(String s) {

		BigInteger n = new BigInteger(s);
		BigInteger triangularNumber = calculateTriangularNumber(n);
		BigInteger previousTriangularNumber = calculateTriangularNumber(n.subtract(BigInteger.ONE));

		BigInteger bigInteger = HALF_SQRT_OF_2.multiply(new BigDecimal(previousTriangularNumber)).toBigInteger();

		String answer = triangularNumber.add(bigInteger).toString();

		//		BigDecimal subtract = calc(triangularNumber).subtract(calc(previousTriangularNumber));
		//
		//		BigDecimal ans = new BigDecimal(triangularNumber).multiply(SQRT_OF_2).subtract(subtract);
		//
		//		System.out.println(ans);

		String answerReal = SolutionBak01.solution(s);
		//		String answer = answerReal;

		if (!answerReal.equals(answer)) {

			BigInteger diff = new BigInteger(answer).subtract(new BigInteger(answerReal));

			System.out.println("MISSMATCH: " + s + " expected: " + answerReal + ", actual: " + answer + ", diff: " + diff);
		}

		return answer;
	}

	private static BigInteger calculateTriangularNumber(BigInteger n) {

		return n.multiply(n.add(BigInteger.ONE)).divide(TWO);
	}

	private static BigDecimal calc(BigInteger n) {

		BigDecimal nbd = new BigDecimal(n);

		return nbd.multiply(SQRT_OF_2).subtract(nbd);
	}

	public static String solution2(String s) {

		BigInteger n = new BigInteger(s);
		BigInteger nPlus1 = n.add(BigInteger.ONE);
		BigInteger nTimesNPlus1 = n.multiply(nPlus1);

		BigInteger triangularNumber = nTimesNPlus1.divide(TWO);
		BigInteger triangularNumberMultiplied = triangularNumber.multiply(triangularNumber).multiply(TWO);

		BigInteger sqrt = sqrt(triangularNumberMultiplied);

		BigInteger answer = sqrt.subtract(n.divide(TWO));

		/*
		the answer is: triangularN + floor(0.41421356*triangularN)


		 */

		return answer.toString();
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
