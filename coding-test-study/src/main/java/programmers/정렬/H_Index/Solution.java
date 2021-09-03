package programmers.정렬.H_Index;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

	public int solution(int[] citations) {

		Integer b[] = Arrays.stream(citations)
			.boxed()
			.toArray(Integer[]::new);
		Arrays.sort(b, Collections.reverseOrder());
		int answer = 0;

		for (int i = 0; i < b.length; i++) {
			if (b[i] < i + 1) {
				return i;
			}
			answer++;
		}

		return answer;
	}

}
