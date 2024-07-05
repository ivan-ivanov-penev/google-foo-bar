package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Solution {

	// 101 digits after decimal point since the max value is one googol which has 101 digits
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727");

	private static final BigDecimal SQRT_OF_2_PLUS_2 = new BigDecimal("3.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727");

	private static final BigInteger TWO = BigInteger.valueOf(2);

	public static String solution(String s) {

		return calculateBeattySequence(new BigInteger(s)).toString();
	}

	private static BigInteger calculateBeattySequence(BigInteger n) {

		if (n.equals(BigInteger.ZERO)) {

			return BigInteger.ZERO;
		}
		else {

			BigInteger beattyRN = SQRT_OF_2.multiply(new BigDecimal(n)).toBigInteger();

			BigInteger beattyRNS = new BigDecimal(beattyRN).divide(SQRT_OF_2_PLUS_2, 206, RoundingMode.FLOOR).toBigInteger();

			BigInteger bs = calculateBeattySequence(beattyRNS);

			BigInteger result = calculateTriangularNumber(beattyRN);

			return result.subtract(bs).subtract(beattyRNS.multiply(beattyRNS.add(BigInteger.ONE)));
		}
	}

	private static BigInteger calculateTriangularNumber(BigInteger n) {

		return n.multiply(n.add(BigInteger.ONE)).divide(TWO);
	}
}
