package challenge05;

public class Test {

/*
n will always be at least 3 (so you can have a staircase at all), but no more than 200

-- Java cases --
Input:
Solution.solution(3)
Output:
    1

Input:
Solution.solution(200)
Output:
    487067745
 */

	private static final boolean SHOULD_VERIFY = true;

	public static void main(String[] args) {

//		executeAndVerify(3, 1);
		executeAndVerify(200, 487_067_745);
		executeAndVerify(200, 487_067_746);
//		executeAndVerify(4, 1);
//		executeAndVerify(5, 2);
//		executeAndVerify(6, 3);
//		executeAndVerify(7, 4);
//		executeAndVerify(8, 5);
//		executeAndVerify(9, 7);
//		executeAndVerify(10, 9);
//		executeAndVerify(11, 11);
//		executeAndVerify(17, 37);
//		executeAndVerify(32, 37);
	}

	private static void executeAndVerify(int input, int expected) {

		System.out.println(input + " : " + expected);

		int actual = Solution.solution(input);

		verify(actual == expected, "Expected '" + expected + "' but actual is: " + actual);

		System.out.println("#########################################################################################");
	}

	private static void verify(boolean condition, String message) {

		if (SHOULD_VERIFY && !condition) {

			System.err.println("ERROR");

			try { Thread.sleep(100L); } catch (Exception e) { e.printStackTrace(); }

			System.out.println(message);
		}
	}

/*
3 = 12
6 = 123
10 = 1234
15 = 12345
21 = 123456
28 = 1234567
36 = 12345678
45 = 123456789
55 = 123456789 10
66 = 123456789 10 11
78 = 123456789 10 11 12
91 = 123456789 10 11 12 13
105 = 123456789 10 11 12 13 14
120 = 123456789 10 11 12 13 14 15
136 = 123456789 10 11 12 13 14 15 16
153 = 123456789 10 11 12 13 14 15 16 17
171 = 123456789 10 11 12 13 14 15 16 17 18
190 = 123456789 10 11 12 13 14 15 16 17 18 19
210 = 123456789 10 11 12 13 14 15 16 17 18 19 20

6	3
10	4
15	5
21	6
28	7
36	8
45	9
55	10
66	11
78	12
91	13
105	14
120	15
136	16
153	17
171	18
190	19
210	20

17
01 16
02 15
03 14
04 13
05 12
06 11
07 10
08 09
01 02 14
01 03 13
01 04 12
01 05 11
01 06 10
01 07 09
02 03 12
02 04 11
02 05 10
02 06 09
02 07 08
03 04 10
03 05 09
03 06 08
04 05 08
04 06 07
01 02 03 11
01 02 04 10
01 02 05 09
01 02 06 08
01 03 04 09
01 03 05 08
01 03 06 07
01 04 05 07
02 03 04 08
02 03 05 07
02 04 05 06
01 02 03 04 07
01 02 03 05 06




01 16
02 15
03 14
04 13
05 12
06 11
07 10
08 09

01 02 14
01 03 13
01 04 12
01 05 11
01 06 10
01 07 09

02 03 12
02 04 11
02 05 10
02 06 09
02 07 08

03 04 10
03 05 09
03 06 08

04 05 08
04 06 07

01 02 03 11
01 02 04 10
01 02 05 09
01 02 06 08

01 03 04 09
01 03 05 08
01 03 06 07

01 04 05 07

02 03 04 08
02 03 05 07

02 04 05 06

01 02 03 04 07
01 02 03 05 06



-----------------1 + 1 (8)
01 16

-----------------2 + 1 (16)	01 02 14
02 14 (6)

03 12 (5)

04 10 (3)

05 08 (2)

----------------3 + 1 (12)	01 02 03 11
03 11 (4)

04 09 (3)

05 07 (1)

04 08 (2)

05 06 (1)

----------------4 + 1 (2)	01 02 03 04 07
04 07

 */
}
