package challenge07;

public class Solution08 {

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int count = 0;

		boolean zeroAdded = false;

		for (int x = -distance; x <= distance; x++) {

			for (int y = -distance; y <= distance; y++) {

				if (x * x + y * y <= distance * distance) {

					int[] landingSpot = calculateBeam(dimensions, your_position, x, y);

					if (landingSpot[0] == trainer_position[0] && landingSpot[1] == trainer_position[1]) {

						if (x == 0 || y == 0) {

							if (!zeroAdded) {

								zeroAdded = true;
								count++;
							}
						}
						else {

							count++;
						}
					}
				}
			}
		}

		return count;
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
}
