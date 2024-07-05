package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolutionBak03 {

	// 1.41421356237309504880168872420969807856967187537694807317667973799 (from Wikipedia)
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.414213562");

	// 1 000 000 000 (26 seconds)
	// 100 000 000 (3 seconds)
	// 10 000 000 (350 milliseconds)

	// the triangular number can be found with (n * (n + 1)) / 2
	public static String solution(String s) {

		BigInteger n = new BigInteger(s);
		BigInteger nPlus1 = n.add(BigInteger.ONE);
		BigInteger nTimesNPlus1 = n.multiply(nPlus1);

		BigInteger triangularNumber = nTimesNPlus1.divide(new BigInteger("2"));

		BigDecimal multiply = new BigDecimal(triangularNumber).multiply(SQRT_OF_2);
		BigDecimal subtract = multiply.subtract(new BigDecimal(n.divide(new BigInteger("2"))));

		String answer2 = solution2(s);

		BigInteger answer1 = subtract.toBigInteger();

		if (!new BigInteger(answer2).subtract(answer1).equals(BigInteger.ZERO)) {

			System.out.println(s + "  " + answer2 + " : " + answer1 + " (" + subtract + ")");
		}

		return subtract.toBigInteger().toString();
	}

	public static String solution2(String s) {

		BigInteger max = new BigInteger(s);

		BigDecimal sqrtOf2 = new BigDecimal("1.414213562");

		BigInteger sum = BigInteger.ZERO;

		BigDecimal sum2 = BigDecimal.ZERO;
		BigInteger sum3 = BigInteger.ZERO;

		for (BigInteger i = BigInteger.ONE; i.compareTo(max) < 1; i = i.add(BigInteger.ONE)) {

			BigDecimal multi = sqrtOf2.multiply(new BigDecimal(i));

			BigInteger multiply = multi.toBigInteger();

			sum = sum.add(multiply);

			sum2 = sum2.add(multi);

			sum3 = sum3.add(i);
		}

//		System.out.println(s + ": " + sum3 + " " + sum2 + " " + sum + " " + new BigDecimal(sum).divide(new BigDecimal(sum3), 9, BigDecimal.ROUND_CEILING));
//		System.out.println(s + ": " + sum3 + " # " + sum2 + " # " + sum + " # " + sum2.subtract(new BigDecimal(sum)));

		return sum.toString();
	}
}
