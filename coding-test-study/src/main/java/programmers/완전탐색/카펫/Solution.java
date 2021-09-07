package programmers.완전탐색.카펫;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {

	public int[] solution(int brown, int yellow) {

		int                       area = brown + yellow;
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();

		for (int i = 3; i < area; i++) {
			for (int j = i; i * j <= area; j++) {
				if (i * j == area) {

					map.put(j, i);
				}

			}

		}

		List<Entry<Integer, Integer>> mapEntries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());

		mapEntries.removeIf(m -> {
			return (m.getKey() * 2) + (2 * (m.getValue() - 2)) != brown;
		});

		System.out.println(mapEntries);

		int[] answer = { mapEntries.get(0)
			.getKey(),
				mapEntries.get(0)
					.getValue() };
		return answer;

	}
}
