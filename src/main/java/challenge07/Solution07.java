package challenge07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution07 {

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

	/*
set1.size: 17
set2.size: 20
set1.size: 4
set1: [Pair{x=-90, y=0}, Pair{x=-10, y=-60}, Pair{x=50, y=-60}, Pair{x=-30, y=-60}]
set2.size: 7
set2: [Pair{x=70, y=-50}, Pair{x=-70, y=-50}, Pair{x=-70, y=-20}, Pair{x=-70, y=40}, Pair{x=-30, y=-50}, Pair{x=-10, y=-50}, Pair{x=50, y=-50}]
	 */
	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int[] dim = new int[]{4,3};
		int[] yp = new int[]{2,1};
		int[] tp = new int[]{1,1};
		int dis = 9;

		System.out.println("dimensions: " + Arrays.toString(dim));
		System.out.println("your_position: " + Arrays.toString(yp));
		System.out.println("trainer_position: " + Arrays.toString(tp));
		System.out.println("distance: " + dis);

		int trgX = -1;
		int trgY = -6;

		System.out.println("targetX: " + trgX + ", targetY: " + trgY);

		System.out.println("-----------------------------------------");
		int[] res1 = calculateBeam(dim, yp, trgX, trgY);
		System.out.println("-----------------------------------------");
		int[] res2 = calculateBeam2(dim, yp, trgX, trgY);

		System.out.println("-----------------------------------------");
		System.out.println("res1: " + Arrays.toString(res1));
		System.out.println("res2: " + Arrays.toString(res2));

		if (true) return -1;

		int count = 0;

		boolean zeroAdded = false;

		Set<Pair> set1 = new HashSet<>();
		Set<Pair> set2 = new HashSet<>();

		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (x * x + y * y <= distance * distance) {

					int[] landingSpot1 = calculateBeam(dimensions, your_position, x, y);
					int[] landingSpot2 = calculateBeam2(dimensions, your_position, x, y);

					if (landingSpot1[0] == trainer_position[0] && landingSpot1[1] == trainer_position[1]) {

						if (x == 0 || y == 0) {

							if (!zeroAdded) {

								zeroAdded = true;
								count++;
								set1.add(new Pair(x, y));
							}
						}
						else {

							count++;
							set1.add(new Pair(x, y));
						}
					}

					if (landingSpot2[0] == trainer_position[0] && landingSpot2[1] == trainer_position[1]) {

						if (x == 0 || y == 0) {

							if (!zeroAdded) {

								zeroAdded = true;
								count++;
								set2.add(new Pair(x, y));
							}
						}
						else {

							count++;
							set2.add(new Pair(x, y));
						}
					}
				}
			}
		}

		Set<Pair> copy1 = new HashSet<>(set1);
		Set<Pair> copy2 = new HashSet<>(set2);

		System.out.println("set1.size: " + set1.size());
		System.out.println("set2.size: " + set2.size());

		if (copy1.removeAll(set2)) {

			System.out.println("set1.size: " + copy1.size());
			System.out.println("set1: " + copy1);
		}

		if (copy2.removeAll(set1)) {

			System.out.println("set2.size: " + copy2.size());
			System.out.println("set2: " + copy2);
		}

		return count;
	}

	private static int[] calculateBeam(int[] dimensions, int[] your_position, int targetX, int targetY) {

		int landingX = your_position[0] + targetX;
		int landingY = your_position[1] + targetY;

		int wallX = dimensions[0];
		int wallY = dimensions[1];

		System.out.println("landingX: " + landingX);

		while (landingX > wallX || landingX < 0) {

			System.out.println("landingX: " + landingX);

			if (landingX > 0) {

				landingX = wallX - (landingX - wallX);
			}
			else {

				landingX = landingX * -1;
			}
		}

		System.out.println("landingX: " + landingX);
		System.out.println("landingY: " + landingY);

		while (landingY > wallY || landingY < 0) {

			System.out.println("landingY: " + landingY);

			if (landingY > 0) {

				landingY = wallY - (landingY - wallY);
			}
			else {

				landingY = landingY * -1;
			}
		}
		System.out.println("landingY: " + landingY);

		return new int[] { landingX, landingY };
	}

	private static int[] calculateBeam2(int[] dimensions, int[] your_position, int targetX, int targetY) {

		int landingX = your_position[0] + targetX;

		int wallX = dimensions[0];

		System.out.println("landingX: " + landingX);

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

		int wallY = dimensions[1];

		System.out.println("landingY: " + landingY);

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

			System.out.println("landingY: " + landingY);
			System.out.println("y div: " + div);
			System.out.println("y module: " + module);
			System.out.println("div % 2: " + div % 2);

			landingY = div % 2 == 1 ? (wallY - module) : module;
			landingY *= -1;
		}

		System.out.println("landingY: " + landingY);

		return new int[] { landingX, landingY };
	}

	public static int calcX(int x, int roomX, int dist) {

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
}
