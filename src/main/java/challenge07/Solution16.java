package challenge07;

import java.util.HashSet;
import java.util.Set;

public class Solution16 {

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		Set<Integer> setX = findHitSpots(distance, trainer_position[0], your_position[0], dimensions[0]);
		Set<Integer> setY = findHitSpots(distance, trainer_position[1], your_position[1], dimensions[1]);

		int count = 0;

		if (vectorHitsTrainer(1, 0, dimensions, your_position, trainer_position, distance)
				|| vectorHitsTrainer(0, 1, dimensions, your_position, trainer_position, distance)
				|| vectorHitsTrainer(-1, 0, dimensions, your_position, trainer_position, distance)
				|| vectorHitsTrainer(0, -1, dimensions, your_position, trainer_position, distance)) {

			count++;
		}

		for (int x : setX) {

			for (int y : setY) {

				if (x * x + y * y <= distance * distance) {

					int add = 1;

					int startX = x + x;
					int startY = y + y;

					while (startX * startX + startY * startY <= distance * distance) {

						if (setX.contains(startX) && setY.contains(startY)) {

							add--;
						}

						startX += x;
						startY += y;
					}

					count += add;
				}
			}
		}

		return count;
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

	private static boolean vectorHitsTrainer(int vectorX, int vectorY, int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int targetX = vectorX;
		int targetY = vectorY;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int[] beamLandingSpot = calculateBeamFurthestLandingSpot(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (hits(beamLandingSpot, your_position)) {

				return false;
			}

			if (hits(beamLandingSpot, trainer_position)) {

				return true;
			}

			targetX += vectorX;
			targetY += vectorY;
		}

		return false;
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
