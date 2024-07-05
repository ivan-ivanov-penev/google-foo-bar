package challenge05;

import java.util.Arrays;

public class Solution01 {

	/*
//			for (int i = 1, iFact = i; i < len; i++, iFact+=i) {
//
//				int start = i;
//				int end = n - iFact;
//
//				int diff = (end - start + 1) / 2;
//
//				System.out.println(start + ", " + end + " = " + diff);
//			}
//
//			for (int i = 1, iFact = i; i < len; i++, iFact += i) {
//
//				int[] base = constructBase(n, len);
//
//				System.out.println(Arrays.toString(base));
//			}
	 */

	static class Arr {

		private final int[] base;

		private final int[] copy;

		private final int n;

		private int i;

		Arr(int[] base) {

			this.base = base;
			this.copy = Arrays.copyOf(base, base.length);
			this.n = Arrays.stream(base).sum();
			this.i = base.length - 3;
		}

		public int countCurrent() {

			return (base[base.length - 1] - base[base.length - 2] + 1) / 2;
		}

		boolean flag = false;

		public boolean increment() {

			if (i < 0) {

				return false;
			}
			else {

				int sum = 0;

				int first = base[i];

				for (int j = 0; j < base.length - 1; j++) {

					if (j >= i) {

						base[j] = ++first;
					}
					sum+= base[j];
				}

				base[base.length - 1] = n -sum;

//				System.out.println(toString());

				if (base[base.length - 2] >= base[base.length - 1]) {

					flag = true;

					i--;

					return increment();
				}
				else {

					if (flag) {

						flag = false;

						i++;
					}

					return true;
				}
			}
		}

		private boolean isAsc() {

			for (int i = 1; i < base.length; i++) {

				if (base[i - 1] >= base[i]) {

					return false;
				}
			}

			return true;
		}

		@Override
		public String toString() {

			return Arrays.toString(base);
		}
	}

	private static int count(int[] base) {

		return (base[base.length - 1] - base[base.length - 2] + 1) / 2;
	}

	public static int solution(int n) {

		int count = 0;

		int maxLengthOfStairs = calculateMaxLengthOfStairs(n);

		for (int len = 2; len <= maxLengthOfStairs; len++) {

			int[] base = constructBase(n, len);

//			System.out.println(Arrays.toString(base) + " : " + count(base));

			Arr arr = new Arr(base);

//			System.out.println(arr);

			count+=arr.countCurrent();

			while (arr.increment()) {

//				System.out.println(arr);

				count+=arr.countCurrent();
			}

			if (true) continue;

			for (int i = 1; i < len; i++) {

				while (isArrayAsc(base)) {

					int[] baseCopy = Arrays.copyOf(base, base.length);
//					System.out.println("baseCopy: " + Arrays.toString(base));

					while (isArrayAsc(base)) {

//						System.out.print(i + ": " + Arrays.toString(base) + " = ");
//						System.out.println(i + ": " + Arrays.toString(base) + " = ");

						base[base.length - 2]++;
						base[base.length - 1]--;
//						System.out.println(Arrays.toString(base));
					}

					base = Arrays.copyOf(baseCopy, baseCopy.length);
					modifyBase(base, base.length - 2 -i);
//					System.out.println(Arrays.toString(base));
				}
				base = constructBase(n, len);
				modifyBase(base, base.length - 2 -i);
			}
		}

		System.out.println(count);

		return count;
	}

	private static void modifyBase(int[] base, int i) {

		if (i < 0) {

			base[0] = 200;
			return;
		}

		int sum = 0;

		for (int j = i; j < base.length - 1; j++) {

			sum++;
			base[j]++;
		}

		base[base.length - 1] -= sum;
	}

	private static void cal(int n, int len) {

		System.out.println(n + " @ " + len);

		StringBuilder sb = new StringBuilder();

		boolean isAsc = true;

		for (int j = 0; isAsc; j++) {

			int sum = 0;
			int semiLastNum = 1 + j;

			for (int i = 1 + j; i < len + j; i++) {

				sb.append(i);
				sb.append(" ");
				sum += i;

				semiLastNum = i;
			}

			sb.append(n - sum);
			sb.append("\n");

//			System.out.println((n - sum) + " : " + semiLastNum);

			isAsc = semiLastNum < n - sum;
		}

		System.out.println(sb);
	}

	public static int solution2(int n) {

		int count = 0;

		int maxLengthOfStairs = calculateMaxLengthOfStairs(n);

		for (int i = 2; i <= maxLengthOfStairs; i++) {

			int[] arr = constructBase(n, i);

			count +=asdf(arr, n);

			/*
			for (int j = i - 2; j >= 0; j--) {

				while (isArrayAsc(arr)) {

					System.out.println(Arrays.toString(arr));

					count++;

					for (int k = j; k < arr.length - 1; k++) {

						arr[k] = arr[k] + 1;
					}

					arr[arr.length - 1] = arr[arr.length - 1] - 1;
				}
			}
			*/
		}

//		System.out.println(count);
		print(4);

		return count;
	}

	private static int calculateMaxLengthOfStairs(int n) {

		int maxLength = 3;

		for (int sum = 3; sum <= n; maxLength++) {

			sum += maxLength;
		}

		return maxLength - 2;
	}

	private static boolean isArrayAsc(int[] arr) {

		for (int i = 1; i < arr.length; i++) {

			if (arr[i - 1] >= arr[i]) {

				return false;
			}
		}

		return true;
	}

	private static int[] constructBase(int n, int length) {

		int[] arr = new int[length];

		int sum = 0;

		for (int i = 1; i < length; i++) {

			arr[i - 1] = i;

			sum += i;
		}

		arr[arr.length - 1] = n - sum;

		return arr;
	}

	private static int asdf(int[] arr, int n) {

		return -1;
	}

	static void print(int len) {

		int[] arr = new int[len];

		Arrays.fill(arr, 0);


		print(arr, len - 1);
	}

	static int[] print(int[] arr , int index) {

		if (index == 0 && arr[index] == 9) {

			return arr;
		}
		else {

			if (arr[index] == 9) {

				index--;
			}

			arr[index]++;

			System.out.println(Arrays.toString(arr));

			return print(arr, index);
		}
	}

	private static int asdf3(int[] arr, int n) {

		int count = 0;

		int[] copy = Arrays.copyOf(arr, arr.length);

		for (int i = arr.length - 2; i >= 0; i--) {

			for (int j = arr.length - 2; j >= i ; j--) {

				while (isArrayAsc(copy)) {

					System.out.println(Arrays.toString(copy));

					copy[j]++;
					copy[copy.length - 1]--;

					count++;
				}

//				if (copy[j] )
			}
		}

		return count;
	}

	private static int asdf2(int[] arr, int n) {

		int count = 0;

		int[] copy = Arrays.copyOf(arr, arr.length);

		for (int i = arr.length - 2; i >= 0; i--) {

			if (i < arr.length - 2) {

				copy = Arrays.copyOf(arr, arr.length);

				int sum = 0;
				for (int j = i; j < arr.length - 1; j++) {

					copy[j]++;
					sum++;
				}
				copy[copy.length - 1] -= sum;
			}

			for (int j = arr.length - 2; j >= i; j--) {

				while (isArrayAsc(copy)) {

					System.out.println(Arrays.toString(copy));

					copy[j]++;
					copy[copy.length - 1]--;

					count++;

					System.out.println(i + " : " + j);
					System.out.println(Arrays.toString(copy));
					System.out.println();
				}


			}
		}

//		System.out.println(count);

		return count;
	}

	private static int calc(int start, int end) {

		int count = 0;

		for (int i = end, j = start; i > j; i--, j++) {

//			System.out.println(i + " @ " + j);

			count++;
		}

//		System.out.println();

		return count;
	}
}
