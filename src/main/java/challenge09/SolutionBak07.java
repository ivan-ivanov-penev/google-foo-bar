package challenge09;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class SolutionBak07 {

	// 1.41421356237309504880168872420969807856967187537694807317667973799 (from Wikipedia)
	// 1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605714701096
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605714701096");
	private static final BigDecimal HALF_SQRT_OF_2 = new BigDecimal("0.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605714701096");

	private static final BigDecimal INVERTED = new BigDecimal("1.70710678118654752440084436210484903928483593768847403658833986899536623923105351942519376716382078636750692311545614851246241802792536860632206074854996791570661133296375279637789997525057639103028573505475");

	private static final BigInteger TWO = BigInteger.valueOf(2);

	public static String solution123(String s) {

		BigInteger n = new BigInteger(s);

		BigInteger triN = calculateTriangularNumber(n);

		BigDecimal divide = new BigDecimal(triN).divide(INVERTED, 206, RoundingMode.FLOOR);

		BigDecimal halfN = new BigDecimal(n).divide(BigDecimal.valueOf(2), 2, RoundingMode.FLOOR);

		BigDecimal add = divide.add(halfN);

		System.out.println(divide);
		System.out.println(halfN);
		System.out.println(add.setScale(0, RoundingMode.CEILING));
		System.out.println(add.setScale(0, RoundingMode.CEILING).toBigInteger());

		return triN.multiply(TWO).subtract(add.setScale(0, RoundingMode.CEILING).toBigInteger()).toString();
	}

	public static String solution(String s) {

		BigInteger n = new BigInteger(s);

		asdf(n); if (true) return null;

		BigInteger nRes = find(n);
//		BigInteger nResx2 = find(n.multiply(TWO));
//
//		System.out.println(s + ": " + nRes + " # " + nResx2 + " # " + nRes.multiply(TWO.multiply(TWO)).subtract(nResx2));

		return nRes.toString();
	}

	static BigDecimal previousRatioTriN = BigDecimal.ZERO;
	static BigDecimal previousRatioTriNx2 = BigDecimal.ZERO;

	private static void asdf(BigInteger n) {

		BigInteger sum = new BigInteger("0");

		for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 1; i = i.add(BigInteger.ONE)) {

			BigInteger multiply = sqrt(i.multiply(i).multiply(TWO));

			sum = sum.add(multiply);
		}

		BigInteger triN = calculateTriangularNumber(n);
		BigInteger triNx2 = triN.multiply(TWO);

		BigInteger diff = triNx2.subtract(sum);

		int scale = 6;

		BigDecimal ratioTriN = new BigDecimal(triN).divide(new BigDecimal(diff), scale, RoundingMode.FLOOR);
		BigDecimal ratioTriNx2 = new BigDecimal(triNx2).divide(new BigDecimal(diff), scale, RoundingMode.FLOOR);

		System.out.println(n + " # " + triN + " # !" + sum + "! # " + triNx2 + " # " + ratioTriN + " (" + ratioTriN.subtract(previousRatioTriN) + ") # "
				+ ratioTriNx2 + " (" + ratioTriNx2.subtract(previousRatioTriNx2) + ") " + diff);

		previousRatioTriN = ratioTriN;
		previousRatioTriNx2 = ratioTriNx2;
	}

	// log(2) = 0.30102999566
	private static BigInteger find(BigInteger n) {

		BigInteger sum = new BigInteger("0");

		for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 1; i = i.add(BigInteger.ONE)) {

			BigInteger multiply = sqrt(i.multiply(i).multiply(TWO));

			sum = sum.add(multiply);
		}

		int scale = 5;
		BigInteger triN = calculateTriangularNumber(n);
		BigDecimal multiply = new BigDecimal(triN).multiply(SQRT_OF_2).setScale(scale, RoundingMode.FLOOR);
		BigDecimal diff = multiply.subtract(new BigDecimal(sum));

		BigDecimal module = new BigDecimal(n).multiply(SQRT_OF_2).setScale(scale, RoundingMode.FLOOR);
		module = module.subtract(new BigDecimal(module.toBigInteger()));

//		BigInteger a = n;
//		BigInteger a = triN;
//		System.out.println(n + " # " + diff + " # " + new BigDecimal(a).divide(new BigDecimal(diff.toBigInteger()), scale, RoundingMode.FLOOR) + " # " + new BigDecimal(a).divide(diff, scale, RoundingMode.FLOOR));
		BigDecimal a = new BigDecimal(triN).multiply(SQRT_OF_2);
//		System.out.println(n + " (" + triN + ") # " + diff + " # " + getRemainder(new BigDecimal(n).multiply(SQRT_OF_2)).setScale(scale, RoundingMode.FLOOR) + " # " + a.divide(diff, scale, RoundingMode.FLOOR) + " # " + new BigDecimal(a.toBigInteger()).divide(new BigDecimal(diff.toBigInteger()), scale, RoundingMode.FLOOR));

		BigDecimal rem = getRemainder(multiply.divide(new BigDecimal(n), scale, RoundingMode.FLOOR));
		BigDecimal smt = rem.multiply(new BigDecimal(n));

		System.out.println(n + " (" + triN + ") # " + multiply + " # (" + sum + ") " + diff + " # " + smt + " # " + diff.subtract(smt).setScale(1, RoundingMode.FLOOR));

		if (true) return BigInteger.ONE;

		BigInteger newAnswer = solutionNew(n);

		/*
//		magicCondition(n);
//		if (n.divideAndRemainder(TWO)[1].equals(BigInteger.ZERO) && magicCondition(n)) {}

		if (n.divideAndRemainder(TWO)[1].equals(BigInteger.ZERO) && magicCondition(n)) {
//		if (n.divideAndRemainder(TWO)[1].equals(BigInteger.ZERO) && module.compareTo(new BigDecimal("0.5")) < 1) {
//		if (module.compareTo(new BigDecimal("0.5")) < 1) {
			System.out.print("!!!");
		}
		else {

			System.out.print("   ");
		}
		*/

		if (!newAnswer.equals(sum)) {

			String end = n.divideAndRemainder(TWO)[1].equals(BigInteger.ZERO) ? calculatePast(n) : "";

			BigInteger df = sum.subtract(newAnswer);
			String dfs = df.compareTo(BigInteger.ZERO) < 0 ? "" : "+";
			System.out.println(">>>" + n + " # " + triN + " # " + sum + " (" + newAnswer + ") # " + multiply + " # " + diff + " (" + n.divide(TWO) + ") # " + module + " # " + dfs + df + end);
		}
		else {

			String end = n.divideAndRemainder(TWO)[1].equals(BigInteger.ZERO) ? calculatePast(n) : "";

			System.out.println("   " + n + " # " + triN + " # " + sum + "        # " + multiply + " # " + diff + "       # " + module + end);
		}

		return sum;
	}

	private static String calculatePast(BigInteger n) {

//		BigDecimal past5 = calculatePast(n, 5);
//		BigDecimal past4 = calculatePast(n, 4);
//		BigDecimal past3 = calculatePast(n, 3);
//		BigDecimal past2 = calculatePast(n, 2);

//		BigInteger past6 = calculatePast(n, 6).toBigInteger();
//		BigInteger past5 = calculatePast(n, 5).toBigInteger();
//		BigInteger past4 = calculatePast(n, 4).toBigInteger();
//		BigInteger past3 = calculatePast(n, 3).toBigInteger();
//		BigInteger past2 = calculatePast(n, 2).toBigInteger();

//		return " # " + past2 + " # " + past3 + " # " + past4 + " # " + past5 + " # " + past6;
		return "";
	}

	private static BigDecimal calculatePast(BigInteger n, int pastIterations) {

		BigInteger i = n.subtract(BigInteger.valueOf(pastIterations));
		BigInteger nMinusITri = calculateTriangularNumber(i);

		BigDecimal sum = getRemainder(new BigDecimal(nMinusITri).multiply(SQRT_OF_2));
		i = i.add(BigInteger.ONE);

		for (int j = 1; j < pastIterations; j++, i = i.add(BigInteger.ONE)) {

			BigDecimal rem = getRemainder(new BigDecimal(i).multiply(SQRT_OF_2));

//			System.out.println(sum.setScale(6, RoundingMode.FLOOR) + " # " + rem.setScale(6, RoundingMode.FLOOR));
			sum = sum.add(rem);
		}

		return sum.setScale(3, RoundingMode.FLOOR);
	}

	private static boolean magicCondition(BigInteger n) {

		BigInteger nMinus1Tri = calculateTriangularNumber(n.subtract(BigInteger.ONE));

		BigDecimal multiply = new BigDecimal(nMinus1Tri).multiply(SQRT_OF_2);
		BigDecimal remainder = getRemainder(multiply);

		BigDecimal m = new BigDecimal(n).multiply(SQRT_OF_2);
		BigDecimal nRemainder = getRemainder(m);

		boolean cannotSumToOne = remainder.add(nRemainder).compareTo(BigDecimal.ONE) < 0;

		if (cannotSumToOne) {

			BigInteger nMinus2Tri = calculateTriangularNumber(n.subtract(TWO));

			BigDecimal multiply2 = new BigDecimal(nMinus2Tri).multiply(SQRT_OF_2);
			BigDecimal remainder2 = getRemainder(multiply2);

			BigDecimal nMinus1Multi = new BigDecimal(n.subtract(BigInteger.ONE)).multiply(SQRT_OF_2);
			BigDecimal nMinus1MultiRemainder = getRemainder(nMinus1Multi);

			BigDecimal sum = remainder2.add(nMinus1MultiRemainder);

//			if (n.toString().equals("6164")) {
//
//				System.err.println(remainder2.setScale(4, RoundingMode.FLOOR) + " # " + nMinus1MultiRemainder.setScale(4, RoundingMode.FLOOR) + " # " + sum.setScale(4, RoundingMode.FLOOR) + " # " + sum.compareTo(BigDecimal.ONE));
//
//				try { Thread.sleep(1000L); System.exit(0); } catch (Exception e) {}
//			}

			return sum.compareTo(BigDecimal.ONE) < 1;
		}

		return cannotSumToOne;
	}

	private static boolean magicCondition2(BigInteger n) {

//		System.out.println();
//		System.out.println("=====================================================================");
//		System.out.println(n);

//		n = BigInteger.valueOf(7014);
//		n = BigInteger.valueOf(6164);

		BigInteger nMinus1Tri = calculateTriangularNumber(n.subtract(BigInteger.ONE));

		BigDecimal multiply = new BigDecimal(nMinus1Tri).multiply(SQRT_OF_2);
		BigDecimal remainder = getRemainder(multiply);

		BigDecimal m = new BigDecimal(n).multiply(SQRT_OF_2);
		BigDecimal nRemainder = getRemainder(m);

//		int pastIterations = 103;
//		int pastIterations = 4;
//
//		BigInteger divide = n.subtract(BigInteger.valueOf(pastIterations)).divide(TWO);
//		BigInteger i = n.subtract(BigInteger.valueOf(pastIterations));
//		BigInteger nMinus1000Tri = calculateTriangularNumber(i);
//		BigDecimal sum = getRemainder(new BigDecimal(nMinus1000Tri).multiply(SQRT_OF_2));
//		i = i.add(BigInteger.ONE);
//
//		for (int j = 1; j < pastIterations; j++, i = i.add(BigInteger.ONE)) {
//
//			BigDecimal rem = getRemainder(new BigDecimal(i).multiply(SQRT_OF_2));
//			sum = sum.add(rem);
//
//			BigInteger temp = sum.toBigInteger().add(divide);
//			System.out.println(rem.setScale(4, RoundingMode.FLOOR) + " # " + sum.setScale(4, RoundingMode.FLOOR) + " # " + temp + " # " + i.divide(TWO) + " = " + temp.subtract(i.divide(TWO)));
//		};
//
//		System.out.println(sum.setScale(6, RoundingMode.FLOOR) + " + " + divide + " = " + divide.add(sum.toBigInteger()) + " # " + n.divide(TWO));

//		System.out.println(remainder);
//		System.out.println(nRemainder);
//		System.out.println(remainder.add(nRemainder));
//		System.out.println(remainder.add(nRemainder).compareTo(BigDecimal.ONE));
//		System.out.println(remainder.add(nRemainder).compareTo(BigDecimal.ONE) < 0);
		return remainder.add(nRemainder).compareTo(BigDecimal.ONE) < 0;
	}

	private static BigDecimal getRemainder(BigDecimal n) {

		return n.subtract(new BigDecimal(n.toBigInteger()));
	}

	public static BigInteger solutionNew(BigInteger n) {

		BigInteger triangularNumber = calculateTriangularNumber(n);

		BigInteger multiply = triangularNumber.multiply(triangularNumber).multiply(TWO);

		return sqrt(multiply).subtract(n.divide(TWO));
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
