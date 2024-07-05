package challenge07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SolutionBak04 {

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

	public static int solution2(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

//		Set<Pair> set = new HashSet<>();

		Set<Pair> set = new LinkedHashSet<>();
//		Set<Pair> set2 = new LinkedHashSet<>();
		List<Pair> set2 = new ArrayList<>();

//		set.add(new Pair(1, 0));
//		set.add(new Pair(-1, 0));
//		set.add(new Pair(0, 1));
//		set.add(new Pair(0, -1));
//
//		set2.add(new Pair(1, 0));
//		set2.add(new Pair(-1, 0));
//		set2.add(new Pair(0, 1));
//		set2.add(new Pair(0, -1));
//
//
//		if (distance > 1) {
//
//			set.add(new Pair(1, 1));
//			set.add(new Pair(1, -1));
//			set.add(new Pair(-1, 1));
//			set.add(new Pair(-1, -1));
//
//			set2.add(new Pair(1, 1));
//			set2.add(new Pair(1, -1));
//			set2.add(new Pair(-1, 1));
//			set2.add(new Pair(-1, -1));
//		}

		for (int x = 1; x < distance; x++) {

			for (int y = 1; y < x; y++) {

				if (x * x + y * y <= distance * distance) {

					int gcd = gcd2(x, y);

					int gcdX = x / gcd;
					int gcdY = y / gcd;

					set.add(new Pair(gcdX, gcdY));
//					set.add(new Pair(gcdX, -gcdY));
//					set.add(new Pair(-gcdX, gcdY));
//					set.add(new Pair(-gcdX, -gcdY));
//
//					set.add(new Pair(gcdY, gcdX));
//					set.add(new Pair(gcdY, -gcdX));
//					set.add(new Pair(-gcdY, gcdX));
//					set.add(new Pair(-gcdY, -gcdX));

					if (y == 1 || x % y != 0) {

						set2.add(new Pair(x, y));
//						set2.add(new Pair(x, -y));
//						set2.add(new Pair(-x, y));
//						set2.add(new Pair(-x, -y));
//
//						set2.add(new Pair(y, x));
//						set2.add(new Pair(y, -x));
//						set2.add(new Pair(-y, x));
//						set2.add(new Pair(-y, -x));
					}
				}
			}
		}

		if (set2.size() != set.size()) {

			Set<Pair> setCopy = new HashSet<>(set);
			setCopy.removeAll(set2);

			Set<Pair> set2Copy = new HashSet<>(set2);
			set2Copy.removeAll(set);

			System.out.println("set: " + set);
			System.out.println("set2: " + set2);
			System.out.println("set: " + setCopy);
			System.out.println("set2: " + set2Copy);
			System.out.println("set: " + set.size());
			System.out.println("set2: " + set2.size());
			System.out.println("diff: " + (set2.size() - set.size()));

			return -1;
		}

		int count = 0;

//		for (Pair pair : set) {
//
//			if (vectorHitsTarget(pair, dimensions, your_position, trainer_position, distance)) {
//
//				count++;
//			}
//		}

		return count;
	}

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		Set<Pair> set = new HashSet<>();

		set.add(new Pair(1, 0));
		set.add(new Pair(-1, 0));
		set.add(new Pair(0, 1));
		set.add(new Pair(0, -1));


		if (distance > 1) {

			set.add(new Pair(1, 1));
			set.add(new Pair(1, -1));
			set.add(new Pair(-1, 1));
			set.add(new Pair(-1, -1));
		}

		for (int x = 1; x < distance; x++) {

			for (int y = 1; y < x; y++) {

				if (x * x + y * y <= distance * distance) {

					int gcd = gcd2(x, y);

					int gcdX = x / gcd;
					int gcdY = y / gcd;

//					set.add(new Pair(gcdX, gcdY));
//					set.add(new Pair(gcdX, -gcdY));
//					set.add(new Pair(-gcdX, gcdY));
//					set.add(new Pair(-gcdX, -gcdY));
//
//					set.add(new Pair(gcdY, gcdX));
//					set.add(new Pair(gcdY, -gcdX));
//					set.add(new Pair(-gcdY, gcdX));
//					set.add(new Pair(-gcdY, -gcdX));
				}
			}
		}

		System.out.println(set.size());

		int count = 0;

//		for (Pair pair : set) {
//
//			if (vectorHitsTarget(pair, dimensions, your_position, trainer_position, distance)) {
//
//				count++;
//			}
//		}

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

	private static boolean vectorHitsTarget(Pair pair, int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

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

		int targetX = pair.x;
		int targetY = pair.y;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int[] beamLandingSpot = calculateBeam(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (beamLandingSpot[0] == your_position[0] && your_position[1] == trainer_position[1]) {

				return false;
			}

			if (beamLandingSpot[0] == trainer_position[0] && beamLandingSpot[1] == trainer_position[1]) {

				return true;
			}

			targetX += pair.x;
			targetY += pair.y;
		}

		return false;
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
