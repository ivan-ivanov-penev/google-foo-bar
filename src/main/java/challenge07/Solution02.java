package challenge07;

import java.util.HashSet;
import java.util.Set;

public class Solution02 {

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

		Set<String> set = new HashSet<>();

		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (Math.sqrt(x * x + y * y) <= distance) {

					int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

					if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

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

		return set.size();
	}

	private static int[] calculateBeam(int[] dimensions, int[] your_position, int targetX, int targetY) {

		int landingX = your_position[0] + targetX;
		int landingY = your_position[1] + targetY;

		int wallX = dimensions[0];
		int wallY = dimensions[1];

		while (landingX > wallX || landingX < 0) {

			if (landingX > 0) {

				landingX = wallX - (landingX - wallX);
			}
			else {

				landingX = landingX * -1;
			}
		}

		while (landingY > wallY || landingY < 0) {

			if (landingY > 0) {

				landingY = wallY - (landingY - wallY);
			}
			else {

				landingY = landingY * -1;
			}
		}

		return new int[] { landingX, landingY };
	}
}
