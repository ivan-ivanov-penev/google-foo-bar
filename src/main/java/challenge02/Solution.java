package challenge02;

public class Solution {

	public static int[] solution(int[] l,int t) {

		for (int i = 0; i < l.length; i++) {

			int sum = l[i];

			if (sum == t) {

				return new int[] {i, i};
			}

			for (int j = i + 1; j < l.length; j++) {

				sum += l[j];

				if (sum == t) {

					return new int[] { i, j };
				}

				if (sum > t) {

					break;
				}
			}
		}

		return new int[] { -1, -1 };
	}
}
