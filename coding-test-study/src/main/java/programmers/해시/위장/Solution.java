package programmers.해시.위장;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public int solution(String[][] clothes) {
		Map<String, Integer> clothesCntMap = new HashMap<String, Integer>();

		for (int i = 0; i < clothes.length; i++) {
			clothesCntMap.put(clothes[i][1], clothesCntMap.getOrDefault(clothes[i][1], 0) + 1);			
		}
		int answer = clothes.length;

		if (clothesCntMap.size() > 1) {
			int tmp = 1;

			for (String key : clothesCntMap.keySet()) {
				tmp *= clothesCntMap.get(key) + 1;
			}
			answer = tmp - 1;
		}

		return answer;
	}
}
