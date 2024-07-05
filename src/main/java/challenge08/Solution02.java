package challenge08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution02 {

	private static final int DUMMY_KEY = -1;

	// C(n,r)=n!/r!(n-r)! where 'r' is the length and 'n' is the possible numbers to choose from
	public static int[][] solution(int num_buns, int num_required) {

		if (num_required > num_buns) {

			return null;
		}
		else if (num_required == 0) {

			return new int[num_buns][0];
		}
		else if (num_required == 1) {

			// will get automatically populated with the default value '0'
			return new int[num_buns][1];
		}
		else if (num_buns == num_required) {

			return giveEachBunnyUniqueKey(num_buns);
		}
		else if (num_required == 2) {

			// a bit of optimization
			return giveEachBunnyCorrespondingKeysWhenTwoRequired(num_buns);
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

		int count = 0;

		int[][] bunsWithKeys = new int[numBuns][numBuns - 1];

		for (int i = 0; i < bunsWithKeys.length; i++) {

			for (int j = 0; j < bunsWithKeys[i].length; j++) {

				bunsWithKeys[i][j] = count;

				count++;

				if (count == numBuns) {

					count = 0;
				}
			}

			Arrays.sort(bunsWithKeys[i]);
		}

		return bunsWithKeys;
	}

	private static int[][] giveEachBunnyCorrespondingKeys(int numBuns, int numRequired) {

		int maxKeyValue = findMaxKeyValue(numBuns, numRequired);

		int[][] helperArray = createHelperArray(numBuns, maxKeyValue);

		int numOfRepeatingKeys = numBuns - numRequired + 1;

		fillCrawlerPositions(helperArray, numOfRepeatingKeys);

		return cleanHelperArray(helperArray, (maxKeyValue * numOfRepeatingKeys) / numBuns);
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

	private static int[][] createHelperArray(int numBuns, int maxKeyValue) {

		int[][] arr = new int[numBuns][maxKeyValue];

		for (int i = 0; i < arr.length; i++) {

			Arrays.fill(arr[i], DUMMY_KEY);
		}

		return arr;
	}

	private static void fillCrawlerPositions(int[][] helperArr, int numOfRepeatingKeys) {

		Crawler lastChild = createCrawlers(numOfRepeatingKeys, helperArr.length - 1);

		List<Crawler> crawlers = new ArrayList<>();

		Crawler parent = lastChild;

		while (parent != null) {

			crawlers.add(parent);

			parent = parent.parent;
		}

		for (int i = 0; i < helperArr[0].length; i++) {

			for (int j = crawlers.size() - 1; j >= 0; j--) {

				helperArr[crawlers.get(j).currentPosition ][i] = i;
			}

			lastChild.incrementPosition();
		}
	}

	private static Crawler createCrawlers(int numOfRepeatingKeys, int maxPosition) {

		Crawler parent = new Crawler(null, maxPosition - numOfRepeatingKeys + 1, 0);

		for (int i = 1; i < numOfRepeatingKeys; i++) {

			parent = new Crawler(parent, parent.maxPosition + 1, i);
		}

		return parent;
	}

	private static int[][] cleanHelperArray(int[][] helperArr,int numOfColumns) {

		int[][] result = new int[helperArr.length][numOfColumns];

		for (int i = 0; i < helperArr.length; i++) {

			int k = 0;

			for (int j = 0; j < helperArr[i].length; j++) {

				if (helperArr[i][j] != DUMMY_KEY) {

					result[i][k] = j;

					k++;
				}
			}
		}

		return result;
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

		public int incrementPosition() {

			if (currentPosition < maxPosition) {

				currentPosition++;
			}
			else {

				if (this.parent != null) {

					int newPositionParent = parent.incrementPosition();

					currentPosition = newPositionParent + 1;
				}
			}

			return currentPosition;
		}
	}
}
