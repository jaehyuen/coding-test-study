package programmers.자료구조.더_맵게;

import java.util.PriorityQueue;

public class Solution {

	public int solution(int[] scoville, int K) {
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (int i = 0; i < scoville.length; i++) {

			queue.add(scoville[i]);
		};

		try {
			int answer = 0;
			while (queue.peek() < K) {
				int min1 = queue.poll();
				int min2 = queue.poll();
				queue.add(min1 + (min2 * 2));

				answer++;

			}

			return answer;	
		} catch (Exception e) {
			return -1;
		}
		
	}

}
