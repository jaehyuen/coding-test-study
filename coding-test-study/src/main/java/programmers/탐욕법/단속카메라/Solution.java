package programmers.탐욕법.단속카메라;

import java.util.Arrays;

class Solution {
	public int solution(int[][] routes) {

		Arrays.sort(routes, (o1, o2) -> {
			return o1[1] - o2[1];

		});

		int answer = 1;
		int cam    = routes[0][1];
		for (int i = 0; i < routes.length; i++) {

			if (routes[i][0] > cam) {
				cam = routes[i][1];
				answer++;
			}
		}

//		for (int[] ro : routes) {
//			for (int r : ro) {
//				System.out.print(r + " ");
//			}
//			System.out.println();
//		}

		return answer;
	}
}
