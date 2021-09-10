package programmers.탐욕법.체육복;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);
		List<Integer> list   = Arrays.stream(reserve)
			.boxed()
			.collect(Collectors.toList());

		int           answer = n - lost.length;

		for (int i = 0; i < lost.length; i++) {

			if (list.contains(lost[i])) {
				answer++;
				System.out.println("중복값 제거 : " + lost[i]);

				list.remove(Integer.valueOf(lost[i]));
				lost[i] = -1;
			}

		}

		for (int i = 0; i < lost.length; i++) {

			for (int test : list) {
				if (lost[i] == test || lost[i] - 1 == test || lost[i] + 1 == test) {
					answer++;

					list.remove(Integer.valueOf(test));
					break;
				}
			}
		}

		return answer;
	}
}
