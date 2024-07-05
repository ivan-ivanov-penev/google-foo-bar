package challenge08;

import java.util.Arrays;

public class Solution {

	public static int[][] solution(int num_buns, int num_required) {

		if (num_required > num_buns) {

			return null;
		}
		else if (num_required == 0) {

			return new int[num_buns][0];
		}
		else if (num_required == 1) {

			return new int[num_buns][1]; // will get automatically populated with the default value '0'
		}
		else if (num_buns == num_required) {

			return giveEachBunnyUniqueKey(num_buns);
		}
		else if (num_required == 2) {

			return giveEachBunnyCorrespondingKeysWhenTwoRequired(num_buns); // a bit of optimization
		}
		else {

			return giveEachBunnyCorrespondingKeys(num_buns, num_required);
		}
	}

	private static int[][] giveEachBunnyUniqueKey(int numBuns) {

		int[][] bunsWithKeys = new int[numBuns][1];

		for (int i = 0; i < bunsWithKeys.length; i++) {

			bunsWithKeys[i][0] = i;
		}

		return bunsWithKeys;
	}

	private static int[][] giveEachBunnyCorrespondingKeysWhenTwoRequired(int numBuns) {

		int[][] bunsWithKeys = new int[numBuns][numBuns - 1];

		for (int count = 0, i = 0; i < bunsWithKeys.length; i++) {

			for (int j = 0; j < bunsWithKeys[i].length; j++) {

				bunsWithKeys[i][j] = count;

				count = count < numBuns - 1 ? count + 1 : 0;
			}

			Arrays.sort(bunsWithKeys[i]);
		}

		return bunsWithKeys;
	}

	private static int[][] giveEachBunnyCorrespondingKeys(int numBuns, int numRequired) {

		int numOfRepeatingKeys = numBuns - numRequired + 1;

		int maxKeyValue = findMaxKeyValue(numBuns, numRequired);

		boolean[][] validKeyPositions = findValidKeyPositions(numBuns, numOfRepeatingKeys, maxKeyValue);

		return giveKeysToBunnies(validKeyPositions, (maxKeyValue * numOfRepeatingKeys) / numBuns);
	}

	private static int findMaxKeyValue(int numBuns, int numRequired) {

		int maxKeyValue = 0;

		for (int i = 1; i <= numRequired; i++) {

			maxKeyValue += i;
		}

		for (int i = numRequired + 2; i <= numBuns; i++) {

			int numOfRows = maxKeyValue;
			int totalKeys = i * numOfRows;
			int numOfRepeatingKeys = i - numRequired + 1;

			maxKeyValue = totalKeys / numOfRepeatingKeys;
		}

		return maxKeyValue;
	}

	//      0 1 2 3 4 5 6 7 8 9 0 1 2 3 4
	//     +-------------------------------+
	//   0 | t t t t t t t t t t f f f f f |
	//   1 | t t t t t t f f f f t t t t f |
	//   2 | t t t f f f t t t f t t t f t |
	//   3 | t f f t t f t t f t t t f t t |
	//   4 | f t f t f t t f t t t f t t t |
	//   5 | f f t f t t f t t t f t t t t |
	//     +-------------------------------+
	//  This is the goal of the below method - the 't' (true) are valid key positions
	private static boolean[][] findValidKeyPositions(int numBuns, int numOfRepeatingKeys, int maxKeyValue) {

		boolean[][] validKeyPositions = new boolean[numBuns][maxKeyValue];

		Crawler[] crawlers = createCrawlers(numOfRepeatingKeys, validKeyPositions.length - 1);

		for (int i = 0; i < validKeyPositions[0].length; i++) {

			for (int j = 0; j < crawlers.length ; j++) {

				validKeyPositions[crawlers[j].currentPosition][i] = true;
			}

			crawlers[crawlers.length - 1].incrementPosition(); // do only for the last child - this will trigger parents
		}

		return validKeyPositions;
	}

	private static Crawler[] createCrawlers(int numOfRepeatingKeys, int maxPosition) {

		Crawler[] crawlers = new Crawler[numOfRepeatingKeys];
		crawlers[0] = new Crawler(null, maxPosition - numOfRepeatingKeys + 1, 0);

		for (int i = 1; i < numOfRepeatingKeys; i++) {

			Crawler parent = crawlers[i - 1];

			crawlers[i] = new Crawler(parent, parent.maxPosition + 1, i);
		}

		return crawlers;
	}

	private static int[][] giveKeysToBunnies(boolean[][] helperArr,int numOfColumns) {

		int[][] bunsWithKeys = new int[helperArr.length][numOfColumns];

		for (int i = 0, k = 0; i < helperArr.length; i++, k = 0) {

			for (int j = 0; j < helperArr[i].length; j++) {

				if (helperArr[i][j]) {

					bunsWithKeys[i][k] = j;

					k++;
				}
			}
		}

		return bunsWithKeys;
	}

	private static class Crawler {

		private final Crawler parent;

		private final int maxPosition;

		private int currentPosition;

		private Crawler(Crawler parent, int maxPosition, int currentPosition) {

			this.parent = parent;
			this.maxPosition = maxPosition;
			this.currentPosition = currentPosition;
		}

		public void incrementPosition() {

			if (currentPosition < maxPosition) {

				currentPosition++;
			}
			else if (this.parent != null) {

				parent.incrementPosition();

				currentPosition = parent.currentPosition + 1; // reset child position when parent crawls/moves
			}
		}
	}
}
