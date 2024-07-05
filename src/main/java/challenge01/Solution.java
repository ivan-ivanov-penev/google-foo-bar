package challenge01;

public class Solution {

	public static int[] solution(int[] data, int n) {

		int[] counts = new int[1000000];

		int counter = data.length;

		for (int i = 0; i < data.length; i++) {

			counts[data[i]] = ++counts[data[i]];

			if (counts[data[i]] > n) {

				counter--;

				if (counts[data[i]] == n + 1) {

					counter--;
				}
			}
		}

		if (counter < 0) {

			return new int[0];
		}

		int[] response = new int[counter];

		for (int i = 0, j = 0; i < data.length; i++) {

			if (counts[data[i]] <= n) {

				response[j] = data[i];

				j++;
			}
		}

		return response;
	}
}
