package challenge07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SolutionBak05 {

	static Set<Pair> set2 = new LinkedHashSet<>();
	static Set<Pair> set3 = new LinkedHashSet<>();

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int[] arr = calculateBeam(dimensions, your_position, -3, 6);
		System.out.println(Arrays.toString(arr));

		Set<Pair> set = new HashSet<>();

		int count = 0;

		count += vectorHitsTarget(1, 0, dimensions, your_position, trainer_position, distance);
		count += vectorHitsTarget(-1, 0, dimensions, your_position, trainer_position, distance);
		count += vectorHitsTarget(0, 1, dimensions, your_position, trainer_position, distance);
		count += vectorHitsTarget(0, -1, dimensions, your_position, trainer_position, distance);

		set.add(new Pair(1, 0));
		set.add(new Pair(0, 1));
		set.add(new Pair(-1, 0));
		set.add(new Pair(0, -1));


		if (distance > 1) {

			set.add(new Pair(1, 1));
			set.add(new Pair(1, -1));
			set.add(new Pair(-1, 1));
			set.add(new Pair(-1, -1));

			count += vectorHitsTarget(1, 1, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(1, -1, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-1, 1, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-1, -1, dimensions, your_position, trainer_position, distance);
		}

		for (int x = 1; x < distance; x++) {

			for (int y = 1; y < x; y++) {

				if (x * x + y * y <= distance * distance) {

					int gcd = gcd2(x, y);

					int gcdX2 = x / gcd;
					int gcdY2 = y / gcd;

					set.add(new Pair(gcdX2, gcdY2));
					set.add(new Pair(gcdX2, -gcdY2));
					set.add(new Pair(-gcdX2, gcdY2));
					set.add(new Pair(-gcdX2, -gcdY2));

					set.add(new Pair(gcdY2, gcdX2));
					set.add(new Pair(gcdY2, -gcdX2));
					set.add(new Pair(-gcdY2, gcdX2));
					set.add(new Pair(-gcdY2, -gcdX2));

					int gcdX = x;
					int gcdY = y;

					count += vectorHitsTarget2(gcdX, gcdY, dimensions, your_position, trainer_position);
					count += vectorHitsTarget2(gcdX, -gcdY, dimensions, your_position, trainer_position);
					count += vectorHitsTarget2(-gcdX, gcdY, dimensions, your_position, trainer_position);
					count += vectorHitsTarget2(-gcdX, -gcdY, dimensions, your_position, trainer_position);

					count += vectorHitsTarget2(gcdY, gcdX, dimensions, your_position, trainer_position);
					count += vectorHitsTarget2(gcdY, -gcdX, dimensions, your_position, trainer_position);
					count += vectorHitsTarget2(-gcdY, gcdX, dimensions, your_position, trainer_position);
					count += vectorHitsTarget2(-gcdY, -gcdX, dimensions, your_position, trainer_position);
				}
			}
		}

		count = 0;

		for (Pair pair : set) {

			int count1 = vectorHitsTarget(pair, dimensions, your_position, trainer_position, distance);
			if (count1 == 1) {

				set3.add(pair);
			}
			count += count1;
		}

		System.out.println(set2);
		System.out.println(set3);

		set2.removeAll(set3);

		System.out.println(set2);

		return count;
	}

	private static int gcd2(int x, int y) {

		for (int i = y; i > 1 ; i--) {

			if (x % i == 0 && y % i == 0) {

				return i;
			}
		}

		return 1;
	}

	private static int vectorHitsTarget2(int x, int y, int[] dimensions, int[] your_position, int[] trainer_position) {

		int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

		boolean hits = landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1];

		if (hits) {

			set2.add(new Pair(x, y));
		}
		return hits ? 1 : 0;
	}

	private static int vectorHitsTarget(Pair pair, int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		return vectorHitsTarget(pair.x, pair.y, dimensions, your_position, trainer_position, distance);
	}

	private static int vectorHitsTarget(int targetX, int targetY, int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		/*
		for (int targetX = pair.x, targetY = pair.y;
			 targetX * targetX + targetY * targetY <= distance * distance;
			 targetX += pair.x, targetY += pair.y) {


			int[] beamLandingSpot = calculateBeam(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (beamLandingSpot[0] == your_position[0] && your_position[1] == trainer_position[1]) {

				return false;
			}

			if (beamLandingSpot[0] == trainer_position[0] && beamLandingSpot[1] == trainer_position[1]) {

				return true;
			}
		}
		*/

		int originalTargetX = targetX;
		int originalTargetY = targetY;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int[] beamLandingSpot = calculateBeam(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (beamLandingSpot[0] == your_position[0] && your_position[1] == trainer_position[1]) {

				return 0;
			}

			if (beamLandingSpot[0] == trainer_position[0] && beamLandingSpot[1] == trainer_position[1]) {

				return 1;
			}

			targetX += originalTargetX;
			targetY += originalTargetY;
		}

		return 0;
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
