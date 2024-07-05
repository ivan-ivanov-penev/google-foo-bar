package challenge07;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution14 {

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		Set<Pair> set = new HashSet<>();

		vectorHitsTrainer(1, 0, dimensions, your_position, trainer_position, distance, set);
		vectorHitsTrainer(-1, 0, dimensions, your_position, trainer_position, distance, set);
		vectorHitsTrainer(0, 1, dimensions, your_position, trainer_position, distance, set);
		vectorHitsTrainer(0, -1, dimensions, your_position, trainer_position, distance, set);

		if (distance > 1) {

			vectorHitsTrainer(1, 1, dimensions, your_position, trainer_position, distance, set);
			vectorHitsTrainer(1, -1, dimensions, your_position, trainer_position, distance, set);
			vectorHitsTrainer(-1, 1, dimensions, your_position, trainer_position, distance, set);
			vectorHitsTrainer(-1, -1, dimensions, your_position, trainer_position, distance, set);
		}

		for (int x = 1; x < distance; x++) {

			for (int y = 1; y < x; y++) {

				if (x * x + y * y <= distance * distance) {

					vectorLandsOnTrainer(x, y, dimensions, your_position, trainer_position, set);
					vectorLandsOnTrainer(x, -y, dimensions, your_position, trainer_position, set);
					vectorLandsOnTrainer(-x, y, dimensions, your_position, trainer_position, set);
					vectorLandsOnTrainer(-x, -y, dimensions, your_position, trainer_position, set);

					vectorLandsOnTrainer(y, x, dimensions, your_position, trainer_position, set);
					vectorLandsOnTrainer(y, -x, dimensions, your_position, trainer_position, set);
					vectorLandsOnTrainer(-y, x, dimensions, your_position, trainer_position, set);
					vectorLandsOnTrainer(-y, -x, dimensions, your_position, trainer_position, set);
				}
			}
		}

		return set.size();
	}

	private static void vectorLandsOnTrainer(int x, int y, int[] dimensions, int[] your_position, int[] trainer_position, Set<Pair> set) {

		int[] beamPos = calculateBeamFurthestLandingSpot(dimensions, your_position, x, y);

		if (hits(beamPos, trainer_position)) {

			int gcd = gcd(x, y);

			set.add(new Pair(x / gcd, y / gcd));
		}
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

	private static void vectorHitsTrainer(int vectorX, int vectorY, int[] dimensions, int[] your_position, int[] trainer_position, int distance, Set<Pair> set) {

		int targetX = vectorX;
		int targetY = vectorY;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int[] beamLandingSpot = calculateBeamFurthestLandingSpot(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (hits(beamLandingSpot, your_position)) {

				return;
			}

			if (hits(beamLandingSpot, trainer_position)) {

				set.add(new Pair(vectorX, vectorY));
				return;
			}

			targetX += vectorX;
			targetY += vectorY;
		}
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
