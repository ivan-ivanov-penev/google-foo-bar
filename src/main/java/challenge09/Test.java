package challenge09;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {

	// 1.4142135623730950488016887242096980785696718753769480731766797379907324784621070388503875343276415727350138462309122970249248360558507372126441214970999358314132226659275055927557999505011527820605715
	private static final BigDecimal SQRT_OF_2 = new BigDecimal("1.414213562");

	public static void main(String[] args) {

//		for (int i = 1; i <= 1_000_000_000; i++) {
//
//			BigDecimal bd = new BigDecimal(i).multiply(SQRT_OF_2);
//
//			if (bd.signum() == 0 || bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0) {
//
//				System.out.println(i);
//
//				break;
//			}
//		}
//
//		System.out.println("Fin");

//		System.out.println(Solution.solution("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
////		Solution.solution(String.valueOf(10));
////		Solution.solution(String.valueOf(8));
//		Solution.solution(String.valueOf(2));
//		Solution.solution(String.valueOf(3));
//		Solution.solution(String.valueOf(4));
//		Solution.solution(String.valueOf(5));
//		Solution.solution(String.valueOf(6));
//		Solution.solution(String.valueOf(7));
//		Solution.solution(String.valueOf(8));
//		Solution.solution(String.valueOf(9));

//		int start = 1_000_000;
//		int start = 6000;
//		int start = 2;
//		int start = 1000;

//		int start = 6755;
//		int start = 1000747;
//		int start = 12;
		int start = 1;

//		aaa(12);
//		aaa(6755);
//		aaa(1000747); if (true) return;

		for (int i = start; i <= start + 2_000; i++) {
//		for (int i = start; i <= start + 10; i++) {

//			System.out.println(Solution.solution(String.valueOf(i)));
			Solution.solution(String.valueOf(i));
		}

//		adf(new BigDecimal("1.25"));
//		adf(new BigDecimal("1.33334"));
//		adf(new BigDecimal("1.5"));
//		adf(new BigDecimal("1.66667"));
//		adf(new BigDecimal("1.75"));
//		adf(new BigDecimal("2.75"));
//		adf(new BigDecimal("1.41423"));
//		adf(new BigDecimal("1.375"));
	}

	private static void aaa(int start) {
		for (int i = start; i <= start + 10; i++) {

			//			System.out.println(Solution.solution(String.valueOf(i)));
			Solution.solution(String.valueOf(i));
		}
	}

	private static void adf(BigDecimal sq) {

		System.out.println(sq);

		int start = 1;
		int end = start + 20;

		for (int i = start; i <= end; i++) {

//			Solution.solution(String.valueOf(i), sq);
		}
		System.out.println();
	}

	public static void main4(String[] args) {

//		BigDecimal bi = new BigDecimal("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
//		BigDecimal sqrtOf2 = new BigDecimal("1.414213562");
//
//		BigDecimal multi = bi.divide(sqrtOf2, 15, RoundingMode.CEILING);
//
//		System.out.println(multi);
//		System.out.println(bi.multiply(multi));

		int startNum = 831;

		for (int i = startNum; i <= startNum + 6; i++) {

			String solution = SolutionBak02.solution(String.valueOf(i));

			System.out.println("@Test");
			System.out.println("public void test" + i + "() {");
			System.out.println();
			System.out.println("\tassertEquals(\"" + solution + "\", Solution.solution(\"" + i + "\"));");
			System.out.println("}");
			System.out.println();
		}
	}
	

	/*
	https://betterprogramming.pub/google-has-a-secret-hiring-challenge-called-foobar-14625bfcea7a
	https://github.com/FBosler/GoogleFoobar/tree/main/problem_6
	https://math.stackexchange.com/questions/2052179/how-to-find-sum-i-1n-left-lfloor-i-sqrt2-right-rfloor-a001951-a-beatty-s
	 */

	public static void main3(String[] args) {

		// 9223372036854775807 (long max value)
//		BigInteger bi = new BigInteger("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(bi.longValue());

		BigDecimal sqrtOf2 = new BigDecimal("1.414213562");

		StringBuilder sb = new StringBuilder("10");

//		for (long i = 1; i <= 1000_000_000; i++) {
		for (long i = 1; i <= 10000; i++) {

//			String solution = Solution.solution(String.valueOf(i));
			String solution = "Solution.solution(String.valueOf(i))";
			BigDecimal divide = new BigDecimal(solution).divide(new BigDecimal(i), 15, RoundingMode.CEILING);
			BigDecimal div2 = new BigDecimal(i).divide(divide, 15, RoundingMode.CEILING);
			System.out.println(i + " : " + solution + " (" + divide + ") @ " + div2 + " = " + sqrtOf2.subtract(div2));

//			if (i % Long.parseLong(sb.toString()) == 0) {
//
//				String solution = Solution.solution(String.valueOf(i));
//
//				System.out.println(i + " : " + solution);
////				System.out.println(solution);
//
//				sb.append(0);
//			}
		}
	}

	public static void main2(String[] args) {

		double sqrt2 = Math.sqrt(2);

		System.out.println(sqrt2);

		for (int i = 1; i <= 7; i++) {

			double ans = sqrt2 * i;

			int ans2 = (int) ans;

			System.out.println(ans + " : " + ans2);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("10");

		long start = System.currentTimeMillis();

		long x = 0;

		for (int i = 0; i < 1000; i++) {

			for (int j = 0; j < 1_000_000_000; j++) {

				x++;
			}
		}

		long end = System.currentTimeMillis() - start;

		System.out.println("x: " + x);
		System.out.println("millis: " + end);
		System.out.println("second: " + end / 1000);
	}
}
