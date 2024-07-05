package challenge07;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

public class SolutionBak08 {

	private static final int DECIMAL_PLACES = 20;

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int count = 0;

		Set<BigDecimal> positiveSet = new HashSet<>();
		Set<BigDecimal> negativeSet = new HashSet<>();

		for (int x = 1; x < distance; x++) {

			for (int y = 1; y < distance; y++) {

				int res1 = vectorHitsTrainer(x, y, dimensions, your_position, trainer_position, distance);

				if (res1 > 0) {

					BigDecimal vector = new BigDecimal(x).divide(new BigDecimal(y), DECIMAL_PLACES, RoundingMode.CEILING);

					if (!positiveSet.contains(vector)) {

						positiveSet.add(vector);

						if (res1 > 1) {

							count++;
						}

//						System.out.println(x + ":" + y);
					}
				}

				int res2 = vectorHitsTrainer(x, -y, dimensions, your_position, trainer_position, distance);

				if (res2 > 0) {

					BigDecimal vector = new BigDecimal(x).divide(new BigDecimal(-y), DECIMAL_PLACES, RoundingMode.CEILING);

					if (!positiveSet.contains(vector)) {

						positiveSet.add(vector);

						if (res2 > 1) {

							count++;
						}

//						System.out.println(x + ":" + -y);
					}
				}

				int res3 = vectorHitsTrainer(-x, y, dimensions, your_position, trainer_position, distance);

				if (res3 > 0) {

					BigDecimal vector = new BigDecimal(-x).divide(new BigDecimal(y), DECIMAL_PLACES, RoundingMode.CEILING);

					if (!negativeSet.contains(vector)) {

						negativeSet.add(vector);

						if (res3 > 1) {

							count++;
						}

//						System.out.println(-x + ":" + y);
					}
				}

				int res4 = vectorHitsTrainer(-x, -y, dimensions, your_position, trainer_position, distance);

				if (res4 > 0) {

					BigDecimal vector = new BigDecimal(-x).divide(new BigDecimal(-y), DECIMAL_PLACES, RoundingMode.CEILING);

					if (!negativeSet.contains(vector)) {

						negativeSet.add(vector);

						if (res4 > 1) {

							count++;
						}

//						System.out.println(-x + ":" + -y);
					}
				}
			}
		}

		count += hitsTrainerOnStraightLine(your_position, trainer_position, distance);

		return count;
	}

	private static int hitsTrainerOnStraightLine(int[] your_position, int[] trainer_position, int distance) {

		int diffX = your_position[0] - trainer_position[0];
		int diffY = your_position[1] - trainer_position[1];

		if (diffX == 0 && Math.abs(diffY) <= distance) {

			return 1;
		}

		if (diffY == 0 && Math.abs(diffX) <= distance) {

			return 1;
		}

		return 0;
	}

	static Set<Integer> findHitSpots(int distance, int trainerPosition, int yourPosition, int roomSize) {

		Set<Integer> set = new HashSet<>();

		for (int i = 1; i <= distance; i++) {

			if (trainerPosition == calculateLandingSpot(yourPosition, roomSize, i)) {

				set.add(i);
			}

			if (trainerPosition == calculateLandingSpot(yourPosition, roomSize, -i)) {

				set.add(-i);
			}
		}

		return set;
	}

	private static int vectorHitsTrainer(int vectorX, int vectorY, int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int targetX = vectorX;
		int targetY = vectorY;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int[] beamLandingSpot = calculateBeamFurthestLandingSpot(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (hits(beamLandingSpot, your_position)) {

				return 1;
			}

			if (hits(beamLandingSpot, trainer_position)) {

				return 2;
			}

			targetX += vectorX;
			targetY += vectorY;
		}

		return 0;
	}

	private static boolean hits(int[] position1, int[] position2) {

		return position1[0] == position2[0] && position1[1] == position2[1];
	}

	private static int[] calculateBeamFurthestLandingSpot(int[] dimensions, int[] your_position, int targetX, int targetY) {

		return new int[] {
				calculateLandingSpot(your_position[0], dimensions[0], targetX),
				calculateLandingSpot(your_position[1], dimensions[1], targetY)
		};
	}

	public static int calculateLandingSpot(int startPosition, int roomLength, int distance) {

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
