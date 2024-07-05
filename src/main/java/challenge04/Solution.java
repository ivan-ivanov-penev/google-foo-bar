package challenge04;

public class Solution {

	public static int solution(int[] l) {

//		Set<String> uniqueCombinations = new HashSet<>();
		int count = 0;

		for (int i = 0; i < l.length; i++) {

			int li = l[i];

			for (int j = i + 1; j < l.length; j++) {

				int lj = l[j];

				for (int k = j + 1; k < l.length; k++) {

					int lk = l[k];

					if (lk % lj == 0 && lj % li == 0) {

//						uniqueCombinations.add("" + li + lj + lk);
						count++;
					}
				}
			}
		}

//		return uniqueCombinations.size();
		return count;
	}
}
