package challenge01;

public class Solution02 {

	public static int[] solution(int[] data, int n) {

		int[] counts = new int[data.length];

		int counter = 0;

		for (int i = 0; i < data.length; i++) {

			for (int j = 0; j < data.length; j++) {

				if (data[i] == data[j]) {

					counts[i] = ++counts[i];
				}
			}

			if (counts[i] <= n) {

				counter++;
			}
		}

		int[] response = new int[counter];

		for (int i = 0, j = 0; i < counts.length; i++) {

			if (counts[i] <= n) {

				response[j] = data[i];
				j++;
			}
		}

		return response;
	}
}
