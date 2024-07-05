package challenge06;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

/*
First, the bombs self-replicate via one of two distinct processes:
Every Mach bomb retrieves a sync unit from a Facula bomb; for every Mach bomb, a Facula bomb is created;
Every Facula bomb spontaneously creates a Mach bomb.
For example, if you had 3 Mach bombs and 2 Facula bombs, they could either produce 3 Mach bombs and 5 Facula bombs,
or 5 Mach bombs and 2 Facula bombs. The replication process can be changed each cycle.

M and F will be string representations of positive integers no larger than 10^50.
For example, if M = "2" and F = "1", one generation would need to pass, so the solution would be "1".
However, if M = "2" and F = "4", it would not be possible.

-- Java cases --
Input:
Solution.solution('2', '1')
Output:
    1

Input:
Solution.solution('4', '7')
Output:
    4
*/

	@Test
	public void testReq1() {

		assertEquals("1", Solution.solution("2", "1"));
	}

	@Test
	public void testReq2() {

		assertEquals("4", Solution.solution("4", "7"));
	}

	@Test
	public void testReq3() {

		assertEquals("impossible", Solution.solution("2", "4"));
	}

	@Test
	public void test4() {

		assertEquals("1", Solution.solution("1", "2"));
	}

	@Test
	public void test5() {

		assertEquals("5", Solution.solution("1", "6"));
	}

	@Test
	public void test6() {

		assertEquals("99999999999999999999999999999999999999999999999999", Solution.solution("1", "100000000000000000000000000000000000000000000000000"));
	}

	@Test
	public void test7() {

		assertEquals("99999999999999999999999999999999999999999999999999", Solution.solution("100000000000000000000000000000000000000000000000000", "1"));
	}

	@Test
	public void test8() {

		assertEquals("0", Solution.solution("1", "1"));
	}

	@Test
	public void test9() {

		assertEquals("impossible", Solution.solution("2", "2"));
	}

	@Test
	public void test10() {

		assertEquals("impossible", Solution.solution("184", "184"));
	}

	@Test
	public void test11() {

		assertEquals("impossible", Solution.solution("100000000000000000000000000000000000000000000000000", "100000000000000000000000000000000000000000000000000"));
	}

	@Test
	public void test12() {

		assertEquals("impossible", Solution.solution("100000000000000000000000000000000000000000000000000", "2"));
	}

	@Test
	public void test13() {

		assertEquals("impossible", Solution.solution("2", "100000000000000000000000000000000000000000000000000"));
	}

	@Test
	public void test14() {

		assertEquals("432467526643262052250662", Solution.solution("231231234345345323456544337", "100000000000000000000000000000000000000000000000000"));
	}

	@Test
	public void test15() {

		assertEquals("432467526643262052250662", Solution.solution("100000000000000000000000000000000000000000000000000", "231231234345345323456544337"));
	}

	@Test
	public void test16() {

		assertEquals("7692307692307692307692307692307692307692307692313", Solution.solution("13", "100000000000000000000000000000000000000000000000000"));
	}

	@Test
	public void test17() {

		assertEquals("7692307692307692307692307692307692307692307692313", Solution.solution("100000000000000000000000000000000000000000000000000", "13"));
	}

	@Test
	public void test18() {

		assertEquals("impossible", Solution.solution("50000000000000000000000000000000000000000000000000", "2"));
	}

	@Test
	public void test19() {

		assertEquals("impossible", Solution.solution("2", "50000000000000000000000000000000000000000000000000"));
	}

	//////////////// Automatically generated ////////////////
	@Test
	public void testAuto6() {
		assertEquals("6", Solution.solution("7", "1"));
	}

	@Test
	public void testAuto7() {
		assertEquals("6", Solution.solution("6", "7"));
	}

	@Test
	public void testAuto8() {
		assertEquals("5", Solution.solution("6", "1"));
	}

	@Test
	public void testAuto9() {
		assertEquals("6", Solution.solution("11", "6"));
	}

	@Test
	public void testAuto10() {
		assertEquals("6", Solution.solution("5", "11"));
	}

	@Test
	public void testAuto11() {
		assertEquals("5", Solution.solution("5", "6"));
	}

	@Test
	public void testAuto12() {
		assertEquals("4", Solution.solution("5", "1"));
	}

	@Test
	public void testAuto13() {
		assertEquals("6", Solution.solution("14", "5"));
	}

	@Test
	public void testAuto14() {
		assertEquals("6", Solution.solution("9", "14"));
	}

	@Test
	public void testAuto15() {
		assertEquals("5", Solution.solution("9", "5"));
	}

	@Test
	public void testAuto16() {
		assertEquals("6", Solution.solution("13", "9"));
	}

	@Test
	public void testAuto17() {
		assertEquals("6", Solution.solution("4", "13"));
	}

	@Test
	public void testAuto18() {
		assertEquals("5", Solution.solution("4", "9"));
	}

	@Test
	public void testAuto19() {
		assertEquals("4", Solution.solution("4", "5"));
	}

	@Test
	public void testAuto20() {
		assertEquals("3", Solution.solution("4", "1"));
	}

	@Test
	public void testAuto21() {
		assertEquals("6", Solution.solution("15", "4"));
	}

	@Test
	public void testAuto22() {
		assertEquals("6", Solution.solution("11", "15"));
	}

	@Test
	public void testAuto23() {
		assertEquals("5", Solution.solution("11", "4"));
	}

	@Test
	public void testAuto24() {
		assertEquals("6", Solution.solution("18", "11"));
	}

	@Test
	public void testAuto25() {
		assertEquals("6", Solution.solution("7", "18"));
	}

	@Test
	public void testAuto26() {
		assertEquals("5", Solution.solution("7", "11"));
	}

	@Test
	public void testAuto27() {
		assertEquals("4", Solution.solution("7", "4"));
	}

	@Test
	public void testAuto28() {
		assertEquals("6", Solution.solution("17", "7"));
	}

	@Test
	public void testAuto29() {
		assertEquals("6", Solution.solution("10", "17"));
	}

	@Test
	public void testAuto30() {
		assertEquals("5", Solution.solution("10", "7"));
	}

	@Test
	public void testAuto31() {
		assertEquals("6", Solution.solution("13", "10"));
	}

	@Test
	public void testAuto32() {
		assertEquals("6", Solution.solution("3", "13"));
	}

	@Test
	public void testAuto33() {
		assertEquals("5", Solution.solution("3", "10"));
	}

	@Test
	public void testAuto34() {
		assertEquals("4", Solution.solution("3", "7"));
	}

	@Test
	public void testAuto35() {
		assertEquals("3", Solution.solution("3", "4"));
	}

	@Test
	public void testAuto36() {
		assertEquals("2", Solution.solution("3", "1"));
	}

	@Test
	public void testAuto37() {
		assertEquals("6", Solution.solution("14", "3"));
	}

	@Test
	public void testAuto38() {
		assertEquals("6", Solution.solution("11", "14"));
	}

	@Test
	public void testAuto39() {
		assertEquals("5", Solution.solution("11", "3"));
	}

	@Test
	public void testAuto40() {
		assertEquals("6", Solution.solution("19", "11"));
	}

	@Test
	public void testAuto41() {
		assertEquals("6", Solution.solution("8", "19"));
	}

	@Test
	public void testAuto42() {
		assertEquals("5", Solution.solution("8", "11"));
	}

	@Test
	public void testAuto43() {
		assertEquals("4", Solution.solution("8", "3"));
	}

	@Test
	public void testAuto44() {
		assertEquals("6", Solution.solution("21", "8"));
	}

	@Test
	public void testAuto45() {
		assertEquals("6", Solution.solution("13", "21"));
	}

	@Test
	public void testAuto46() {
		assertEquals("5", Solution.solution("13", "8"));
	}

	@Test
	public void testAuto47() {
		assertEquals("6", Solution.solution("18", "13"));
	}

	@Test
	public void testAuto48() {
		assertEquals("6", Solution.solution("5", "18"));
	}

	@Test
	public void testAuto49() {
		assertEquals("5", Solution.solution("5", "13"));
	}

	@Test
	public void testAuto50() {
		assertEquals("4", Solution.solution("5", "8"));
	}

	@Test
	public void testAuto51() {
		assertEquals("3", Solution.solution("5", "3"));
	}

	@Test
	public void testAuto52() {
		assertEquals("6", Solution.solution("17", "5"));
	}

	@Test
	public void testAuto53() {
		assertEquals("6", Solution.solution("12", "17"));
	}

	@Test
	public void testAuto54() {
		assertEquals("5", Solution.solution("12", "5"));
	}

	@Test
	public void testAuto55() {
		assertEquals("6", Solution.solution("19", "12"));
	}

	@Test
	public void testAuto56() {
		assertEquals("6", Solution.solution("7", "19"));
	}

	@Test
	public void testAuto57() {
		assertEquals("5", Solution.solution("7", "12"));
	}

	@Test
	public void testAuto58() {
		assertEquals("4", Solution.solution("7", "5"));
	}

	@Test
	public void testAuto59() {
		assertEquals("6", Solution.solution("16", "7"));
	}

	@Test
	public void testAuto60() {
		assertEquals("6", Solution.solution("9", "16"));
	}

	@Test
	public void testAuto61() {
		assertEquals("5", Solution.solution("9", "7"));
	}

	@Test
	public void testAuto62() {
		assertEquals("6", Solution.solution("11", "9"));
	}

	@Test
	public void testAuto63() {
		assertEquals("6", Solution.solution("2", "11"));
	}

	@Test
	public void testAuto64() {
		assertEquals("5", Solution.solution("2", "9"));
	}

	@Test
	public void testAuto65() {
		assertEquals("4", Solution.solution("2", "7"));
	}

	@Test
	public void testAuto66() {
		assertEquals("3", Solution.solution("2", "5"));
	}

	@Test
	public void testAuto67() {
		assertEquals("2", Solution.solution("2", "3"));
	}

	@Test
	public void testAuto68() {
		assertEquals("1", Solution.solution("2", "1"));
	}

	@Test
	public void testAuto69() {
		assertEquals("6", Solution.solution("11", "2"));
	}

	@Test
	public void testAuto70() {
		assertEquals("6", Solution.solution("9", "11"));
	}

	@Test
	public void testAuto71() {
		assertEquals("5", Solution.solution("9", "2"));
	}

	@Test
	public void testAuto72() {
		assertEquals("6", Solution.solution("16", "9"));
	}

	@Test
	public void testAuto73() {
		assertEquals("6", Solution.solution("7", "16"));
	}

	@Test
	public void testAuto74() {
		assertEquals("5", Solution.solution("7", "9"));
	}

	@Test
	public void testAuto75() {
		assertEquals("4", Solution.solution("7", "2"));
	}

	@Test
	public void testAuto76() {
		assertEquals("6", Solution.solution("19", "7"));
	}

	@Test
	public void testAuto77() {
		assertEquals("6", Solution.solution("12", "19"));
	}

	@Test
	public void testAuto78() {
		assertEquals("5", Solution.solution("12", "7"));
	}

	@Test
	public void testAuto79() {
		assertEquals("6", Solution.solution("17", "12"));
	}

	@Test
	public void testAuto80() {
		assertEquals("6", Solution.solution("5", "17"));
	}

	@Test
	public void testAuto81() {
		assertEquals("5", Solution.solution("5", "12"));
	}

	@Test
	public void testAuto82() {
		assertEquals("4", Solution.solution("5", "7"));
	}

	@Test
	public void testAuto83() {
		assertEquals("3", Solution.solution("5", "2"));
	}

	@Test
	public void testAuto84() {
		assertEquals("6", Solution.solution("18", "5"));
	}

	@Test
	public void testAuto85() {
		assertEquals("6", Solution.solution("13", "18"));
	}

	@Test
	public void testAuto86() {
		assertEquals("5", Solution.solution("13", "5"));
	}

	@Test
	public void testAuto87() {
		assertEquals("6", Solution.solution("21", "13"));
	}

	@Test
	public void testAuto88() {
		assertEquals("6", Solution.solution("8", "21"));
	}

	@Test
	public void testAuto89() {
		assertEquals("5", Solution.solution("8", "13"));
	}

	@Test
	public void testAuto90() {
		assertEquals("4", Solution.solution("8", "5"));
	}

	@Test
	public void testAuto91() {
		assertEquals("6", Solution.solution("19", "8"));
	}

	@Test
	public void testAuto92() {
		assertEquals("6", Solution.solution("11", "19"));
	}

	@Test
	public void testAuto93() {
		assertEquals("5", Solution.solution("11", "8"));
	}

	@Test
	public void testAuto94() {
		assertEquals("6", Solution.solution("14", "11"));
	}

	@Test
	public void testAuto95() {
		assertEquals("6", Solution.solution("3", "14"));
	}

	@Test
	public void testAuto96() {
		assertEquals("5", Solution.solution("3", "11"));
	}

	@Test
	public void testAuto97() {
		assertEquals("4", Solution.solution("3", "8"));
	}

	@Test
	public void testAuto98() {
		assertEquals("3", Solution.solution("3", "5"));
	}

	@Test
	public void testAuto99() {
		assertEquals("2", Solution.solution("3", "2"));
	}

	@Test
	public void testAuto100() {
		assertEquals("6", Solution.solution("13", "3"));
	}

	@Test
	public void testAuto101() {
		assertEquals("6", Solution.solution("10", "13"));
	}

	@Test
	public void testAuto102() {
		assertEquals("5", Solution.solution("10", "3"));
	}

	@Test
	public void testAuto103() {
		assertEquals("6", Solution.solution("17", "10"));
	}

	@Test
	public void testAuto104() {
		assertEquals("6", Solution.solution("7", "17"));
	}

	@Test
	public void testAuto105() {
		assertEquals("5", Solution.solution("7", "10"));
	}

	@Test
	public void testAuto106() {
		assertEquals("4", Solution.solution("7", "3"));
	}

	@Test
	public void testAuto107() {
		assertEquals("6", Solution.solution("18", "7"));
	}

	@Test
	public void testAuto108() {
		assertEquals("6", Solution.solution("11", "18"));
	}

	@Test
	public void testAuto109() {
		assertEquals("5", Solution.solution("11", "7"));
	}

	@Test
	public void testAuto110() {
		assertEquals("6", Solution.solution("15", "11"));
	}

	@Test
	public void testAuto111() {
		assertEquals("6", Solution.solution("4", "15"));
	}

	@Test
	public void testAuto112() {
		assertEquals("5", Solution.solution("4", "11"));
	}

	@Test
	public void testAuto113() {
		assertEquals("4", Solution.solution("4", "7"));
	}

	@Test
	public void testAuto114() {
		assertEquals("3", Solution.solution("4", "3"));
	}

	@Test
	public void testAuto115() {
		assertEquals("6", Solution.solution("13", "4"));
	}

	@Test
	public void testAuto116() {
		assertEquals("6", Solution.solution("9", "13"));
	}

	@Test
	public void testAuto117() {
		assertEquals("5", Solution.solution("9", "4"));
	}

	@Test
	public void testAuto118() {
		assertEquals("6", Solution.solution("14", "9"));
	}

	@Test
	public void testAuto119() {
		assertEquals("6", Solution.solution("5", "14"));
	}

	@Test
	public void testAuto120() {
		assertEquals("5", Solution.solution("5", "9"));
	}

	@Test
	public void testAuto121() {
		assertEquals("4", Solution.solution("5", "4"));
	}

	@Test
	public void testAuto122() {
		assertEquals("6", Solution.solution("11", "5"));
	}

	@Test
	public void testAuto123() {
		assertEquals("6", Solution.solution("6", "11"));
	}

	@Test
	public void testAuto124() {
		assertEquals("5", Solution.solution("6", "5"));
	}

	@Test
	public void testAuto125() {
		assertEquals("6", Solution.solution("7", "6"));
	}

	@Test
	public void testAuto126() {
		assertEquals("6", Solution.solution("1", "7"));
	}

	@Test
	public void testAuto127() {
		assertEquals("5", Solution.solution("1", "6"));
	}

	@Test
	public void testAuto128() {
		assertEquals("4", Solution.solution("1", "5"));
	}

	@Test
	public void testAuto129() {
		assertEquals("3", Solution.solution("1", "4"));
	}

	@Test
	public void testAuto130() {
		assertEquals("2", Solution.solution("1", "3"));
	}

	@Test
	public void testAuto131() {
		assertEquals("1", Solution.solution("1", "2"));
	}

	@Test
	public void testAuto132() {
		assertEquals("0", Solution.solution("1", "1"));
	}
}