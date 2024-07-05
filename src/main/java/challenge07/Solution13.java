package challenge07;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution13 {

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		Set<Pair> set = new HashSet<>();

		vectorHitsTarget(1, 0, dimensions, your_position, trainer_position, distance, set);
		vectorHitsTarget(-1, 0, dimensions, your_position, trainer_position, distance, set);
		vectorHitsTarget(0, 1, dimensions, your_position, trainer_position, distance, set);
		vectorHitsTarget(0, -1, dimensions, your_position, trainer_position, distance, set);

		if (distance > 1) {

			vectorHitsTarget(1, 1, dimensions, your_position, trainer_position, distance, set);
			vectorHitsTarget(1, -1, dimensions, your_position, trainer_position, distance, set);
			vectorHitsTarget(-1, 1, dimensions, your_position, trainer_position, distance, set);
			vectorHitsTarget(-1, -1, dimensions, your_position, trainer_position, distance, set);
		}

		for (int x = 1; x < distance; x++) {

			for (int y = 1; y < x; y++) {

				if (x * x + y * y <= distance * distance) {

					vectorHitsTarget2(x, y, dimensions, your_position, trainer_position, set);
					vectorHitsTarget2(x, -y, dimensions, your_position, trainer_position, set);
					vectorHitsTarget2(-x, y, dimensions, your_position, trainer_position, set);
					vectorHitsTarget2(-x, -y, dimensions, your_position, trainer_position, set);

					vectorHitsTarget2(y, x, dimensions, your_position, trainer_position, set);
					vectorHitsTarget2(y, -x, dimensions, your_position, trainer_position, set);
					vectorHitsTarget2(-y, x, dimensions, your_position, trainer_position, set);
					vectorHitsTarget2(-y, -x, dimensions, your_position, trainer_position, set);
				}
			}
		}

		return set.size();
	}

	private static void vectorHitsTarget2(int x, int y, int[] dimensions, int[] your_position, int[] trainer_position, Set<Pair> set) {

		int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

		if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

			int gcd = gcd(x, y);

			set.add(new Pair(x / gcd, y / gcd));
		}
	}

	private static int gcd(int a, int b) {

		a = Math.abs(a);
		b = Math.abs(b);

		for (int i = Math.min(a, b); i > 1; i--) {

			if (a % i == 0 && b % i == 0) {

				return i;
			}
		}

		return 1;
	}

	private static void vectorHitsTarget(int targetX, int targetY, int[] dimensions, int[] your_position, int[] trainer_position, int distance, Set<Pair> set) {

		int originalTargetX = targetX;
		int originalTargetY = targetY;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int[] beamLandingSpot = calculateBeam(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (beamLandingSpot[0] == your_position[0] && your_position[1] == trainer_position[1]) {

				return;
			}

			if (beamLandingSpot[0] == trainer_position[0] && beamLandingSpot[1] == trainer_position[1]) {

				int gcd = gcd(targetX, targetY);

				if (targetX == -3 && targetY == -6) {

					System.out.println(set);
				}

				set.add(new Pair(targetX / gcd, targetY / gcd));

				return;
			}

			targetX += originalTargetX;
			targetY += originalTargetY;
		}
	}

	private static int[] calculateBeam(int[] dimensions, int[] your_position, int targetX, int targetY) {

		return new int[] {
				calc(your_position[0], dimensions[0], targetX),
				calc(your_position[1], dimensions[1], targetY)
		};
	}

	public static int calc(int x, int roomX, int dist) {

		int result = x + dist;

		if (result > roomX) {

			dist -= (roomX - x);

			int div = dist / roomX;
			int module = dist % roomX;

			result = div % 2 == 1 ? module : (roomX - module);
		}

		if (result < 0) {

			dist *= -1;
			dist -= x;

			int div = dist / roomX;
			int module = dist % roomX;

			result = div % 2 == 1 ? (roomX - module) : module;
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
