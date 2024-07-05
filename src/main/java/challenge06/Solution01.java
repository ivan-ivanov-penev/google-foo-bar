package challenge06;

import java.math.BigInteger;

public class Solution01 {

	public static String solution(String x, String y) {

		// a bit of optimization
		if (x.equals(y) && !x.equals("1")) {

			return "impossible";
		}
		else {

			BigInteger bintX = new BigInteger(x);
			BigInteger bintY = new BigInteger(y);

			if (x.equals("1")) {

				return bintY.subtract(bintX).toString();
			}
			else if (y.equals("1")) {

				return bintX.subtract(bintY).toString();
			}
			else {

				BigInteger larger = bintX.max(bintY);
				BigInteger smaller = bintX.min(bintY);

				if (larger.divideAndRemainder(smaller)[1].equals(BigInteger.ZERO)) {

					return "impossible";
				}
				else {

					// 'larger' - 1 is also the max possible generation although this case is handled above
					return calc(BigInteger.ONE, BigInteger.ONE, BigInteger.ZERO, larger, bintX, bintY);
				}
			}
		}
	}

	private static String calc(BigInteger x, BigInteger y, BigInteger gen, BigInteger maxGen, BigInteger requiredX, BigInteger requiredY) {

		if (gen.compareTo(maxGen) < 0) {

			if (x.equals(requiredX) && y.equals(requiredY)) {

				return gen.toString();
			}
			else {

				// optimization to limit recursion cycles
				if (x.compareTo(requiredX) > 0 || y.compareTo(requiredY) > 0) {

					return "impossible";
				}

				BigInteger nextGen = gen.add(BigInteger.ONE);

				String potentialVectorX = calc(x.add(y), y, nextGen, maxGen, requiredX, requiredY);

				if (!potentialVectorX.equals("impossible")) {

					return potentialVectorX;
				}
				else {

					return calc(x, y.add(x), nextGen, maxGen, requiredX, requiredY);
				}
			}
		}
		else {

			return "impossible";
		}
	}
}
