package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SolutionBak04 {

	static BigDecimal previous = BigDecimal.ZERO;

	// 1.41421356237309504880168872420969807856967187537694807317667973799 (from Wikipedia)
	// 1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605715
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.41421356237309504880168872420969807856967187537694807317667973799");

	// the triangular number can be found with (n * (n + 1)) / 2
	public static String solution4(String s) {

		BigInteger n = new BigInteger(s);
		BigInteger nPlus1 = n.add(BigInteger.ONE);
		BigInteger nTimesNPlus1 = n.multiply(nPlus1);

		BigInteger triangularNumber = nTimesNPlus1.divide(BigInteger.valueOf(2));

		BigDecimal multiply = new BigDecimal(triangularNumber).multiply(SQRT_OF_2);
		BigDecimal subtract = multiply.subtract(new BigDecimal(n.divide(BigInteger.valueOf(2))));

		multiply.toBigInteger().subtract(n.divide(BigInteger.valueOf(2)));

		BigInteger wannaBeAns = subtract.toBigInteger();

//		BigInteger[] bis = triangularNumber.divideAndRemainder(n);
//		BigInteger bi = bis[1];
//		if (bi.equals(n.divide(new BigInteger("2")))) {
//
//			wannaBeAns = wannaBeAns.add(BigInteger.ONE);
//		}
//		else if (bi.equals(BigInteger.ZERO)) {
//
//
//			wannaBeAns = wannaBeAns.subtract(BigInteger.ONE);
//		}

		String realAns = solution2(s);

		BigInteger diff = new BigInteger(realAns).subtract(wannaBeAns);

//		if (!diff.equals(BigInteger.ZERO)) {

			BigDecimal wanted = multiply.subtract(new BigDecimal(realAns));

			String a = diff.compareTo(BigInteger.ZERO) > 0 ? "+1" : "-1";

			System.out.println("number: " + s);
			System.out.println("should be: " + realAns);
			System.out.println("but is: " + wannaBeAns + " (" + subtract + ")");
			System.out.println("diff: " + a);
			System.out.println("triangularNumber: " + triangularNumber);
			System.out.println("non-rounded: " + multiply);
			System.out.println("potential: " + new BigDecimal(n).divide(new BigDecimal("2"), 2, BigDecimal.ROUND_CEILING));
			System.out.println("wanted: " + wanted);
			System.out.println();
//		}

		return wannaBeAns.toString();
	}

	public static String solution2(String s) { return null; }
	public static String solution(String s) {

		BigInteger max = new BigInteger(s);

		BigInteger sum = BigInteger.ZERO;

		BigDecimal sum2 = BigDecimal.ZERO;
		BigInteger sum3 = BigInteger.ZERO;

		BigDecimal asdf = BigDecimal.ZERO;

		for (BigInteger i = BigInteger.ONE; i.compareTo(max) < 1; i = i.add(BigInteger.ONE)) {

			BigDecimal multi = SQRT_OF_2.multiply(new BigDecimal(i));

			BigInteger multiply = multi.toBigInteger();

			asdf = asdf.add(multi.subtract(new BigDecimal(multiply)));

//			System.out.println(i + " : " + multi.subtract(new BigDecimal(multiply)) + " = " + asdf + " (" + i.multiply(i.add(BigInteger.ONE)).divide(new BigInteger("2")) + ")");

			sum = sum.add(multiply);

			sum2 = sum2.add(multi);

			sum3 = sum3.add(i);
		}

//		System.out.println(s + ": " + sum3 + " " + sum2 + " " + sum + " " + new BigDecimal(sum).divide(new BigDecimal(sum3), 9, BigDecimal.ROUND_CEILING));
//		System.out.println(s + ": " + sum3 + " # " + sum + " # " + sum2.toBigInteger() + " # " + sum2.subtract(new BigDecimal(sum)).toBigInteger());
		BigDecimal current = new BigDecimal(sum).divide(new BigDecimal(s), 5, BigDecimal.ROUND_CEILING);
//		System.out.println(s + ": " + sum + " # " + current + " # " + current.subtract(previous));



		previous = current;

		return sum.subtract(BigInteger.ONE).toString();
	}
}
