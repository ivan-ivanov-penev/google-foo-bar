package challenge07;

import java.util.HashSet;
import java.util.Set;

public class Solution04 {

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
			landingX = Math.abs(landingX);
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
			landingY = Math.abs(landingY);
		}

		return new int[] { landingX, landingY };
	}
}
