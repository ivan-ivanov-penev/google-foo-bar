package challenge01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution01 {

	public static int[] solution(int[] data, int n) {

		if (data == null) {

			return new int[0];
		}

		if (data.length > 99) {

			throw new RuntimeException("Data must not contain more than 99 IDs!");
		}

		if (n < 0) {

			throw new RuntimeException("'n' must be a positive integer!");
		}

		List<Integer> eligibleIds = new ArrayList<>();

		Map<Integer, Integer> counter = new HashMap<>();

		for (int i = 0; i < data.length; i++) {

			int currentId = data[i];

			counter.compute(currentId, (k, v) -> v == null ? 1 : ++v);
		}

		for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {

			if (entry.getValue() <= n) {

				eligibleIds.add(entry.getKey());
			}
		}

		int[] response = new int[eligibleIds.size()];

		for (int i = 0; i < eligibleIds.size(); i++) {

			response[i] = eligibleIds.get(i);
		}

		return response;
	}
}
