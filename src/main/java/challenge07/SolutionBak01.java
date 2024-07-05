package challenge07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SolutionBak01 {

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

		int[] beam = calculateBeam(new int[] { 5, 4 }, new int[] { 2, 1 }, 5, 1);
		System.out.println(Arrays.toString(beam));

		Set<Pair> set = new HashSet<>();

		for (int x = 0; x < dimensions[0]; x++) {

			for (int y = 0; y < dimensions[1]; y++) {


			}
		}

		if (true) return 7;
		return set.size();
	}

	private static int[] calculateBeam(int[] dimensions, int[] your_position, int targetX, int targetY) {

		int landingX = your_position[0] + targetX;

		System.out.println("dimensions: " + Arrays.toString(dimensions));
		System.out.println("your_position: " + Arrays.toString(your_position));
		System.out.println("targetX: " + targetX + ",  targetY: " +  targetY);
		System.out.println("landingX: " + landingX);

		int wallX = dimensions[0];

		if (landingX > wallX) {

			targetX -= (wallX - your_position[0]);

			int div = targetX / wallX;
			int module = targetX % wallX;

			landingX = div % 2 == 1 ? module : (wallX - module);
		}
		System.out.println("landingX: " + landingX);

		if (landingX < 0) {

			targetX += your_position[0];

			int div = targetX / wallX;
			int module = targetX % wallX;

			landingX = div % 2 == 1 ? (wallX - module) : module;
			landingX *= -1;
		}
		System.out.println("landingX: " + landingX);

		int landingY = your_position[1] + targetY;
		System.out.println("landingY: " + landingY);

		int wallY = dimensions[1];

		if (landingY > wallY) {

			targetY -= (wallY - your_position[1]);

			int div = targetY / wallY;
			int module = targetY % wallY;

			landingY = div % 2 == 1 ? module : (wallY - module);
		}
		System.out.println("landingY: " + landingY);

		if (landingY < 0) {

			targetY += your_position[1];

			int div = targetY / wallY;
			int module = targetY % wallY;

			landingY = div % 2 == 1 ? (wallY - module) : module;
			landingY *= -1;
		}
		System.out.println("landingY: " + landingY);

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
