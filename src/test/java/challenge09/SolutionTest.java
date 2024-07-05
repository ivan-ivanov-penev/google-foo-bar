package challenge09;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

/*
For example, if str_n was "5", the solution would be calculated as
floor(1*sqrt(2)) +
floor(2*sqrt(2)) +
floor(3*sqrt(2)) +
floor(4*sqrt(2)) +
floor(5*sqrt(2))
= 1+2+4+5+7 = 19

str_n will be a positive integer between 1 and 10^100, inclusive.
Since n can be very large (up to 101 digits!), using just sqrt(2) and a loop won't work.
Sometimes, it's easier to take a step back and concentrate not on what you have in front of you, but on what you don't.

-- Java cases --
Input:
Solution.solution('77')
Output:
4208

Input:
Solution.solution('5')
Output:
19
-------------------------
Test 9 in Google is with the MAX value - should subtract ONE (also Test 5 should subtract ONE)
Test 3 (subtract) and 10 (add) in Google should subtract/add TWO
Test 8 in Google should add ONE
*/

	@Test
	public void testReq1() {

		assertEquals("4208", Solution.solution("77"));
	}

	@Test
	public void testReq2() {

		assertEquals("19", Solution.solution("5"));
	}

	@Test
	public void test01() {

		assertEquals("1", Solution.solution("1"));
	}

	@Test
	public void test02() {

		assertEquals("3", Solution.solution("2"));
	}

	@Test
	public void test03() {

		assertEquals("7", Solution.solution("3"));
	}

	@Test
	public void test04() {

		assertEquals("12", Solution.solution("4"));
	}

	@Test
	public void test06() {

		assertEquals("27", Solution.solution("6"));
	}

	@Test
	public void test07() {

		assertEquals("36", Solution.solution("7"));
	}

	@Test
	public void test831() {

		assertEquals("488472", Solution.solution("831"));
	}

	@Test
	public void test832() {

		assertEquals("489648", Solution.solution("832"));
	}

	@Test
	public void test833() {

		assertEquals("490826", Solution.solution("833"));
	}

	@Test
	public void test834() {

		assertEquals("492005", Solution.solution("834"));
	}

	@Test
	public void test835() {

		assertEquals("493185", Solution.solution("835"));
	}

	@Test
	public void test836() {

		assertEquals("494367", Solution.solution("836"));
	}

	@Test
	public void test837() {

		assertEquals("495550", Solution.solution("837"));
	}

	@Test
	public void test55653() {

		assertEquals("2190102536", Solution.solution("55653"));
	}

	@Test
	public void test55654() {

		assertEquals("2190181242", Solution.solution("55654"));
	}

	@Test
	public void test55655() {

		assertEquals("2190259950", Solution.solution("55655"));
	}

	@Test
	public void test55656() {

		assertEquals("2190338659", Solution.solution("55656"));
	}

	@Test
	public void test55657() {

		assertEquals("2190417369", Solution.solution("55657"));
	}

	@Test
	public void test55658() {

		assertEquals("2190496081", Solution.solution("55658"));
	}

	@Test
	public void test55659() {

		assertEquals("2190574794", Solution.solution("55659"));
	}

	@Test
	public void test55660() {

		assertEquals("2190653509", Solution.solution("55660"));
	}

	@Test
	public void test183286() {

		assertEquals("23754411903", Solution.solution("183286"));
	}

	@Test
	public void test183287() {

		assertEquals("23754671109", Solution.solution("183287"));
	}

	@Test
	public void test183288() {

		assertEquals("23754930317", Solution.solution("183288"));
	}

	@Test
	public void test183289() {

		assertEquals("23755189526", Solution.solution("183289"));
	}

	@Test
	public void test183290() {

		assertEquals("23755448737", Solution.solution("183290"));
	}

	@Test
	public void test183291() {

		assertEquals("23755707949", Solution.solution("183291"));
	}

	@Test
	public void test999990() {

		assertEquals("707092846226", Solution.solution("999990"));
	}

	@Test
	public void test999991() {

		assertEquals("707094260426", Solution.solution("999991"));
	}

	@Test
	public void test999992() {

		assertEquals("707095674628", Solution.solution("999992"));
	}

	@Test
	public void test999993() {

		assertEquals("707097088831", Solution.solution("999993"));
	}

	@Test
	public void test999994() {

		assertEquals("707098503036", Solution.solution("999994"));
	}

	@Test
	public void test999995() {

		assertEquals("707099917242", Solution.solution("999995"));
	}

	@Test
	public void test999996() {

		assertEquals("707101331449", Solution.solution("999996"));
	}

	@Test
	public void test999997() {

		assertEquals("707102745658", Solution.solution("999997"));
	}

	@Test
	public void test999998() {

		assertEquals("707104159868", Solution.solution("999998"));
	}

	@Test
	public void test999999() {

		assertEquals("707105574080", Solution.solution("999999"));
	}

	@Test
	public void test1000000() {

		assertEquals("707106988293", Solution.solution("1000000"));
	}

	@Test
	public void test10000000() {

		assertEquals("70710680189722", Solution.solution("10000000"));
	}

	@Test
	public void test100000000() {

		assertEquals("7071067832576153", Solution.solution("100000000"));
	}

	@Test // confirmed
	public void test10ToThePowerOf100() {

		assertEquals("70710678118654752440084436210484903928483593768847403658833986899536623923105351942519376716382078638821760123411090095254685423841027253480565451739737157454059823250037671948325191776995310741236436",
				Solution.solution("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000"));
	}
}