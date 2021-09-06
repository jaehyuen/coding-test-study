package programmers.완전탐색.모의고사;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

class Solution {
	public int[] solution(int[] answers) {

		int[][]                   people = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 },
				{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };

		HashMap<Integer, Integer> result = new HashMap<Integer, Integer>();

		for (int i = 0; i < people.length; i++) {

			int cnt    = 0;
			int answer = 0;
			for (int j = 0; j < answers.length; j++) {
				if (cnt == people[i].length) {
					cnt = 0;
				}
				if (people[i][cnt] == answers[j]) {
					answer++;
				}
				cnt++;
			}

			result.put(i, answer);

		}

		List<Entry<Integer, Integer>> listEntries = new ArrayList<Entry<Integer, Integer>>(result.entrySet());

		Collections.sort(listEntries, (o1, o2) -> {

			if (o2.getValue() == o1.getValue()) {
				return o1.getKey() - o2.getKey();
			}
			return o2.getValue() - o1.getValue();
		});

		int max = listEntries.get(0)
			.getValue();

		listEntries.removeIf(map -> (map.getValue() != max));

		return listEntries.stream()
			.mapToInt(map -> map.getKey() + 1)
			.toArray();
	}
}
