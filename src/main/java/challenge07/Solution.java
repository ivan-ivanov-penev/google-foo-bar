package challenge07;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class Solution {

	private static final int DECIMAL_PLACES = 7;

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int count = isTrainerHitOnStraightLine(your_position, trainer_position, distance) ? 1 : 0;

		Set<BigDecimal> xPositiveSet = new HashSet<>();
		Set<BigDecimal> xNegativeSet = new HashSet<>();

		for (int x = 1; x < distance; x++) {

			for (int y = 1; y < distance; y++) {

				count += vectorTrajectoryHitsTrainerOnly(x, y, dimensions, your_position, trainer_position, distance, xPositiveSet);
				count += vectorTrajectoryHitsTrainerOnly(x, -y, dimensions, your_position, trainer_position, distance, xPositiveSet);
				count += vectorTrajectoryHitsTrainerOnly(-x, y, dimensions, your_position, trainer_position, distance, xNegativeSet);
				count += vectorTrajectoryHitsTrainerOnly(-x, -y, dimensions, your_position, trainer_position, distance, xNegativeSet);
			}
		}

		return count;
	}

	private static boolean isTrainerHitOnStraightLine(int[] your_position, int[] trainer_position, int distance) {

		int diffX = your_position[0] - trainer_position[0];
		int diffY = your_position[1] - trainer_position[1];

		return (diffX == 0 && Math.abs(diffY) <= distance) || (diffY == 0 && Math.abs(diffX) <= distance);
	}

	private static int vectorTrajectoryHitsTrainerOnly(
			int x, int y, int[] dimensions, int[] your_position, int[] trainer_position, int distance, Set<BigDecimal> uniqueDirections) {

		int hitCode = calculateHitTrajectory(x, y, dimensions, your_position, trainer_position, distance);

		if (hitCode > 0) {

			BigDecimal vector = new BigDecimal(x).divide(new BigDecimal(y), DECIMAL_PLACES, RoundingMode.CEILING);

			if (!uniqueDirections.contains(vector)) {

				uniqueDirections.add(vector);

				if (hitCode > 1) {

					return 1;
				}
			}
		}

		return 0;
	}

	private static int calculateHitTrajectory(int vectorX, int vectorY, int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int targetX = vectorX;
		int targetY = vectorY;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int landingX = calculateLandingPoint(your_position[0], dimensions[0], targetX);
			int landingY = calculateLandingPoint(your_position[1], dimensions[1], targetY);

			if (your_position[0] == landingX && your_position[1] == landingY) { // hits me after ricochet

				return 1;
			}
			else if (trainer_position[0] == landingX && trainer_position[1] == landingY) { // hits trainer

				return 2;
			}

			targetX += vectorX;
			targetY += vectorY;
		}

		return 0;
	}

	public static int calculateLandingPoint(int startPosition, int roomLength, int distance) {

		int result = startPosition + distance;

		if (result > roomLength) {

			distance -= (roomLength - startPosition);

			int div = distance / roomLength;
			int module = distance % roomLength;

			result = div % 2 == 1 ? module : (roomLength - module);
		}
		else if (result < 0) {

			distance *= -1;
			distance -= startPosition;

			int div = distance / roomLength;
			int module = distance % roomLength;

			result = div % 2 == 1 ? (roomLength - module) : module;
		}

		return result;
	}
}
