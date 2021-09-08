package programmers.탐욕법.구명보트;

import java.util.Arrays;

class Solution {
	public int solution(int[] people, int limit) {

		Arrays.sort(people);

		int answer = 0;
		int i      = 0;

		for (int j = people.length - 1; j >= i; j--) {
			if (people[i] + people[j] <= limit) {
				i++;
			}
			answer++;

		}

		return answer;

	}
}
