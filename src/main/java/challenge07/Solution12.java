package challenge07;

public class Solution12 {

	public static int solution(int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int count = 0;

		count += vectorHitsTarget(1, 0, dimensions, your_position, trainer_position, distance);
		count += vectorHitsTarget(-1, 0, dimensions, your_position, trainer_position, distance);
		count += vectorHitsTarget(0, 1, dimensions, your_position, trainer_position, distance);
		count += vectorHitsTarget(0, -1, dimensions, your_position, trainer_position, distance);

		if (distance > 1) {

			count += vectorHitsTarget(1, 1, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(1, -1, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-1, 1, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-1, -1, dimensions, your_position, trainer_position, distance);
		}

		for (int x = 1; x < distance; x++) {

			int y = 1;

			count += vectorHitsTarget(x, y, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(x, -y, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-x, y, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-x, -y, dimensions, your_position, trainer_position, distance);

			count += vectorHitsTarget(y, x, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(y, -x, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-y, x, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-y, -x, dimensions, your_position, trainer_position, distance);
		}

		for (int x = 3; x < distance; x++) {

			for (int y = 2; y < x - 1; y++) {

				if (gcd(x, y)) {

					count += vectorHitsTarget(x, y, dimensions, your_position, trainer_position, distance);
					count += vectorHitsTarget(x, -y, dimensions, your_position, trainer_position, distance);
					count += vectorHitsTarget(-x, y, dimensions, your_position, trainer_position, distance);
					count += vectorHitsTarget(-x, -y, dimensions, your_position, trainer_position, distance);

					count += vectorHitsTarget(y, x, dimensions, your_position, trainer_position, distance);
					count += vectorHitsTarget(y, -x, dimensions, your_position, trainer_position, distance);
					count += vectorHitsTarget(-y, x, dimensions, your_position, trainer_position, distance);
					count += vectorHitsTarget(-y, -x, dimensions, your_position, trainer_position, distance);
				}
			}

			int y = x - 1;

			count += vectorHitsTarget(x, y, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(x, -y, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-x, y, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-x, -y, dimensions, your_position, trainer_position, distance);

			count += vectorHitsTarget(y, x, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(y, -x, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-y, x, dimensions, your_position, trainer_position, distance);
			count += vectorHitsTarget(-y, -x, dimensions, your_position, trainer_position, distance);
		}

		return count;
	}

	private static boolean gcd(int x, int y) {

		for (int i = y; i > 1 ; i--) {

			if (x % i == 0 && y % i == 0) {

				return false;
			}
		}

		return true;
	}

	private static int vectorHitsTarget(int vectorX, int vectorY, int[] dimensions, int[] your_position, int[] trainer_position, int distance) {

		int targetX = vectorX;
		int targetY = vectorY;

		while (targetX * targetX + targetY * targetY <= distance * distance) {

			int[] beamLandingSpot = calculateBeam(dimensions, your_position, targetX, targetY);

			// hits me after ricochet
			if (beamLandingSpot[0] == your_position[0] && your_position[1] == trainer_position[1]) {

				return 0;
			}

			if (beamLandingSpot[0] == trainer_position[0] && beamLandingSpot[1] == trainer_position[1]) {

				return 1;
			}

			targetX += vectorX;
			targetY += vectorY;
		}

		return 0;
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
