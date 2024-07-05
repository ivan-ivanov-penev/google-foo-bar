package challenge07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SolutionBak02 {

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

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		System.out.println(Arrays.toString(calculateBeam(dimensions, your_position, -1, -2)));
		System.out.println(Arrays.toString(calculateBeam(dimensions, your_position, -10, -20)));

		if (true) return 41;

		Set<Pair> set = new HashSet<>();

		Set<Pair> set2 = new HashSet<>();

		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (x * x + y * y <= distance * distance) {

					int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

					if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

						if (x == 0 || y == 0) {

							set.add(new Pair(0, 0));

							set2.add(new Pair(0, 0));
						}
						else {

							set2.add(new Pair(x, y));

							int gcd = gcd(x, y);

							set.add(new Pair(x /gcd, y / gcd));
						}
					}
				}
			}
		}

		System.out.println("set2.size: " + set2.size());
		System.out.println("set.size: " + set.size());
		System.out.println("set: " + set);
		System.out.println("set2: " + set2);

		System.out.println();
		System.out.println();

		Set<Pair> set3 = new HashSet<>();

		for (Pair pair : set2) {

			int x = pair.x;
			int y = pair.y;

			int gcd = gcd(x, y);

			Pair e = new Pair(x / gcd, y / gcd);

			if (set3.contains(e)) {

				System.out.println(x + ", " + y);
				System.out.println(e);
			}
			set3.add(e);

		}

		return set.size();
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
