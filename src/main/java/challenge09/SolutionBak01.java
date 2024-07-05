package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolutionBak01 {

	// 1 000 000 000 (26 seconds)
	// 100 000 000 (3 seconds)
	// 10 000 000 (350 milliseconds)
	public static String solution(String s) {

		BigInteger max = new BigInteger(s);

		BigDecimal bigDecimal = new BigDecimal("1.414213562");

		BigInteger sum = new BigInteger("0");

		for (int i = 1; i <= max.longValue(); i++) {

			BigInteger multiply = bigDecimal.multiply(new BigDecimal(i)).toBigInteger();

			sum = sum.add(multiply);
		}

		return sum.toString();
	}
}
