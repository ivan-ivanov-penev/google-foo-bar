package challenge07;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution06 {

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

		Set<Pair> set = new HashSet<>();

		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (x * x + y * y <= distance * distance) {

					int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

					if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

						if (x == 0 || y == 0) {

							set.add(new Pair(0, 0));
						}
						else {

							int gcd = gcd(x, y);

							set.add(new Pair(x /gcd, y / gcd));
						}
					}
				}
			}
		}

		return set.size();
	}

	private static int[] calculateBeam(int[] dimensions, int[] your_position, int targetX, int targetY) {

		int landingX = your_position[0] + targetX;

		int wallX = dimensions[0];

		if (landingX > wallX) {

			targetX -= (wallX - your_position[0]);

			int div = targetX / wallX;
			int module = targetX % wallX;

			landingX = div % 2 == 1 ? module : (wallX - module);
		}

		if (landingX < 0) {

			targetX += your_position[0];

			int div = targetX / wallX;
			int module = targetX % wallX;

			landingX = div % 2 == 1 ? (wallX - module) : module;
			landingX *= -1;
		}

		int landingY = your_position[1] + targetY;

		int wallY = dimensions[1];

		if (landingY > wallY) {

			targetY -= (wallY - your_position[1]);

			int div = targetY / wallY;
			int module = targetY % wallY;

			landingY = div % 2 == 1 ? module : (wallY - module);
		}

		if (landingY < 0) {

			targetY += your_position[1];

			int div = targetY / wallY;
			int module = targetY % wallY;

			landingY = div % 2 == 1 ? (wallY - module) : module;
			landingY *= -1;
		}

		return new int[] { landingX, landingY };
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

//			if (this == o) {
//				return true;
//			}
//			if (o == null || getClass() != o.getClass()) {
//				return false;
//			}
			Pair pair = (Pair) o;
			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {

			return Objects.hash(x, y);
		}

		@Override
		public String toString() {

			return "Pair{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
}
