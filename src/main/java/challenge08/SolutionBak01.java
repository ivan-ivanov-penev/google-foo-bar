package challenge08;

import java.util.ArrayList;
import java.util.List;

public class SolutionBak01 {

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
		// TODO
//		else if (num_required == 2) {
//
//			return giveEachBunnyCorrespondingKeysOptimized(num_buns);
//		}
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

	private static int[][] giveEachBunnyCorrespondingKeys(int numBuns, int numRequired) {

		int numOfRepeatingKeys = numBuns - numRequired + 1;

		int maxKeyValue = findMaxKeyValue(numBuns, numRequired);

		int[][] helperArray = createHelperArray(numBuns, maxKeyValue);

		return new int[0][];
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

			for (int j = 0; j < arr[i].length; j++) {

				arr[i][j] = -1;
			}
		}

		return arr;
	}

	private static class CrawlerManager {

		private final List<Crawler> crawlers;

		public CrawlerManager(int numOfRepeatingKeys, int maxPosition) {

			this.crawlers = createCrawlers(numOfRepeatingKeys, maxPosition);
		}

		public void moveCrawlers() {

			for (int i = crawlers.size() - 1; i >= 0; i--) {

				Crawler last = crawlers.get(i);

				last.incrementPosition(-1);
			}
		}

		private static List<Crawler> createCrawlers(int numOfRepeatingKeys, int maxPosition) {

			List<Crawler> crawlers = new ArrayList<>(numOfRepeatingKeys);

			for (int i = 0; i < numOfRepeatingKeys; i++) {

				crawlers.add(new Crawler(maxPosition, i));
			}

			return crawlers;
		}
	}

	private static class Crawler {

		private final int maxPosition;

		private int currentPosition;

		private Crawler(int maxPosition, int currentPosition) {

			this.maxPosition = maxPosition;
			this.currentPosition = currentPosition;
		}

		public Position incrementPosition(int resetPositionIndex) {

			boolean canIncrement = currentPosition < maxPosition;

			if (canIncrement) {

				currentPosition++;
			}
			else {

				currentPosition = resetPositionIndex;
			}

			return new Position(currentPosition, !canIncrement);
		}
	}

	private static class Position {

		public final int newPosition;

		public final boolean hasRest;

		private Position(int newPosition, boolean hasRest) {

			this.newPosition = newPosition;
			this.hasRest = hasRest;
		}
	}
}
