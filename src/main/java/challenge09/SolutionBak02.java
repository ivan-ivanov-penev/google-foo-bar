package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolutionBak02 {

	// 1 000 000 000 (26 seconds)
	// 100 000 000 (3 seconds)
	// 10 000 000 (350 milliseconds)
	public static String solution(String s) {

		BigInteger max = new BigInteger(s);

		BigDecimal sqrtOf2 = new BigDecimal("1.414213562");

		BigInteger sum = BigInteger.ZERO;

		for (BigInteger i = BigInteger.ONE; i.compareTo(max) < 1; i = i.add(BigInteger.ONE)) {

			BigInteger multiply = sqrtOf2.multiply(new BigDecimal(i)).toBigInteger();

			sum = sum.add(multiply);
		}

		return sum.toString();
	}
}
