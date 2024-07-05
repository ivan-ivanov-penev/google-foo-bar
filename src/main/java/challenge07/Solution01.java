package challenge07;

import java.util.HashSet;
import java.util.Set;

public class Solution01 {

	private static int lcm(int a, int b) {

		a = Math.abs(a);
		b = Math.abs(b);

		int lcm = 1;

		for (int i = Math.min(a, b); i > 1; i--) {

			if (a % i == 0 && b % i == 0) {

				return i;
			}
		}

		return lcm;
	}

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		Set<String> set = new HashSet<>();

		// only the perimeter has to be checked
		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (Math.sqrt(x * x + y * y) > distance) {

					continue;
				}

				int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

				if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

					if (x == 0 || y == 0) {

						set.add("0:0");
						continue;
					}

					int lcm = lcm(x, y);

					String lcmStr = x / lcm + ":" + y /lcm;

//					System.out.println(x + ", " + y + " = " + lcmStr);

					set.add(lcmStr);
				}
			}
		}

//		System.out.println(set);
//		System.out.println(set.size());

		if (true) return set.size();

		int count = 0;

		for (int x = -distance; x <= distance; x++) {

			int y = distance;

			int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

//			System.out.println(Arrays.toString(landingSpot));

			if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

				System.out.println(x + ", " + y);

				count++;
			}
		}

		for (int y = distance; y >= -distance; y--) {

			int x = distance;

			int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

//			System.out.println(Arrays.toString(landingSpot));

			if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

				System.out.println(x + ", " + y);

				count++;
			}
		}

		for (int x = distance; x >= -distance; x--) {

			int y = -distance;

			int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

//			System.out.println(Arrays.toString(landingSpot));

			if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

				System.out.println(x + ", " + y);

				count++;
			}
		}

		for (int y = -distance; y <= distance; y++) {

			int x = -distance;

			int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

			if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

				System.out.println(x + ", " + y);

				count++;
			}
		}

		System.out.println(count);

		return count;
	}

	private static int[] calculateBeam(int[] dimensions, int[] your_position, int targetX, int targetY) {

		int startX = your_position[0];
		int startY = your_position[1];

		int landingX = startX + targetX;
		int landingY = startY + targetY;

		while (landingX > dimensions[0] || landingX < 0) {

			if (landingX > 0) {

				landingX = dimensions[0] - (landingX - dimensions[0]);
			}

			if (landingX < 0) {

				landingX = landingX * -1;
			}
		}

		while (landingY > dimensions[1] || landingY < 0) {

			if (landingY > 0) {

				landingY = dimensions[1] - (landingY - dimensions[1]);
			}

			if (landingY < 0) {

				landingY = landingY * -1;
			}
		}

		return new int[] { landingX, landingY };
	}
}
