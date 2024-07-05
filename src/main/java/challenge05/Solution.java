package challenge05;

public class Solution {

	public static int solution(int n) {

		int totalCount = 0;

		int maxPossibleSteps = calculateMaxPossibleStepsOfStairs(n);

		for (int step = 2; step <= maxPossibleSteps; step++) {

			int[] base = constructBaseCombinationArray(n, step);

			CombinationsCalc calc = new CombinationsCalc(base, n);

			do {

				totalCount += calc.countCurrentCombinations();
			}
			while (calc.hasMoreCombinations());
		}

		return totalCount;
	}

	private static int calculateMaxPossibleStepsOfStairs(int n) {

		int maxSteps = 3;

		// skipping a couple of loops for performance purposes
		for (int sum = 3; sum <= n; maxSteps++) {

			sum += maxSteps;
		}

		return maxSteps - 2;
	}

	private static int[] constructBaseCombinationArray(int n, int step) {

		int[] base = new int[step];

		int sum = 0;

		for (int i = 1; i < step; sum+=i, i++) {

			base[i - 1] = i;
		}

		base[base.length - 1] = n - sum;

		return base;
	}

	static class CombinationsCalc {

		private final int[] base;

		private final int n;

		boolean resetIndex;

		private int currentIndex;

		CombinationsCalc(int[] base, int n) {

			// this should be a copy but performance is of higher importance here
			this.base = base;
			this.n = n;
			this.currentIndex = base.length - 3;
			this.resetIndex = false;
		}

		// actually this more of a calculation...
		public int countCurrentCombinations() {

			return (base[base.length - 1] - base[base.length - 2] + 1) / 2;
		}

		public boolean hasMoreCombinations() {

			// bottom of the recursion
			if (currentIndex < 0) {

				return false;
			}
			else {

				if (attemptToIncrementBaseOnCurrentIndex()) {

					if (resetIndex) {

						resetIndex = false;

						currentIndex = base.length - 3;
					}

					return true;
				}
				else {

					resetIndex = true;

					currentIndex--;

					return hasMoreCombinations();
				}
			}
		}

		private boolean attemptToIncrementBaseOnCurrentIndex() {

			int sum = 0;

			int firstBaseNumber = base[currentIndex];

			for (int j = 0; j < base.length - 1; j++) {

				if (j >= currentIndex) {

					base[j] = ++firstBaseNumber;
				}

				sum += base[j];
			}

			base[base.length - 1] = n - sum;

			// The semi-last number is expected to be smaller than the last number
			return base[base.length - 2] < base[base.length - 1];
		}
	}
}
