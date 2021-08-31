package programmers.자료구조.주식가격;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int[] solution(int[] prices) {

		List<Integer> test = new ArrayList<Integer>();
		for (int i = 0; i < prices.length; i++) {

			int sec = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (i == j) {
					continue;
				} else if (prices[i] <= prices[j]) {
					sec++;
				}else {
					sec++;
					break;
				}

			}
			;
			test.add(sec);
		}
		//System.out.println(test);
		return test.stream()
			.mapToInt(i -> i)
			.toArray();
	}

}
