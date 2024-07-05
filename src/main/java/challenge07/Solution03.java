package challenge07;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution03 {

	public static class Pair {

		public final int x;

		public final int y;

		public Pair(int x, int y) {

			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object o) {

			if (this == o) {
				return true;
			}
			if (o == null || getClass() != o.getClass()) {
				return false;
			}
			Pair pair = (Pair) o;
			return x == pair.x && y == pair.y;
		}

		@Override
		public int hashCode() {

			return Objects.hash(x, y);
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

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		Set<Pair> uniqueVectors = new HashSet<>();

//		calculateBeam2(new int[] {4, 4}, new int[] {3, 3}, 16, 11, trainer_position);
//
//		if (true) return -1;

		int count = 0;

		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (Math.sqrt(x * x + y * y) <= distance) {

					boolean hitsTrainer = calculateBeam2(dimensions, your_position, x, y, trainer_position);

					if (hitsTrainer) {

						System.out.println(x + ", " + y);

						count++;

						int gcd = gcd(x, y);

						uniqueVectors.add(new Pair(x / gcd, y / gcd));
					}
				}
			}
		}

		System.out.println(count);
		System.out.println(uniqueVectors.size());

		return uniqueVectors.size();
	}


	private static boolean calculateBeam2(int[] dimensions, int[] your_position, int targetX, int targetY, int[] trainer_position) {

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
		}

//		System.out.println(landingX + ", " + landingY);

		return landingX == trainer_position[0] && landingY == trainer_position[1];
	}

	public static int solution2(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

//		int targetX = 1;
//		int targetY = -3;
//
//		System.out.println("TargetX: " + targetX + ", targetY: " + targetY);
//
//		int[] landingSpot2 = calculateBeam(dimensions, your_position, targetX, targetY);
//
//		System.out.println("Result: " + landingSpot2[0] + ", " + landingSpot2[1]);
//
//		if (true) return -1;

		Set<String> set = new HashSet<>();

		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (Math.sqrt(x * x + y * y) <= distance) {

					int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

//					System.out.println(x + ", " + y + " = " + landingSpot[0] + ", " + landingSpot[1]);

					if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

//						System.out.println(x + ", " + y);

						if (x == 0 || y == 0) {

							set.add("0:0");
						}
						else {

							int gcd = gcd(x, y);

							String gcdStr = x / gcd + ":" + y /gcd;

							set.add(gcdStr);
						}
					}
				}
			}
		}

//		System.out.println(set);
//		System.out.println(set.size());

		return set.size();
	}

	private static int[] calculateBeam(int[] dimensions, int[] your_position, int targetX, int targetY) {

		int x = your_position[0];

		boolean goRight = targetX > 0;

		for (int i = 0; i < Math.abs(targetX); i++) {

//			System.out.println("x: " + x);

			if (goRight) {

				x++;
			}
			else {

				x--;
			}

			if (x == 0) {

				goRight = true;
			}

			if (x == dimensions[0]) {

				goRight = false;
			}
		}

//		System.out.println();

		int y = your_position[1];

		boolean goUp = targetY > 0;

		for (int i = 0; i < Math.abs(targetY); i++) {

//			System.out.println("y: " + y);

			if (goUp) {

				y++;
			}
			else {

				y--;
			}

			if (y == 0) {

				goUp = true;
			}

			if (y == dimensions[1]) {

				goUp = false;
			}
		}

		return new int[] { x, y };
	}
}
