package challenge07;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SolutionBak07 {

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		Set<Integer> listX = findHitSpots(distance, trainer_position[0], your_position[0], dimensions[0]);
		Set<Integer> listY = findHitSpots(distance, trainer_position[1], your_position[1], dimensions[1]);

		Set<Pair> combinations = new HashSet<>(listX.size() * listY.size());

		int count = 0;

		if (vectorHitsTrainer(1, 0, dimensions, your_position, trainer_position, distance)
				|| vectorHitsTrainer(0, 1, dimensions, your_position, trainer_position, distance)
				|| vectorHitsTrainer(-1, 0, dimensions, your_position, trainer_position, distance)
				|| vectorHitsTrainer(0, -1, dimensions, your_position, trainer_position, distance)) {

			combinations.add(new Pair(0, 0)); // the combination doesn't matter - it can happen only once
			count++;
		}

//		System.out.println(listX);
//		System.out.println(listY);
//		System.out.println();
//		listX.forEach(System.out::println);
//		System.out.println();
//		listY.forEach(System.out::println);
//		System.out.println();

		for (int x : listX) {

			for (int y : listY) {

				if (x * x + y * y <= distance * distance) {

//					int gcd = gcd(x, y);
//					combinations.add(new Pair(x / gcd, y / gcd));

					int add = 1;

					int startX = x + x;
					int startY = y + y;

					while (startX * startX + startY * startY <= distance * distance) {

						if (listX.contains(startX) && listY.contains(startY)) {

							add--;
						}

						startX += x;
						startY += y;
					}

					count += add;
				}
			}
		}

//		System.out.println();
//		System.out.println(combinations.size());
//		combinations.forEach(System.out::println);
//		System.out.println(count);

//		return combinations.size();
		return count;
	}

	static Set<Integer> findHitSpots(int distance, int trainerPosition, int yourPosition, int roomSize) {

		Set<Integer> list = new HashSet<>();

		for (int i = 1; i <= distance; i++) {

			if (trainerPosition == calculateLandingSpot(yourPosition, roomSize, i)) {

				list.add(i);
			}

			if (trainerPosition == calculateLandingSpot(yourPosition, roomSize, -i)) {

				list.add(-i);
			}
		}

		return list;
	}

	private static int gcd(int x, int y) {

		int absX = Math.abs(x);
		int absY = Math.abs(y);

		int smaller = Math.min(absX, absY);

		for (int i = smaller; i > 1; i--) {

			if (x % i == 0 && y % i == 0) {

				return i;
			}
		}

		return 1;
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

	public static class Pair {

		public final int x;

		public final int y;

		public Pair(int x, int y) {

			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {

			Pair pair = (Pair) o;

			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {

			return Objects.hash(x, y);
		}

		@Override
		public String toString() {

			return "{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
}
